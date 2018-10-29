import org.antlr.v4.runtime.CommonTokenStream;

//TODO: Pensar no caso de ja ter inicializado todos, mas usar só em slot .. (nao precisa ficar regando todos se nao ta usando todos. pensar nisso)
// TODO: dar erro semantico se o regado chegar em -1


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
    public Object visitAcao_capinar(hortParser.Acao_capinarContext context) {
        String slot = context.slot().getText();
        int n;
        if (slot.equals("todos"))
            n = 0;
        else
            n = Integer.parseInt(slot.substring(slot.length() - 1));
        rh.setSlot_capinado(n, true);
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
        } else {
            System.out.println("Linha " + context.getStart().getLine() + ": solo nao capinado");
            rh.setPerdeu_jogo(true);
        }
        super.visitAcao_adubar(context);
        return null;
    }

    //TODO considerar a primeira regada na preparação do solo como inicialização, não considerar no contador (q??)
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
            if (!rh.incrementaSlot_regado(n, qtd)) {
                System.out.println("Linha " + context.getStart().getLine() + ": solo encharcado");
                rh.setPerdeu_jogo(true);
            }
        } else {
            System.out.println("Linha " + context.getStart().getLine() + ": solo nao adubado");
            rh.setPerdeu_jogo(true);
        }

        super.visitAcao_regar(context);
        return null;
    }

    //TODO isso aqui por equanto ta tratando so dias, depois tem que fazer pra mes e ano

    @Override
    public Object visitPeriodo_tempo(hortParser.Periodo_tempoContext context) {

        if (rh.getQtd_dias() < Integer.parseInt(context.NUM_INT().getText())) { // Verificando se nao ta voltando no tempo
            rh.setQtd_dias(Integer.parseInt(context.NUM_INT().getText()));
            if (context.op_data().getText().equals("Dia"))
                rh.decrementar_dia();
        } else {
            System.out.println("Linha " + context.getStart().getLine() + ": data inválida");
            rh.setPerdeu_jogo(true);
        }

        super.visitPeriodo_tempo(context);

        return null;
    }

    @Override
    public Object visitAcao_plantar(hortParser.Acao_plantarContext context) {

        String slot = context.slot().getText();
        int n;
        if (slot.equals("todos"))
            n = 0;
        else
            n = Integer.parseInt(slot.substring(slot.length() - 1));

        if (rh.getSlot_regado(n) != 0) {
            if (rh.getSemente_slot(n) == null) {
                rh.setSemente_slot(context.semente().getText(), n);
            } else {
                System.out.println("Linha " + context.getStart().getLine() + ": ja existe semente plantada no slot " + context.slot().getText());
                rh.setPerdeu_jogo(true);
            }
        } else {
            System.out.println("Linha " + context.getStart().getLine() + ": solo nao regado");
            rh.setPerdeu_jogo(true);
        }

        super.visitAcao_plantar(context);

        return null;
    }

    @Override
    public Object visitAcao_colher(hortParser.Acao_colherContext context) {


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

                if (semente.equals("alface") && rh.getQtd_dias() > 0) {
                    rh.setSemente_slot(null, indice);
                    rh.setSlot_adubado(n, false);
                    rh.setSlot_capinado(n, false);
                    rh.setSlot_regado(n, 0);
                    rh.addColheita("alface");
                } else {

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
}