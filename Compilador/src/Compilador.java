
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
//import sun.jvm.hotspot.debugger.win32.coff.COMDATSelectionTypes;

public class Compilador {

    private final static String CAMINHO_CASOS_TESTE = "/Users/Macbook/IdeaProjects/Compiladores2T3/casosDeTesteT3/exemplo_simples_correto";

    public static void main(String[] args) throws IOException, RecognitionException {

        //File diretorioCasosTeste = new File(CAMINHO_CASOS_TESTE + "/entrada");
        //File [] casosTeste = diretorioCasosTeste.listFiles();
        //int totalCasosTeste = casosTeste.length;
        //int casosTesteErrados = 0;
        //for(File casoTeste : casosTeste){
            //Cria a saida
            Saida out = new Saida();

            //Para quando for gerar o jar, utilizar a linha abaixo em vez da outra, pois iremos recever o c�digo por argumento
            //ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(casoTeste));

         CharStream input = CharStreams.fromFileName(args[0]);

            hortLexer lexer = new hortLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            hortParser parser = new hortParser(tokens);
          //  parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener(out));
            hortParser.HortaContext arvore = parser.horta();


            if(!out.isModificado()){
                Visitor v = new Visitor();   //leo colocou isso agora mas n funcionou parece
                v.setTokenStream(tokens);
               // v.visitPrograma(arvore);
                if(!out.isModificado()) {

                    //Executa gerador de código
                    //GeradorDeCodigo gc = new GeradorDeCodigo();
//                    ParseTreeWalker.DEFAULT.walk(gc, arvore);
//                    out.println(gc.getString());
//                    try(PrintWriter pw = new PrintWriter(new FileWriter(args[1]))) {
//                        pw.print(out);
//                    }
                }
                else{
                    try(PrintWriter pw = new PrintWriter(new FileWriter(args[1]))) {
                        pw.print(out);
                        pw.println("Fim da compilacao");
                    }
                }
            }
            else {
                try (PrintWriter pw = new PrintWriter(new FileWriter(args[1]))) {

                    pw.print(out);
                    pw.println("Fim da compilacao");
                }
            }
        //}

    }
}