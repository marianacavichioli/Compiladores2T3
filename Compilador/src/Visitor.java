import org.antlr.v4.runtime.CommonTokenStream;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


//TODO: acho que nao tem nada feito sobre ano ainda

//colocar onde decremente o regado do solo as verificacoes de cada semente - já fiz

//TODO: exemplo do solo seco (3 - erro semantico), mostra um problema na recuperacao de erro.

//TODO: exemplo pula dia (4 - erro semantico), precisa verificar quantos dias passou depois daquilo, para diminuir o regado daquela quantidade

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

        super.visitCmd(context);

//        System.out.println("slot1 regado " + rh.getSlot_regado(0) + " plantado " + rh.getSemente_slot(0));
//        System.out.println("slot2 regado " + rh.getSlot_regado(1) + " plantado " + rh.getSemente_slot(1));
//        System.out.println("slot3 regado " + rh.getSlot_regado(2) + " plantado " + rh.getSemente_slot(2));
//        System.out.println("slot4 regado " + rh.getSlot_regado(3) + " plantado " + rh.getSemente_slot(3));

        if (!rh.decrementar_dia()) {
            System.out.println("Linha " + context.getStart().getLine() + ": solo seco para a semente plantada");
            rh.setPerdeu_jogo(true);
        }
//        else
//            System.out.println("decrementei dia");


        return null;
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

    //TODO considerar a primeira regada na preparação do solo como inicialização, não considerar no contador (q??)
    @Override
    public Object visitAcao_regar(hortParser.Acao_regarContext context) {
        //System.out.println("vou regar");
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

    //TODO isso aqui por equanto ta tratando so dias, depois tem que fazer pra mes e ano. Precisa resolver problema do loop antes

    @Override
    public Object visitPeriodo_tempo(hortParser.Periodo_tempoContext context) {

        //System.out.println("Dia: " + rh.getQtd_dias());

        if (rh.getQtd_dias() < Integer.parseInt(context.NUM_INT().getText())) { // Verificando se nao ta voltando no tempo
            rh.setQtd_dias(Integer.parseInt(context.NUM_INT().getText()));
            if (!context.op_data().getText().equals("Dia")) {
                System.out.println("Linha " + context.getStart().getLine() + ": data inválida");
                rh.setPerdeu_jogo(true);
            }
//            if (context.op_data().getText().equals("Dia")) {
//                if (!rh.decrementar_dia()) {
//                    System.out.println("Linha " + context.getStart().getLine() + ": solo seco para a semente plantada" );
//                    rh.setPerdeu_jogo(true);
//                }
//            }
//        } else {
//            System.out.println("Linha " + context.getStart().getLine() + ": data inválida");
//            rh.setPerdeu_jogo(true);
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
                else
                    System.out.println("Linha " + context.getStart().getLine() + ": a semente " + context.semente().getText() + " não pode ser plantada na estação " + rh.getEstacao_atual());
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
        int n, qtd_repetir_colher, indice = 0;

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

                //TODO pensar quanto tempo depois do tempo certo da colheita é possível colher sem a planta ter morrido

                if (semente.equals("alface") && rh.getQtd_dias() >= 2) { //45 dias
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("alface");
                }else if(semente.equals("hortelã") && (rh.getQtd_dias() >= 30 | rh.getQtd_meses() == 1)){ //7 meses
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("hortelã");
                }else if(semente.equals("abobora") && (rh.getQtd_dias() >= 90 | rh.getQtd_meses() == 2)){ //5 meses
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("abobora");
                }else if(semente.equals("abobrinha") && rh.getQtd_dias() >= 10){ //50 dias
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("abobrinha");
                }else if(semente.equals("couve") && rh.getQtd_dias() >= 10){ //50 dias
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("couve");
                }else if(semente.equals("beterraba") && rh.getQtd_dias() >= 5){ //70 dias
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("beterraba");
                }else if(semente.equals("batata") && (rh.getQtd_dias() >= 90 | rh.getQtd_meses() == 2)){ //90 dias
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("batata");
                }else if(semente.equals("morango") && rh.getQtd_dias() >= 7){ //80 dias
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("morango");
                }else {
                    System.out.println("Linha " + context.getStart().getLine() + ": a semente " + rh.getSemente_slot(n) + " nao estava pronta para ser colhida");
                    rh.setPerdeu_jogo(true);
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
        System.out.println("to no para");
        int inicio = Integer.parseInt(context.inicio.getText());
        int fim = Integer.parseInt(context.fim.getText());

        if (context.op_data().getText().equals("Dia")){ // se o para for percorrer entre os dias
            for(int i=inicio;i<fim;i++){
                System.out.println("preciso chamar acao para o dia " + i);
                for(hortParser.AcaoContext acao: context.acao()) {
                    visitAcao(acao);
                }
                //TODO: tambem colocar que foi passando os dias -> decrementar o regado daquela quantidade.. nao ter conflito com o decremento do solo no dia normal
            }
        }
        //TODO: ainda tem que tratar o caso de ser mes ou ano (depois de resolver problema do loop)

        super.visitCmdPara(context);
        return null;
    }

}