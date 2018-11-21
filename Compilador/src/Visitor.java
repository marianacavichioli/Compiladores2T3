import com.apple.eawt.AppEvent;
import org.antlr.v4.runtime.CommonTokenStream;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


//TODO: ARRUMAR TODOS OS EXEMPLOS

public class Visitor extends hortBaseVisitor {

    CommonTokenStream cts;
    RelatorioHorta rh = new RelatorioHorta();


    public void setTokenStream(CommonTokenStream c) {
        cts = c;
    }


    @Override
    public Object visitHorta(hortParser.HortaContext context) {
        rh.setNome(context.IDENT().getText());
        super.visitHorta(context);
        return null;
    }

    @Override
    public Object visitEstacao(hortParser.EstacaoContext context) {
        rh.setEstacao_base(context.getText());
        rh.setEstacao_atual(context.getText());
        super.visitEstacao(context);
        return null;
    }


    @Override
    public Object visitDeclaracoes(hortParser.DeclaracoesContext context) {
        rh.setLocal(context.local.getText());
        super.visitDeclaracoes(context);
        return null;
    }

    @Override
    public Object visitCmd(hortParser.CmdContext context){


        acoes_decrementa_dia(context.getStart().getLine());

        super.visitCmd(context);

        return null;
    }

    private void acoes_decrementa_dia(int line) {
        for (int i = rh.getDias_passados(); i > 0; i--){
            rh.aumentaQtd_dias_plantado_slot(1);

            if (!rh.decrementar_dia()) {
                System.out.println("Linha " + line + ": solo seco para a semente plantada");
                rh.setPerdeu_jogo(true);
            }
        }
    }

    @Override
    public Object visitAcao_capinar(hortParser.Acao_capinarContext context) {
        String slot = context.slot().getText();
        int n;
        if (slot.equals("todos"))
            n = 0;
        else
            n = Integer.parseInt(slot.substring(slot.length() - 1));

        rh.setSlot_capinado(n, true);

        // Entao precisa falar que nao está mais adubado nem regado
        rh.setSlot_adubado(n,false);
        rh.setSlot_regado(n,0);

        super.visitAcao_capinar(context);
        return null;
    }


    @Override
    public Object visitAcao_adubar(hortParser.Acao_adubarContext context) {

        String slot = context.slot().getText();

        int n;
        if (slot.equals("todos")) {
            n = 0;
        } else
            n = Integer.parseInt(slot.substring(slot.length() - 1));

        if (rh.getSlot_capinado(n)) {
            rh.setSlot_adubado(n, true);

            // Entao precisa falar que nao está mais regado
            rh.setSlot_regado(n,0);
        } else {
            System.out.println("Linha " + context.getStart().getLine() + ": solo nao capinado");
            rh.setSlot_capinado(n, true);
            rh.setSlot_adubado(n, true);
            rh.setPerdeu_jogo(true);
        }

        super.visitAcao_adubar(context);
        return null;
    }

    @Override
    public Object visitAcao_regar(hortParser.Acao_regarContext context) {
        String slot = context.slot().getText();
        int n;

        if (slot.equals("todos"))
            n = 0;
        else
            n = Integer.parseInt(slot.substring(slot.length() - 1));

        if (rh.getSlot_adubado(n)) {
            int qtd;
            if (context.intensidade().getText().equals("muito")) {
                qtd = 2;
            } else {
                qtd = 1;
            }
            //System.out.println("vou regar " + n + " qtd " + qtd);
            if (!rh.incrementaSlot_regado(n, qtd)) {
                System.out.println("Linha " + context.getStart().getLine() + ": solo encharcado");
                rh.setPerdeu_jogo(true);
            }
        } else {
            System.out.println("Linha " + context.getStart().getLine() + ": solo nao adubado");

            //Recuperacao de erro
            System.out.println("recuperacao erro");
            rh.setSlot_adubado(n, true);
            rh.setPerdeu_jogo(true);
            int qtd;
            if (context.intensidade().getText().equals("muito")) {
                qtd = 2;
            } else {
                qtd = 1;
            }
            if (!rh.incrementaSlot_regado(n, qtd)) {
                System.out.println("Linha " + context.getStart().getLine() + ": solo encharcado");
                rh.setPerdeu_jogo(true);
            }
        }

        super.visitAcao_regar(context);
        return null;
    }

