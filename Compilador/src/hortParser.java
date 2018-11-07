// Generated from /Users/Macbook/Documents/GitKraken Projects/Compiladores2T3/Compilador/src/hort.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class hortParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, IDENT=38, 
		NUM_INT=39, MES31=40, MES30=41, ANO=42, WS=43, ERROCHAR=44;
	public static final int
		RULE_horta = 0, RULE_estacao = 1, RULE_semente = 2, RULE_intensidade = 3, 
		RULE_op_data = 4, RULE_slot = 5, RULE_declaracoes = 6, RULE_corpo = 7, 
		RULE_preparar_solo = 8, RULE_cmd = 9, RULE_periodo_tempo = 10, RULE_acao = 11, 
		RULE_acao_plantar = 12, RULE_acao_regar = 13, RULE_acao_colher = 14, RULE_acao_capinar = 15, 
		RULE_acao_adubar = 16, RULE_cmdPara = 17;
	public static final String[] ruleNames = {
		"horta", "estacao", "semente", "intensidade", "op_data", "slot", "declaracoes", 
		"corpo", "preparar_solo", "cmd", "periodo_tempo", "acao", "acao_plantar", 
		"acao_regar", "acao_colher", "acao_capinar", "acao_adubar", "cmdPara"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Horta'", "':'", "'Fim horta'", "'verao'", "'primavera'", "'inverno'", 
		"'outono'", "'hortel\u00E3'", "'alface'", "'abobora'", "'abobrinha'", 
		"'couve'", "'beterraba'", "'batata'", "'morango'", "'pouco'", "'muito'", 
		"'Dia'", "'M\u00EAs'", "'Ano'", "'slot1'", "'slot2'", "'slot3'", "'slot4'", 
		"'todos'", "'Estacao'", "'Local'", "'Preparar solo'", "'Plantar'", "'Regar'", 
		"'Colher'", "'Capinar'", "'Adubar'", "'para'", "'ate'", "'faca'", "'fim_para'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "IDENT", "NUM_INT", "MES31", "MES30", "ANO", "WS", "ERROCHAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "hort.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public hortParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class HortaContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(hortParser.IDENT, 0); }
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public HortaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_horta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterHorta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitHorta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitHorta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HortaContext horta() throws RecognitionException {
		HortaContext _localctx = new HortaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_horta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			match(IDENT);
			setState(38);
			match(T__1);
			setState(39);
			declaracoes();
			setState(40);
			corpo();
			setState(41);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EstacaoContext extends ParserRuleContext {
		public EstacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterEstacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitEstacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitEstacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstacaoContext estacao() throws RecognitionException {
		EstacaoContext _localctx = new EstacaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_estacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SementeContext extends ParserRuleContext {
		public SementeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semente; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterSemente(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitSemente(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitSemente(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SementeContext semente() throws RecognitionException {
		SementeContext _localctx = new SementeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_semente);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntensidadeContext extends ParserRuleContext {
		public IntensidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intensidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterIntensidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitIntensidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitIntensidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntensidadeContext intensidade() throws RecognitionException {
		IntensidadeContext _localctx = new IntensidadeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_intensidade);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__16) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_dataContext extends ParserRuleContext {
		public Op_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterOp_data(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitOp_data(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitOp_data(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_dataContext op_data() throws RecognitionException {
		Op_dataContext _localctx = new Op_dataContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_op_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SlotContext extends ParserRuleContext {
		public SlotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterSlot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitSlot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitSlot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotContext slot() throws RecognitionException {
		SlotContext _localctx = new SlotContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_slot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesContext extends ParserRuleContext {
		public Token local;
		public EstacaoContext estacao() {
			return getRuleContext(EstacaoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(hortParser.IDENT, 0); }
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracoes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__25);
			setState(54);
			match(T__1);
			setState(55);
			estacao();
			setState(56);
			match(T__26);
			setState(57);
			match(T__1);
			setState(58);
			((DeclaracoesContext)_localctx).local = match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorpoContext extends ParserRuleContext {
		public Preparar_soloContext preparar_solo() {
			return getRuleContext(Preparar_soloContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<CmdParaContext> cmdPara() {
			return getRuleContexts(CmdParaContext.class);
		}
		public CmdParaContext cmdPara(int i) {
			return getRuleContext(CmdParaContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitCorpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			preparar_solo();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__33))) != 0)) {
				{
				setState(63);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__17:
				case T__18:
				case T__19:
					{
					setState(61);
					cmd();
					}
					break;
				case T__33:
					{
					setState(62);
					cmdPara();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Preparar_soloContext extends ParserRuleContext {
		public List<Acao_regarContext> acao_regar() {
			return getRuleContexts(Acao_regarContext.class);
		}
		public Acao_regarContext acao_regar(int i) {
			return getRuleContext(Acao_regarContext.class,i);
		}
		public List<Acao_capinarContext> acao_capinar() {
			return getRuleContexts(Acao_capinarContext.class);
		}
		public Acao_capinarContext acao_capinar(int i) {
			return getRuleContext(Acao_capinarContext.class,i);
		}
		public List<Acao_adubarContext> acao_adubar() {
			return getRuleContexts(Acao_adubarContext.class);
		}
		public Acao_adubarContext acao_adubar(int i) {
			return getRuleContext(Acao_adubarContext.class,i);
		}
		public Preparar_soloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preparar_solo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterPreparar_solo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitPreparar_solo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitPreparar_solo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Preparar_soloContext preparar_solo() throws RecognitionException {
		Preparar_soloContext _localctx = new Preparar_soloContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_preparar_solo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__27);
			setState(69);
			match(T__1);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__31) | (1L << T__32))) != 0)) {
				{
				setState(73);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(70);
					acao_regar();
					}
					break;
				case T__31:
					{
					setState(71);
					acao_capinar();
					}
					break;
				case T__32:
					{
					setState(72);
					acao_adubar();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public Periodo_tempoContext periodo_tempo() {
			return getRuleContext(Periodo_tempoContext.class,0);
		}
		public List<AcaoContext> acao() {
			return getRuleContexts(AcaoContext.class);
		}
		public AcaoContext acao(int i) {
			return getRuleContext(AcaoContext.class,i);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			periodo_tempo();
			setState(79);
			match(T__1);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) {
				{
				{
				setState(80);
				acao();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Periodo_tempoContext extends ParserRuleContext {
		public Op_dataContext op_data() {
			return getRuleContext(Op_dataContext.class,0);
		}
		public TerminalNode NUM_INT() { return getToken(hortParser.NUM_INT, 0); }
		public Periodo_tempoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_periodo_tempo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterPeriodo_tempo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitPeriodo_tempo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitPeriodo_tempo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Periodo_tempoContext periodo_tempo() throws RecognitionException {
		Periodo_tempoContext _localctx = new Periodo_tempoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_periodo_tempo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			op_data();
			setState(87);
			match(NUM_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AcaoContext extends ParserRuleContext {
		public Acao_plantarContext acao_plantar() {
			return getRuleContext(Acao_plantarContext.class,0);
		}
		public Acao_regarContext acao_regar() {
			return getRuleContext(Acao_regarContext.class,0);
		}
		public Acao_colherContext acao_colher() {
			return getRuleContext(Acao_colherContext.class,0);
		}
		public Acao_capinarContext acao_capinar() {
			return getRuleContext(Acao_capinarContext.class,0);
		}
		public Acao_adubarContext acao_adubar() {
			return getRuleContext(Acao_adubarContext.class,0);
		}
		public AcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterAcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitAcao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitAcao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcaoContext acao() throws RecognitionException {
		AcaoContext _localctx = new AcaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_acao);
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				acao_plantar();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				acao_regar();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				acao_colher();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				acao_capinar();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				acao_adubar();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Acao_plantarContext extends ParserRuleContext {
		public SementeContext semente() {
			return getRuleContext(SementeContext.class,0);
		}
		public SlotContext slot() {
			return getRuleContext(SlotContext.class,0);
		}
		public Acao_plantarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acao_plantar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterAcao_plantar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitAcao_plantar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitAcao_plantar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Acao_plantarContext acao_plantar() throws RecognitionException {
		Acao_plantarContext _localctx = new Acao_plantarContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_acao_plantar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__28);
			setState(97);
			semente();
			setState(98);
			slot();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Acao_regarContext extends ParserRuleContext {
		public IntensidadeContext intensidade() {
			return getRuleContext(IntensidadeContext.class,0);
		}
		public SlotContext slot() {
			return getRuleContext(SlotContext.class,0);
		}
		public Acao_regarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acao_regar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterAcao_regar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitAcao_regar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitAcao_regar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Acao_regarContext acao_regar() throws RecognitionException {
		Acao_regarContext _localctx = new Acao_regarContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_acao_regar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__29);
			setState(101);
			intensidade();
			setState(102);
			slot();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Acao_colherContext extends ParserRuleContext {
		public SlotContext slot() {
			return getRuleContext(SlotContext.class,0);
		}
		public Acao_colherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acao_colher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterAcao_colher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitAcao_colher(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitAcao_colher(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Acao_colherContext acao_colher() throws RecognitionException {
		Acao_colherContext _localctx = new Acao_colherContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_acao_colher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__30);
			setState(105);
			slot();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Acao_capinarContext extends ParserRuleContext {
		public SlotContext slot() {
			return getRuleContext(SlotContext.class,0);
		}
		public Acao_capinarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acao_capinar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterAcao_capinar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitAcao_capinar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitAcao_capinar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Acao_capinarContext acao_capinar() throws RecognitionException {
		Acao_capinarContext _localctx = new Acao_capinarContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_acao_capinar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__31);
			setState(108);
			slot();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Acao_adubarContext extends ParserRuleContext {
		public SlotContext slot() {
			return getRuleContext(SlotContext.class,0);
		}
		public Acao_adubarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acao_adubar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterAcao_adubar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitAcao_adubar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitAcao_adubar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Acao_adubarContext acao_adubar() throws RecognitionException {
		Acao_adubarContext _localctx = new Acao_adubarContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_acao_adubar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__32);
			setState(111);
			slot();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdParaContext extends ParserRuleContext {
		public Token inicio;
		public Token fim;
		public Op_dataContext op_data() {
			return getRuleContext(Op_dataContext.class,0);
		}
		public List<TerminalNode> NUM_INT() { return getTokens(hortParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(hortParser.NUM_INT, i);
		}
		public List<AcaoContext> acao() {
			return getRuleContexts(AcaoContext.class);
		}
		public AcaoContext acao(int i) {
			return getRuleContext(AcaoContext.class,i);
		}
		public CmdParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).enterCmdPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof hortListener ) ((hortListener)listener).exitCmdPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof hortVisitor ) return ((hortVisitor<? extends T>)visitor).visitCmdPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdParaContext cmdPara() throws RecognitionException {
		CmdParaContext _localctx = new CmdParaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_cmdPara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__33);
			setState(114);
			op_data();
			setState(115);
			((CmdParaContext)_localctx).inicio = match(NUM_INT);
			setState(116);
			match(T__34);
			setState(117);
			((CmdParaContext)_localctx).fim = match(NUM_INT);
			setState(118);
			match(T__35);
			setState(119);
			match(T__1);
			{
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) {
				{
				{
				setState(120);
				acao();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(126);
			match(T__36);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0083\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tB\n\t\f\t\16\tE\13"+
		"\t\3\n\3\n\3\n\3\n\3\n\7\nL\n\n\f\n\16\nO\13\n\3\13\3\13\3\13\7\13T\n"+
		"\13\f\13\16\13W\13\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\ra\n\r\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23|\n\23\f\23\16\23"+
		"\177\13\23\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$\2\7\3\2\6\t\3\2\n\21\3\2\22\23\3\2\24\26\3\2\27\33\2{\2&\3\2\2\2"+
		"\4-\3\2\2\2\6/\3\2\2\2\b\61\3\2\2\2\n\63\3\2\2\2\f\65\3\2\2\2\16\67\3"+
		"\2\2\2\20>\3\2\2\2\22F\3\2\2\2\24P\3\2\2\2\26X\3\2\2\2\30`\3\2\2\2\32"+
		"b\3\2\2\2\34f\3\2\2\2\36j\3\2\2\2 m\3\2\2\2\"p\3\2\2\2$s\3\2\2\2&\'\7"+
		"\3\2\2\'(\7(\2\2()\7\4\2\2)*\5\16\b\2*+\5\20\t\2+,\7\5\2\2,\3\3\2\2\2"+
		"-.\t\2\2\2.\5\3\2\2\2/\60\t\3\2\2\60\7\3\2\2\2\61\62\t\4\2\2\62\t\3\2"+
		"\2\2\63\64\t\5\2\2\64\13\3\2\2\2\65\66\t\6\2\2\66\r\3\2\2\2\678\7\34\2"+
		"\289\7\4\2\29:\5\4\3\2:;\7\35\2\2;<\7\4\2\2<=\7(\2\2=\17\3\2\2\2>C\5\22"+
		"\n\2?B\5\24\13\2@B\5$\23\2A?\3\2\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3"+
		"\2\2\2D\21\3\2\2\2EC\3\2\2\2FG\7\36\2\2GM\7\4\2\2HL\5\34\17\2IL\5 \21"+
		"\2JL\5\"\22\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2"+
		"\2\2N\23\3\2\2\2OM\3\2\2\2PQ\5\26\f\2QU\7\4\2\2RT\5\30\r\2SR\3\2\2\2T"+
		"W\3\2\2\2US\3\2\2\2UV\3\2\2\2V\25\3\2\2\2WU\3\2\2\2XY\5\n\6\2YZ\7)\2\2"+
		"Z\27\3\2\2\2[a\5\32\16\2\\a\5\34\17\2]a\5\36\20\2^a\5 \21\2_a\5\"\22\2"+
		"`[\3\2\2\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2a\31\3\2\2\2bc\7\37"+
		"\2\2cd\5\6\4\2de\5\f\7\2e\33\3\2\2\2fg\7 \2\2gh\5\b\5\2hi\5\f\7\2i\35"+
		"\3\2\2\2jk\7!\2\2kl\5\f\7\2l\37\3\2\2\2mn\7\"\2\2no\5\f\7\2o!\3\2\2\2"+
		"pq\7#\2\2qr\5\f\7\2r#\3\2\2\2st\7$\2\2tu\5\n\6\2uv\7)\2\2vw\7%\2\2wx\7"+
		")\2\2xy\7&\2\2y}\7\4\2\2z|\5\30\r\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}"+
		"~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\'\2\2\u0081%\3\2\2"+
		"\2\tACKMU`}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}