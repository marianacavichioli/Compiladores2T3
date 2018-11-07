// Generated from /Users/Macbook/Documents/GitKraken Projects/Compiladores2T3/Compilador/src/hort.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link hortParser}.
 */
public interface hortListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link hortParser#horta}.
	 * @param ctx the parse tree
	 */
	void enterHorta(hortParser.HortaContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#horta}.
	 * @param ctx the parse tree
	 */
	void exitHorta(hortParser.HortaContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#estacao}.
	 * @param ctx the parse tree
	 */
	void enterEstacao(hortParser.EstacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#estacao}.
	 * @param ctx the parse tree
	 */
	void exitEstacao(hortParser.EstacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#semente}.
	 * @param ctx the parse tree
	 */
	void enterSemente(hortParser.SementeContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#semente}.
	 * @param ctx the parse tree
	 */
	void exitSemente(hortParser.SementeContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#intensidade}.
	 * @param ctx the parse tree
	 */
	void enterIntensidade(hortParser.IntensidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#intensidade}.
	 * @param ctx the parse tree
	 */
	void exitIntensidade(hortParser.IntensidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#op_data}.
	 * @param ctx the parse tree
	 */
	void enterOp_data(hortParser.Op_dataContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#op_data}.
	 * @param ctx the parse tree
	 */
	void exitOp_data(hortParser.Op_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#slot}.
	 * @param ctx the parse tree
	 */
	void enterSlot(hortParser.SlotContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#slot}.
	 * @param ctx the parse tree
	 */
	void exitSlot(hortParser.SlotContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(hortParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(hortParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(hortParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(hortParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#preparar_solo}.
	 * @param ctx the parse tree
	 */
	void enterPreparar_solo(hortParser.Preparar_soloContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#preparar_solo}.
	 * @param ctx the parse tree
	 */
	void exitPreparar_solo(hortParser.Preparar_soloContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(hortParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(hortParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#periodo_tempo}.
	 * @param ctx the parse tree
	 */
	void enterPeriodo_tempo(hortParser.Periodo_tempoContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#periodo_tempo}.
	 * @param ctx the parse tree
	 */
	void exitPeriodo_tempo(hortParser.Periodo_tempoContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#acao}.
	 * @param ctx the parse tree
	 */
	void enterAcao(hortParser.AcaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#acao}.
	 * @param ctx the parse tree
	 */
	void exitAcao(hortParser.AcaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#acao_plantar}.
	 * @param ctx the parse tree
	 */
	void enterAcao_plantar(hortParser.Acao_plantarContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#acao_plantar}.
	 * @param ctx the parse tree
	 */
	void exitAcao_plantar(hortParser.Acao_plantarContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#acao_regar}.
	 * @param ctx the parse tree
	 */
	void enterAcao_regar(hortParser.Acao_regarContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#acao_regar}.
	 * @param ctx the parse tree
	 */
	void exitAcao_regar(hortParser.Acao_regarContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#acao_colher}.
	 * @param ctx the parse tree
	 */
	void enterAcao_colher(hortParser.Acao_colherContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#acao_colher}.
	 * @param ctx the parse tree
	 */
	void exitAcao_colher(hortParser.Acao_colherContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#acao_capinar}.
	 * @param ctx the parse tree
	 */
	void enterAcao_capinar(hortParser.Acao_capinarContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#acao_capinar}.
	 * @param ctx the parse tree
	 */
	void exitAcao_capinar(hortParser.Acao_capinarContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#acao_adubar}.
	 * @param ctx the parse tree
	 */
	void enterAcao_adubar(hortParser.Acao_adubarContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#acao_adubar}.
	 * @param ctx the parse tree
	 */
	void exitAcao_adubar(hortParser.Acao_adubarContext ctx);
	/**
	 * Enter a parse tree produced by {@link hortParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(hortParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link hortParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(hortParser.CmdParaContext ctx);
}