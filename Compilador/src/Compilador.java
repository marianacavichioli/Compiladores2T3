
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
//import sun.jvm.hotspot.debugger.win32.coff.COMDATSelectionTypes;

public class Compilador {

    private final static String CAMINHO_CASOS_TESTE = "/Users/Macbook/IdeaProjects/Compiladores2T3/casosDeTesteT3/exemplo_simples_correto";

    public static void main(String[] args) throws IOException, RecognitionException {


        Saida out = new Saida();

         CharStream input = CharStreams.fromFileName(args[0]);

            hortLexer lexer = new hortLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            hortParser parser = new hortParser(tokens);
          //  parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener(out));
            hortParser.HortaContext arvore = parser.horta();


            if(!out.isModificado()){
                Visitor v = new Visitor();
                v.setTokenStream(tokens);
                v.visitHorta(arvore);
                RelatorioHorta rh = v.rh;

                if(!out.isModificado()) {
                    if(!rh.getPerdeu_jogo())
                        rh.gerarRelatorio();
                }

            }
    }
}