    @Override
    public Object visitPeriodo_tempo(hortParser.Periodo_tempoContext context) {

        System.out.println("Dia: " + rh.getQtd_dias());

        rh.setDias_passados(0);

        if (rh.getQtd_dias() < Integer.parseInt(context.NUM_INT().getText())) { // Verificando se nao ta voltando no tempo
            if (!context.op_data().getText().equals("Dia")) {
                System.out.println("Linha " + context.getStart().getLine() + ": data invalida");
                rh.setPerdeu_jogo(true);
            } else {


                //System.out.println("Dias do texto : " + context.NUM_INT().getText() + " dias no programa " + rh.getQtd_dias());
                rh.setDias_passados(Integer.parseInt(context.NUM_INT().getText()) - rh.getQtd_dias());

                //System.out.println("Dias passados: " + rh.getDias_passados());

                rh.setQtd_dias(Integer.parseInt(context.NUM_INT().getText()));
                //System.out.println("Dia: " + rh.getQtd_dias());

            }
        }
        else{
            System.out.println("Linha " + context.getStart().getLine() + ": nao é permitido voltar no tempo");
            rh.setPerdeu_jogo(true);
        }



        super.visitPeriodo_tempo(context);
        return null;
    }

    @Override
    public Object visitAcao_plantar(hortParser.Acao_plantarContext context) {

        //System.out.println("entrei plantar");

        //variáveis para simplificar o código
        boolean primavera = rh.getEstacao_atual().equals("primavera");
        boolean outono = rh.getEstacao_atual().equals("outono");
        boolean inverno = rh.getEstacao_atual().equals("inverno");
        boolean verao = rh.getEstacao_atual().equals("verao");

        boolean hortela = context.semente().getText().equals("hortelã");
        boolean alface = context.semente().getText().equals("alface");
        boolean couve = context.semente().getText().equals("couve");
        boolean beterraba = context.semente().getText().equals("beterraba");
        boolean abobora = context.semente().getText().equals("abobora");
        boolean abobrinha = context.semente().getText().equals("abobrinha");
        boolean batata = context.semente().getText().equals("batata");
        boolean morango = context.semente().getText().equals("morango");


        String slot = context.slot().getText();
        int n;
        if (slot.equals("todos"))
            n = 0;
        else
            n = Integer.parseInt(slot.substring(slot.length() - 1));

        if (rh.getSlot_regado(n) != 0) {
            if (rh.getSemente_slot(n) == null) {
                if((primavera || outono) && (hortela || alface))
                    rh.setSemente_slot(context.semente().getText(), n);
                else if((primavera || inverno || outono) && (couve))
                    rh.setSemente_slot(context.semente().getText(), n);
                else if((primavera) && (batata))
                    rh.setSemente_slot(context.semente().getText(), n);
                else if((outono) && (beterraba))
                    rh.setSemente_slot(context.semente().getText(), n);
                else if((inverno || outono) && (morango))
                    rh.setSemente_slot(context.semente().getText(), n);
                else if((primavera || verao) && (abobora))
                    rh.setSemente_slot(context.semente().getText(), n);
                else if((verao) && (abobrinha))
                    rh.setSemente_slot(context.semente().getText(), n);
                else {
                    System.out.println("Linha " + context.getStart().getLine() + ": a semente " + context.semente().getText() + " não pode ser plantada na estação " + rh.getEstacao_atual());
                    rh.setPerdeu_jogo(true);

                    // recuperacao de erro
                    rh.setSemente_slot(context.semente().getText(), n);
                }

            } else {
                System.out.println("Linha " + context.getStart().getLine() + ": ja existe semente plantada no slot " + context.slot().getText());
                rh.setPerdeu_jogo(true);
            }
        } else {
            System.out.println("Linha " + context.getStart().getLine() + ": solo nao regado");
            rh.incrementaSlot_regado(n, 1);
            rh.setSemente_slot(context.semente().getText(), n);
            rh.setPerdeu_jogo(true);
        }

        super.visitAcao_plantar(context);

        return null;
    }


