import org.antlr.v4.runtime.CommonTokenStream;
import sun.jvm.hotspot.runtime.linux_amd64.LinuxAMD64JavaThreadPDAccess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Visitor extends LABaseVisitor {

    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();

    CommonTokenStream cts;
    List<Parametros> listaP = new ArrayList<>();
    LinkedList<List<String>> pilhaTipo = new LinkedList<>() ;
    Registro registro = new Registro("");


    public void setTokenStream(CommonTokenStream c){
        cts = c;
    }


    @Override
    public Object visitPrograma(LAParser.ProgramaContext ctx) {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));

        super.visitPrograma(ctx);

        pilhaDeTabelas.desempilhar();

        return null;
    }
    @Override public String visitCmdRetorne(LAParser.CmdRetorneContext ctx) {
        if(pilhaDeTabelas.topo()!= null)
            if(pilhaDeTabelas.topo().getEscopo().equals("global") || pilhaDeTabelas.topo().getTipoEscopo().equals("procedimento"))
              Saida.println("Linha "+ctx.getStart().getLine()+": comando retorne nao permitido nesse escopo");
        super.visitCmdRetorne(ctx);
        return "";
    }


    @Override
    public Object visitDeclaracao_local_constante(LAParser.Declaracao_local_constanteContext ctx) {
        TabelaDeSimbolos escopoAtual = pilhaDeTabelas.topo();
        String tipo = (String) super.visitTipo_basico(ctx.tipo_basico());

        if(!escopoAtual.existeSimbolo(ctx.nome.getText())) {
                escopoAtual.adicionarSimbolo(ctx.nome.getText(), tipo);
        } else{
            Saida.println("Linha "+ctx.nome.getLine()+": identificador " +ctx.nome.getText()+ " ja declarado anteriormente");

        }

        super.visitDeclaracao_local_constante(ctx); // talvez precise deixar isso aqui pra ele visitar os filhos, precisa confirmar

        return null;
    }
    @Override
    public String visitRegistro(LAParser.RegistroContext ctx) {
        if (registro == null)
            registro.setNome("$basico");

        for(LAParser.VariavelContext var : ctx.variavel()){
            for(LAParser.Identificador_varContext i : var.identificador_var())
                registro.adicionarSimbolo(i.getText(),var.tipo().getText());

        }
        super.visitRegistro(ctx);
        return "";
    }

        @Override
    public Object visitDeclaracao_local_tipo(LAParser.Declaracao_local_tipoContext ctx) {
        registro.setNome(ctx.nome1.getText());

        super.visitDeclaracao_local_tipo(ctx); // talvez precise deixar isso aqui pra ele visitar os filhos, precisa confirmar

        return null;
    }

    @Override
    public Object visitDeclaracao_global_procedimento(LAParser.Declaracao_global_procedimentoContext ctx) {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos(ctx.IDENT().getText()));
        pilhaDeTabelas.topo().setTipoEscopo("procedimento");
        Parametros p =new Parametros(ctx.IDENT().getText());
        ArrayList<String> parametros = new ArrayList<>();
        for ( LAParser.ParametroContext pc :   ctx.parametros().parametro()){
            parametros.add(pc.tipo_estendido().getText());
            pilhaDeTabelas.topo().adicionarSimbolo(pc.identificador(0).getText(),pc.tipo_estendido().getText());

        }
        p.setLista(parametros);
        listaP.add(p);

        super.visitDeclaracao_global_procedimento(ctx);

        pilhaDeTabelas.desempilhar();

        return null;
    }

    @Override
    public Object visitDeclaracao_global_funcao(LAParser.Declaracao_global_funcaoContext ctx) {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos(ctx.IDENT().getText()));
        pilhaDeTabelas.topo().setTipoEscopo("funcao");
        Parametros p =new Parametros(ctx.IDENT().getText());
        ArrayList<String> parametros = new ArrayList<>();
        for ( LAParser.ParametroContext pc :   ctx.parametros().parametro()){
            parametros.add(pc.tipo_estendido().getText());
            pilhaDeTabelas.topo().adicionarSimbolo(pc.identificador(0).getText(),pc.tipo_estendido().getText());

        }
        p.setLista(parametros);
        p.setRetorno(ctx.tipo_estendido().getText());
        listaP.add(p);

        super.visitDeclaracao_global_funcao(ctx);

        pilhaDeTabelas.desempilhar();

        return null;
    }

    @Override
    public Object visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx)  {
        String var = "";

        if(pilhaDeTabelas.existeSimbolo(ctx.identificador().nome3.getText())) {
            if(ctx.ponteiro != null)
                var = "^";
            var +=ctx.identificador().getText();
            String tipoVar = pilhaDeTabelas.getTipoSimbolo(ctx.identificador().nome3.getText());
            if (tipoVar != null) {
                if (tipoVar.equals(registro.getNome())) {
                    if (ctx.identificador().tipoRegistro != null) {
                        String ident_var = ctx.identificador().tipoRegistro.getText();
                        tipoVar = registro.getTipo(ident_var);
                    }
                }
                String tipoAtrb = verificaTipo(ctx.expressao());

                if (tipoVar.charAt(0) == '^') {
                    if (var.charAt(0) == '^') {
                        tipoVar = var.substring(1);
                    } else {
                        tipoVar = "endereco";
                    }
                }

                if (tipoVar.equals("real") && tipoAtrb.equals("inteiro"))
                    tipoAtrb = "real";
                if (!tipoVar.equals(tipoAtrb)) {
                    Saida.println("Linha " + ctx.identificador().nome3.getLine() + ": atribuicao nao compativel para " + var);
                }
            }
        }else {

            Saida.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.identificador().getText() + " nao declarado");
        }


        return null;
    }
    @Override
    public Object visitVariavel(LAParser.VariavelContext ctx){
        TabelaDeSimbolos escopoAtual = pilhaDeTabelas.topo();

        String tipo = ctx.tipo().getText();
        if(ctx.tipo().registro() != null)
            tipo="$basico";
        for(LAParser.Identificador_varContext ctx_identificador: ctx.identificador_var()) {
            String nomeVar = (String) visitIdentificador_var(ctx_identificador);
            int i = 0;
            boolean encontrou = false;
            Parametros p;
            if(!listaP.isEmpty()) {
                p = listaP.get(0);
                while (i < listaP.size() && !encontrou) {
                    p = listaP.get(i);
                    if (p.getIdentificador().equals(nomeVar)) {
                        encontrou = true;
                    }
                    i++;
                }
            }


            if (!escopoAtual.existeSimbolo(nomeVar) && !nomeVar.equals(registro.getNome()) && !encontrou ){
                escopoAtual.adicionarSimbolo(nomeVar, tipo);
            } else {
                Saida.println("Linha " + ctx_identificador.nome2.getLine() + ": identificador " + nomeVar + " ja declarado anteriormente");
            }
        }
        super.visitVariavel(ctx);
        return "";
    }


    @Override
    public String visitIdentificador_var(LAParser.Identificador_varContext ctx) {
        return ctx.nome2.getText();
    }

    @Override
    public String visitIdentificador(LAParser.IdentificadorContext ctx) {
        if(!pilhaDeTabelas.existeSimbolo(ctx.nome3.getText())) {
            Saida.println("Linha " + ctx.nome3.getLine() + ": identificador " + ctx.getText() + " nao declarado");

        }else{
            if (pilhaDeTabelas.getTipoSimbolo(ctx.nome3.getText()).equals(registro.getNome()) ){
                boolean achou = false;
                if(ctx.tipoRegistro != null) {
                    achou = registro.existeSimbolo(ctx.tipoRegistro.getText());


                    if (!achou) {
                        Saida.println("Linha " + ctx.nome3.getLine() + ": identificador " + ctx.getText() + " nao declarado");
                    }
                }
            }


        }

      //  super.visitIdentificador(ctx); // talvez precise deixar isso aqui pra ele visitar os filhos, precisa confirmar

        return null;
    }



    @Override
    public String visitParcela_unario_ident(LAParser.Parcela_unario_identContext ctx) {
        String tipo = null;
        if(ctx != null) {
            if(ctx.expressao() == null) {
                if (!pilhaDeTabelas.existeSimbolo(ctx.IDENT().getText())) {
                    Saida.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().getText() + " nao declarado");
                }
            }else {
                int i = 0;
                boolean encontrou = false;
                Parametros p;
                p = listaP.get(0);
                while (i < listaP.size() && !encontrou) {
                    p = listaP.get(i);
                    if (p.getIdentificador().equals(ctx.IDENT().getText())) {
                        encontrou = true;
                    }
                    i++;
                }

                if (!encontrou) {
                    Saida.println("Erro semantico: " + ctx.IDENT().getText() + "Funçao inexistente");
                } else {
                    int total = 0;

                    for (i = 0; i < p.getLista().size() && ctx.expressao(i) != null; i++) {

                        if (p.getLista().get(i).equals(verificaTipo(ctx.expressao(i)))) {
                            total++;
                        }
                    }
                    if (total != p.getLista().size()) {
                        Saida.println("Linha " + ctx.getStart().getLine() + ": incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                    }

                }
            }
        }
        super.visitParcela_unario_ident(ctx);
        return "";
    }


    //NECESSARIO VERIFICAR SE O TIPO EXISTE?

    @Override
    public String visitTipo_basico_ident(LAParser.Tipo_basico_identContext ctx) {
        String tipo_basico = "";
        if(ctx.tipo_basico() !=null)
            if(super.visitTipo_basico(ctx.tipo_basico()) != null)
                tipo_basico = ctx.tipo_basico().getText();
        if(ctx.nome4 != null)
            tipo_basico = ctx.nome4.getText();

        if(tipo_basico != ""){
            if(tipo_basico.equals("real") || tipo_basico.equals("inteiro")  || tipo_basico.equals("literal")  || tipo_basico.equals("logico") || tipo_basico.equals(registro.getNome()) ){
                return tipo_basico;
            } else{
                Saida.println("Linha "+ctx.nome4.getLine()+": tipo " + ctx.nome4.getText() + " nao declarado");
            }
        }else {
            return tipo_basico;
        }
        super.visitTipo_basico_ident(ctx);
        return null;
    }




    @Override
    public Object visitCmdSe(LAParser.CmdSeContext ctx) {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos(ctx.expressao().getText())); //????

        super.visitCmdSe(ctx);

        pilhaDeTabelas.desempilhar();

        return null;
    }

    @Override
    public Object visitCmdCaso(LAParser.CmdCasoContext ctx) {
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos(ctx.exp_aritmetica().getText())); //????

        super.visitCmdCaso(ctx);

        pilhaDeTabelas.desempilhar();

        return null;
    }

    @Override
    public Object visitCmdPara(LAParser.CmdParaContext ctx) {

        pilhaDeTabelas.empilhar(new TabelaDeSimbolos(ctx.IDENT().getText()));

        super.visitCmdPara(ctx);

        pilhaDeTabelas.desempilhar();

        return null;
    }

    @Override
    public Object visitCmdEnquanto(LAParser.CmdEnquantoContext ctx) {

        pilhaDeTabelas.empilhar(new TabelaDeSimbolos(ctx.expressao().getText())); //????

        super.visitCmdEnquanto(ctx);

        pilhaDeTabelas.desempilhar();

        return null;
    }

    @Override
    public Object visitCmdFaca(LAParser.CmdFacaContext ctx) {

        pilhaDeTabelas.empilhar(new TabelaDeSimbolos(ctx.expressao().getText())); //????

        super.visitCmdFaca(ctx);

        pilhaDeTabelas.desempilhar();

        return null;
    }


    @Override
    public Object visitCmdChamada(LAParser.CmdChamadaContext ctx) {
        int i = 0;
        boolean encontrou = false;
        Parametros p;
        p = listaP.get(0);
        while (i < listaP.size() && !encontrou) {
            p = listaP.get(i);
            if (p.getIdentificador().equals(ctx.IDENT().getText())) {
                encontrou = true;
            }
            i++;
        }

        if (!encontrou) {
            Saida.println("Erro semantico: " + ctx.IDENT().getText() + "Funçao inexistente");
        } else {
            int total = 0;

            for (i = 0; i < p.getLista().size() && ctx.expressao(i) != null; i++) {

                if (p.getLista().get(i).equals(verificaTipo(ctx.expressao(i)))) {
                    total++;
                }
            }
            if (total != p.getLista().size()) {
                Saida.println("Linha " + ctx.getStart().getLine() + ": incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
            }

        }
        super.visitCmdChamada(ctx);

        return null;
    }



    private String verificaTipo(LAParser.ExpressaoContext exp) {
        String tp = "erro";
        if(exp.termo_logico() != null){
            tp = verificaTipo(exp.termo_logico(0));

            for(LAParser.Termo_logicoContext termoLogico: exp.termo_logico()) {
                if(!verificaTipo(termoLogico).equals(tp) &&
                    !((verificaTipo(termoLogico).equals("inteiro") && tp.equals("real")) || (tp.equals("real") && verificaTipo(termoLogico).equals("inteiro")))) {
                    tp = "erro";
                }

            }
        }

        return tp;
    }

    private String verificaTipo(LAParser.Termo_logicoContext termo) {
        String tp = "erro";
        if(termo.fator_logico() != null) {
            tp = verificaTipo(termo.fator_logico(0));


            for (LAParser.Fator_logicoContext fator_logico : termo.fator_logico()) {
                if (!verificaTipo(fator_logico).equals(tp) &&
                        !((verificaTipo(fator_logico).equals("inteiro") && tp.equals("real")) || (tp.equals("real") && verificaTipo(fator_logico).equals("inteiro")))) {
                    tp = "erro";
                }
            }
        }
        return tp;
    }

    private String verificaTipo(LAParser.Fator_logicoContext fator_logico) {
        String tp = "erro";
        if(fator_logico.parcela_logica()!= null)
            tp = verificaTipo(fator_logico.parcela_logica());
        return tp;
    }
    private String verificaTipo(LAParser.Parcela_logicaContext parcela_logica) {

        if(parcela_logica.valores_logicos != null)
            return "logico";
        else {
            String tp = "erro";
            if(parcela_logica.exp_relacional()!= null)
                tp = verificaTipo(parcela_logica.exp_relacional());
            return tp;
        }
    }
    private String verificaTipo(LAParser.Exp_relacionalContext exp_relacional){
        String tp = "erro";
        if(exp_relacional.exp1 != null)
            tp = verificaTipo(exp_relacional.exp1);

        if(exp_relacional.op_relacional() != null){
            return "logico";
        }else{
            return tp;
        }

    }
    private String verificaTipo(LAParser.Exp_aritmeticaContext exp_arit){
        String tp = "erro";
        if(exp_arit.termo1 != null) {
                tp = verificaTipo(exp_arit.termo1);
            for (LAParser.TermoContext termo : exp_arit.termo()) {
                if(termo != null && tp != null) {
                    if (!verificaTipo(termo).equals(tp) &&
                            !((verificaTipo(termo).equals("inteiro") && tp.equals("real")) || (tp.equals("real") && verificaTipo(termo).equals("inteiro")))) {
                        tp = "erro";
                    }
                }

            }
        }
        return tp;
    }
    private String verificaTipo(LAParser.TermoContext termo){
        String tp = "erro";
        if(termo.fator1 != null) {
            tp = verificaTipo(termo.fator1);
            for (LAParser.FatorContext fator : termo.fator()) {
                if (tp != null && fator != null) {
                    if (!verificaTipo(fator).equals(tp) &&
                            !((verificaTipo(fator).equals("inteiro") && tp.equals("real")) || (tp.equals("real") && verificaTipo(fator).equals("inteiro")))) {
                        tp = "erro";
                    }
                }
            }
        }
        return tp;
    }
    private String verificaTipo(LAParser.FatorContext fator){
        String tp = "erro";
        if(fator.parcela1 != null) {
            tp = verificaTipo(fator.parcela1);
            for (LAParser.ParcelaContext parcela : fator.parcela()) {
                if (tp != null && parcela != null) {
                    if (!verificaTipo(parcela).equals(tp) &&
                            !((verificaTipo(parcela).equals("inteiro") && tp.equals("real")) || (tp.equals("real") && verificaTipo(parcela).equals("inteiro")))) {
                        tp = "erro";
                    }
                }
            }
        }
        return tp;
    }
    private String verificaTipo(LAParser.ParcelaContext parcela){

        if(parcela.parcela_unario() != null) {
            if (parcela.parcela_unario().parcela_unario_exp() != null) {
                LAParser.ExpressaoContext exp = parcela.parcela_unario().parcela_unario_exp().expressao();
                return verificaTipo(exp);
            }
            if (parcela.parcela_unario().parcela_unario_int() != null)
                return "inteiro";
            if (parcela.parcela_unario().parcela_unario_real() != null)
                return "real";
            if (parcela.parcela_unario().parcela_unario_identificador() != null) {
                String identificador = parcela.parcela_unario().parcela_unario_identificador().identificador().nome3.getText();
                String tipo =  pilhaDeTabelas.getTipoSimbolo(identificador);
                if(tipo.equals(registro.getNome())){
                    if( parcela.parcela_unario().parcela_unario_identificador().identificador().tipoRegistro != null) {
                        String o = parcela.parcela_unario().parcela_unario_identificador().identificador().tipoRegistro.getText();
                        tipo = registro.getTipo(o);
                    }
                }
                return tipo;
            }
            if (parcela.parcela_unario().parcela_unario_ident() != null) {
                String tp = "erro";
                int i = 0;
                boolean encontrou = false;
                Parametros p;
                p = listaP.get(0);
                while (i < listaP.size() && !encontrou) {
                    p = listaP.get(i);
                    if (p.getIdentificador().equals(parcela.parcela_unario().parcela_unario_ident().IDENT().getText())) {
                        encontrou = true;
                    }
                    i++;
                }
                if(encontrou)
                    tp = p.getRetorno();
                return tp;
            }

        }else{
            if(parcela.parcela_nao_unario().oi != null)
                return "literal";
            return "endereco";
        }
        return "";
    }



}

