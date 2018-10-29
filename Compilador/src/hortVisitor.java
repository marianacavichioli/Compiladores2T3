// Generated from /Users/Macbook/Documents/GitKraken Projects/Compiladores2T3/Compilador/src/hort.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link hortParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface hortVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link hortParser#estacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstacao(hortParser.EstacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#semente}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemente(hortParser.SementeContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#intensidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntensidade(hortParser.IntensidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#op_data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_data(hortParser.Op_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#slot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlot(hortParser.SlotContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#horta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHorta(hortParser.HortaContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(hortParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(hortParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#preparar_solo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreparar_solo(hortParser.Preparar_soloContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(hortParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#periodo_tempo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriodo_tempo(hortParser.Periodo_tempoContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#acao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcao(hortParser.AcaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#acao_plantar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcao_plantar(hortParser.Acao_plantarContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#acao_regar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcao_regar(hortParser.Acao_regarContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#acao_colher}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcao_colher(hortParser.Acao_colherContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#acao_capinar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcao_capinar(hortParser.Acao_capinarContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#acao_adubar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcao_adubar(hortParser.Acao_adubarContext ctx);
	/**
	 * Visit a parse tree produced by {@link hortParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(hortParser.CmdParaContext ctx);
}