    @Override
    public Object visitAcao_colher(hortParser.Acao_colherContext context) {

        //System.out.println("entrei colher");

        String slot = context.slot().getText();
        String semente; // indica a semente do slot em questao
        int n, qtd_repetir_colher;
        int indice = 0;
        boolean tarde_demais = false;

        if (slot.equals("todos")) {
            n = 0;
            qtd_repetir_colher = rh.getQTD_MAX_SLOTS(); // Colher em todos os slots
        } else {
            n = Integer.parseInt(slot.substring(slot.length() - 1));
            qtd_repetir_colher = 1; // Colher em um slot só
            indice = n; // usará o n mesmo como indice
        }

        if (rh.getSemente_slot(n) != null) {

            for (int j = 1; j <= qtd_repetir_colher; j++) {
                if (n == 0)
                    indice = j; // SE FOR O CASO "todos": mudar o indice de acordo com o j

                semente = rh.getSemente_slot(indice);

                if (semente.equals("alface") && (rh.getQtd_dias_plantado_slot(indice) >= 2)) {
                    if(rh.getQtd_dias_plantado_slot(indice)<=3){ // Se nao for tarde demais.. chance de 1 dia a mais
                        rh.setSemente_slot(null, indice);
                        rh.setSlot_adubado(n, false);
                        rh.setSlot_capinado(n, false);
                        rh.setSlot_regado(n, 0);
                        rh.aumentaPontuacao(2);
                        rh.setQtd_dias_plantado_slot(indice,0);
                        rh.addColheita("alface");
                    }
                    else{
                        tarde_demais = true;
                    }
                }else if(semente.equals("hortelã") && (rh.getQtd_dias_plantado_slot(indice) >= 15) ){
                    if(rh.getQtd_dias_plantado_slot(indice)<=16) { // Se nao for tarde demais.. chance de 1 dia a mais
                        rh.setSemente_slot(null, indice);
                        rh.setSlot_adubado(n, false);
                        rh.setSlot_capinado(n, false);
                        rh.setSlot_regado(n, 0);
                        rh.aumentaPontuacao(15);
                        rh.setQtd_dias_plantado_slot(indice,0);
                        rh.addColheita("hortelã");
                    }
                    else{
                        tarde_demais = true;
                    }
                }else if(semente.equals("abobora") && (rh.getQtd_dias_plantado_slot(indice) >= 25)){
                    if(rh.getQtd_dias_plantado_slot(indice)<=26) { // Se nao for tarde demais.. chance de 1 dia a mais
                        rh.setSemente_slot(null, indice);
                        rh.setSlot_adubado(n, false);
                        rh.setSlot_capinado(n, false);
                        rh.setSlot_regado(n, 0);
                        rh.aumentaPontuacao(25);
                        rh.setQtd_dias_plantado_slot(indice,0);
                        rh.addColheita("abobora");
                    }
                    else{
                        tarde_demais = true;
                    }
                }else if(semente.equals("abobrinha") && rh.getQtd_dias_plantado_slot(indice) >= 10){
                    if(rh.getQtd_dias_plantado_slot(indice)<=11) { // Se nao for tarde demais.. chance de 1 dia a mais
                        rh.setSemente_slot(null, indice);
                        rh.setSlot_adubado(n, false);
                        rh.setSlot_capinado(n, false);
                        rh.setSlot_regado(n, 0);
                        rh.aumentaPontuacao(10);
                        rh.setQtd_dias_plantado_slot(indice,0);
                        rh.addColheita("abobrinha");
                    }
                    else{
                        tarde_demais = true;
                    }
                }else if(semente.equals("couve") && rh.getQtd_dias_plantado_slot(indice) >= 13){
                    if(rh.getQtd_dias_plantado_slot(indice)<=14) { // Se nao for tarde demais.. chance de 1 dia a mais
                        rh.setSemente_slot(null, indice);
                        rh.setSlot_adubado(n, false);
                        rh.setSlot_capinado(n, false);
                        rh.setSlot_regado(n, 0);
                        rh.aumentaPontuacao(13);
                        rh.setQtd_dias_plantado_slot(indice,0);
                        rh.addColheita("couve");
                    }
                    else{
                        tarde_demais = true;
                    }
                }else if(semente.equals("beterraba") && rh.getQtd_dias_plantado_slot(indice) >= 5){
                    if(rh.getQtd_dias_plantado_slot(indice)<=6) { // Se nao for tarde demais.. chance de 1 dia a mais
                        rh.setSemente_slot(null, indice);
                        rh.setSlot_adubado(n, false);
                        rh.setSlot_capinado(n, false);
                        rh.setSlot_regado(n, 0);
                        rh.aumentaPontuacao(5);
                        rh.setQtd_dias_plantado_slot(indice,0);
                        rh.addColheita("beterraba");
                    }
                    else{
                        tarde_demais = true;
                    }
                }else if(semente.equals("batata") && (rh.getQtd_dias_plantado_slot(indice) >= 20 )){
                    if(rh.getQtd_dias_plantado_slot(indice)<=21) { // Se nao for tarde demais.. chance de 1 dia a mais
                        rh.setSemente_slot(null, indice);
                        rh.setSlot_adubado(n, false);
                        rh.setSlot_capinado(n, false);
                        rh.setSlot_regado(n, 0);
                        rh.aumentaPontuacao(20);
                        rh.setQtd_dias_plantado_slot(indice,0);
                        rh.addColheita("batata");
                    }
                    else{
                        tarde_demais = true;
                    }
                }else if(semente.equals("morango") && rh.getQtd_dias_plantado_slot(indice) >= 7){
                    if(rh.getQtd_dias_plantado_slot(indice)<=8) { // Se nao for tarde demais.. chance de 1 dia a mais
                        rh.setSemente_slot(null, indice);
                        rh.setSlot_adubado(n, false);
                        rh.setSlot_capinado(n, false);
                        rh.setSlot_regado(n, 0);
                        rh.aumentaPontuacao(7);
                        rh.setQtd_dias_plantado_slot(indice,0);
                        rh.addColheita("morango");
                    }
                    else{
                        tarde_demais = true;
                    }
                }else {
                    System.out.println("Linha " + context.getStart().getLine() + ": a semente " + rh.getSemente_slot(n) + " nao estava pronta para ser colhida");
                    rh.setPerdeu_jogo(true);
                }

                if (tarde_demais){
                    System.out.println("Linha " + context.getStart().getLine() + ": a semente " + rh.getSemente_slot(n) + " demorou muito para ser colhida e estragou");
                    rh.setPerdeu_jogo(true);

                    // Recuperacao de erro
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.setQtd_dias_plantado_slot(indice,0);

                }
            }
        } else {
            System.out.println("Linha " + context.getStart().getLine() + ": slot nao possui uma semente");
            rh.setPerdeu_jogo(true);
        }

        super.visitAcao_colher(context);

        return null;
    }


    @Override
    public Object visitCmdPara(hortParser.CmdParaContext context){
//        System.out.println("to no para");
        int inicio = Integer.parseInt(context.inicio.getText());
        int fim = Integer.parseInt(context.fim.getText());

        if (context.op_data().getText().equals("Dia")){ // se o para for percorrer entre os dias
            if (rh.getQtd_dias() < inicio) { // Verificando se nao ta voltando no tempo
                for (int i = inicio; i <= fim; i++) {
//                    System.out.println("preciso chamar acao para o dia " + i);

                    rh.setDias_passados(i - rh.getQtd_dias());
                    rh.setQtd_dias(i);

                    for (hortParser.AcaoContext acao : context.acao()) {
                        visitAcao(acao);
                    }
                    acoes_decrementa_dia(context.getStart().getLine());
                }
            }
            else{
                System.out.println("Linha " + context.getStart().getLine() + ": nao é permitido voltar no tempo");
                rh.setPerdeu_jogo(true);
            }
        }

        super.visitCmdPara(context);
        return null;
    }

}