package antlr4_gen;// Generated from C:/Users/Timur/IdeaProjects/f-language-compiler/src/main/antlr4\f.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, IDENTIFIER=54, INTEGERLITERAL=55, REALLITERAL=56, WS=57, RATIONALLITERAL=58, 
		STRINGLITERAL=59, COMPLEXLITERAL=60;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_expressions = 2, RULE_expression = 3, 
		RULE_relation = 4, RULE_factor = 5, RULE_term = 6, RULE_unary = 7, RULE_secondary = 8, 
		RULE_primary = 9, RULE_tail = 10, RULE_elementary = 11, RULE_function = 12, 
		RULE_parameters = 13, RULE_body = 14, RULE_tuple = 15, RULE_tupleelement = 16, 
		RULE_map = 17, RULE_mapelement = 18, RULE_list = 19, RULE_type = 20, RULE_statements = 21, 
		RULE_statement = 22, RULE_assignmentorcall = 23, RULE_conditional = 24, 
		RULE_loop = 25, RULE_loopbody = 26;
	public static final String[] ruleNames = {
		"program", "declaration", "expressions", "expression", "relation", "factor", 
		"term", "unary", "secondary", "primary", "tail", "elementary", "function", 
		"parameters", "body", "tuple", "tupleelement", "map", "mapelement", "list", 
		"type", "statements", "statement", "assignmentorcall", "conditional", 
		"loop", "loopbody"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "'is'", "','", "'and'", "'or'", "'xor'", "'<'", "'<='", 
		"'>'", "'>='", "'='", "'/='", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
		"'['", "']'", "'.'", "'false'", "'true'", "'INTEGERLITERAL'", "'REALLITERAL'", 
		"'RATIONALLITERAL'", "'COMPLEXLITERAL'", "'STRINGLITERAL'", "'IDENTIFIER'", 
		"'func'", "'do'", "'end'", "'=>'", "'{'", "'}'", "'bool'", "'integer'", 
		"'real'", "'rational'", "'complex'", "'string'", "'return'", "'break'", 
		"':='", "'if'", "'then'", "'else'", "'for'", "'in'", "'..'", "'while'", 
		"'loop'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "IDENTIFIER", "INTEGERLITERAL", "REALLITERAL", 
		"WS", "RATIONALLITERAL", "STRINGLITERAL", "COMPLEXLITERAL"
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
	public String getGrammarFileName() { return "f.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public fParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			declaration();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(55);
				match(T__0);
				setState(56);
				declaration();
				}
				}
				setState(61);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(fParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(IDENTIFIER);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(63);
				match(T__1);
				setState(64);
				type();
				}
			}

			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(67);
				match(T__2);
				setState(68);
				expression();
				}
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

	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			expression();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(72);
				match(T__3);
				setState(73);
				expression();
				}
				}
				setState(78);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			relation();
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(80);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(81);
				relation();
				}
				break;
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

	public static class RelationContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			factor();
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(85);
					match(T__7);
					}
					break;
				case T__8:
					{
					setState(86);
					match(T__8);
					}
					break;
				case T__9:
					{
					setState(87);
					match(T__9);
					}
					break;
				case T__10:
					{
					setState(88);
					match(T__10);
					}
					break;
				case T__11:
					{
					setState(89);
					match(T__11);
					setState(90);
					match(T__12);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(93);
				factor();
				}
				break;
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

	public static class FactorContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_factor);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			term();
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(98);
					term();
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			unary();
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(105);
					_la = _input.LA(1);
					if ( !(_la==T__15 || _la==T__16) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(106);
					unary();
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class UnaryContext extends ParserRuleContext {
		public SecondaryContext secondary() {
			return getRuleContext(SecondaryContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(112);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(113);
				secondary();
				}
				break;
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

	public static class SecondaryContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<TailContext> tail() {
			return getRuleContexts(TailContext.class);
		}
		public TailContext tail(int i) {
			return getRuleContext(TailContext.class,i);
		}
		public SecondaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secondary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterSecondary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitSecondary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitSecondary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SecondaryContext secondary() throws RecognitionException {
		SecondaryContext _localctx = new SecondaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_secondary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			primary();
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117);
					tail();
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class PrimaryContext extends ParserRuleContext {
		public ElementaryContext elementary() {
			return getRuleContext(ElementaryContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primary);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				elementary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				tuple();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				map();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				list();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				match(T__17);
				setState(129);
				expression();
				setState(130);
				match(T__18);
				}
				break;
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

	public static class TailContext extends ParserRuleContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(fParser.IDENTIFIER, 0); }
		public TerminalNode INTEGERLITERAL() { return getToken(fParser.INTEGERLITERAL, 0); }
		public TailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TailContext tail() throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tail);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(T__17);
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(135);
					expressions();
					}
					break;
				}
				setState(138);
				match(T__18);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(T__19);
				setState(140);
				expression();
				setState(141);
				match(T__20);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				match(T__21);
				setState(144);
				match(IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				match(T__21);
				setState(146);
				match(INTEGERLITERAL);
				}
				break;
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

	public static class ElementaryContext extends ParserRuleContext {
		public ElementaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterElementary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitElementary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitElementary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementaryContext elementary() throws RecognitionException {
		ElementaryContext _localctx = new ElementaryContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elementary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
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

	public static class FunctionContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__30);
			setState(152);
			match(T__17);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(153);
				parameters();
				}
			}

			setState(156);
			match(T__18);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(157);
				match(T__1);
				setState(158);
				type();
				}
			}

			setState(161);
			body();
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

	public static class ParametersContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			declaration();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(164);
				match(T__3);
				setState(165);
				declaration();
				}
				}
				setState(170);
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

	public static class BodyContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_body);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(T__31);
				setState(172);
				statements();
				setState(173);
				match(T__32);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(T__33);
				setState(176);
				expression();
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

	public static class TupleContext extends ParserRuleContext {
		public List<TupleelementContext> tupleelement() {
			return getRuleContexts(TupleelementContext.class);
		}
		public TupleelementContext tupleelement(int i) {
			return getRuleContext(TupleelementContext.class,i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tuple);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__19);
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(180);
				tupleelement();
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(181);
						match(T__3);
						setState(182);
						tupleelement();
						}
						} 
					}
					setState(187);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				}
				break;
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

	public static class TupleelementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(fParser.IDENTIFIER, 0); }
		public TupleelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleelement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterTupleelement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitTupleelement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitTupleelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleelementContext tupleelement() throws RecognitionException {
		TupleelementContext _localctx = new TupleelementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tupleelement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(190);
				match(IDENTIFIER);
				setState(191);
				match(T__2);
				}
			}

			setState(194);
			expression();
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

	public static class MapContext extends ParserRuleContext {
		public List<MapelementContext> mapelement() {
			return getRuleContexts(MapelementContext.class);
		}
		public MapelementContext mapelement(int i) {
			return getRuleContext(MapelementContext.class,i);
		}
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitMap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__34);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) {
				{
				setState(197);
				mapelement();
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(198);
					match(T__3);
					setState(199);
					mapelement();
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(207);
			match(T__35);
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

	public static class MapelementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MapelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapelement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterMapelement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitMapelement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitMapelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapelementContext mapelement() throws RecognitionException {
		MapelementContext _localctx = new MapelementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mapelement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			expression();
			setState(210);
			match(T__1);
			setState(211);
			expression();
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

	public static class ListContext extends ParserRuleContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__17);
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(214);
				expressions();
				}
				break;
			}
			setState(217);
			match(T__18);
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

	public static class TypeContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type);
		int _la;
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__39:
			case T__40:
			case T__41:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				match(T__30);
				setState(222);
				match(T__17);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__19) | (1L << T__30) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0)) {
					{
					setState(223);
					type();
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(224);
						match(T__3);
						setState(225);
						type();
						}
						}
						setState(230);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(233);
				match(T__18);
				setState(236);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(234);
					match(T__1);
					setState(235);
					type();
					}
					break;
				}
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				match(T__34);
				setState(239);
				match(T__35);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
				match(T__19);
				setState(241);
				type();
				setState(242);
				match(T__1);
				setState(243);
				type();
				setState(244);
				match(T__20);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 6);
				{
				setState(246);
				match(T__17);
				setState(247);
				type();
				setState(248);
				match(T__18);
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			statement();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(253);
				match(T__0);
				setState(254);
				statement();
				}
				}
				setState(259);
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentorcallContext assignmentorcall() {
			return getRuleContext(AssignmentorcallContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_statement);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__19:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				assignmentorcall();
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				conditional();
				}
				break;
			case T__48:
			case T__51:
			case T__52:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				loop();
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 4);
				{
				setState(263);
				match(T__42);
				setState(265);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(264);
					expression();
					}
					break;
				}
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 5);
				{
				setState(267);
				match(T__43);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(268);
				declaration();
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

	public static class AssignmentorcallContext extends ParserRuleContext {
		public SecondaryContext secondary() {
			return getRuleContext(SecondaryContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentorcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentorcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterAssignmentorcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitAssignmentorcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitAssignmentorcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentorcallContext assignmentorcall() throws RecognitionException {
		AssignmentorcallContext _localctx = new AssignmentorcallContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assignmentorcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			secondary();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(272);
				match(T__44);
				setState(273);
				expression();
				}
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

	public static class ConditionalContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(T__45);
			setState(277);
			expression();
			setState(278);
			match(T__46);
			setState(279);
			statements();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__47) {
				{
				setState(280);
				match(T__47);
				setState(281);
				statements();
				}
			}

			setState(284);
			match(T__32);
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

	public static class LoopContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LoopbodyContext loopbody() {
			return getRuleContext(LoopbodyContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(fParser.IDENTIFIER, 0); }
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_loop);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__48:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(T__48);
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(287);
					match(IDENTIFIER);
					setState(288);
					match(T__49);
					}
				}

				setState(291);
				expression();
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__50) {
					{
					setState(292);
					match(T__50);
					setState(293);
					expression();
					}
				}

				setState(296);
				loopbody();
				}
				break;
			case T__51:
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__51) {
					{
					setState(298);
					match(T__51);
					setState(299);
					expression();
					}
				}

				setState(302);
				loopbody();
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

	public static class LoopbodyContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public LoopbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).enterLoopbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fListener ) ((fListener)listener).exitLoopbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fVisitor ) return ((fVisitor<? extends T>)visitor).visitLoopbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopbodyContext loopbody() throws RecognitionException {
		LoopbodyContext _localctx = new LoopbodyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_loopbody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(T__52);
			setState(306);
			statements();
			setState(307);
			match(T__32);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>\u0138\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\3"+
		"\3\3\3\3\5\3D\n\3\3\3\3\3\5\3H\n\3\3\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4"+
		"\3\5\3\5\3\5\5\5U\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6^\n\6\3\6\5\6a\n"+
		"\6\3\7\3\7\3\7\7\7f\n\7\f\7\16\7i\13\7\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq"+
		"\13\b\3\t\3\t\5\tu\n\t\3\n\3\n\7\ny\n\n\f\n\16\n|\13\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0087\n\13\3\f\3\f\5\f\u008b\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0096\n\f\3\r\3\r\3\16\3\16\3\16"+
		"\5\16\u009d\n\16\3\16\3\16\3\16\5\16\u00a2\n\16\3\16\3\16\3\17\3\17\3"+
		"\17\7\17\u00a9\n\17\f\17\16\17\u00ac\13\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\5\20\u00b4\n\20\3\21\3\21\3\21\3\21\7\21\u00ba\n\21\f\21\16\21\u00bd"+
		"\13\21\5\21\u00bf\n\21\3\22\3\22\5\22\u00c3\n\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\7\23\u00cb\n\23\f\23\16\23\u00ce\13\23\5\23\u00d0\n\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\25\3\25\5\25\u00da\n\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\7\26\u00e5\n\26\f\26\16\26\u00e8\13\26\5\26"+
		"\u00ea\n\26\3\26\3\26\3\26\5\26\u00ef\n\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00fd\n\26\3\27\3\27\3\27\7\27"+
		"\u0102\n\27\f\27\16\27\u0105\13\27\3\30\3\30\3\30\3\30\3\30\5\30\u010c"+
		"\n\30\3\30\3\30\5\30\u0110\n\30\3\31\3\31\3\31\5\31\u0115\n\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\5\32\u011d\n\32\3\32\3\32\3\33\3\33\3\33\5\33"+
		"\u0124\n\33\3\33\3\33\3\33\5\33\u0129\n\33\3\33\3\33\3\33\3\33\5\33\u012f"+
		"\n\33\3\33\5\33\u0132\n\33\3\34\3\34\3\34\3\34\3\34\2\2\35\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\b\3\2\7\t\3\2\20\21"+
		"\3\2\22\23\3\2\31 \3\2\')\3\2*,\2\u0152\28\3\2\2\2\4@\3\2\2\2\6I\3\2\2"+
		"\2\bQ\3\2\2\2\nV\3\2\2\2\fb\3\2\2\2\16j\3\2\2\2\20t\3\2\2\2\22v\3\2\2"+
		"\2\24\u0086\3\2\2\2\26\u0095\3\2\2\2\30\u0097\3\2\2\2\32\u0099\3\2\2\2"+
		"\34\u00a5\3\2\2\2\36\u00b3\3\2\2\2 \u00b5\3\2\2\2\"\u00c2\3\2\2\2$\u00c6"+
		"\3\2\2\2&\u00d3\3\2\2\2(\u00d7\3\2\2\2*\u00fc\3\2\2\2,\u00fe\3\2\2\2."+
		"\u010f\3\2\2\2\60\u0111\3\2\2\2\62\u0116\3\2\2\2\64\u0131\3\2\2\2\66\u0133"+
		"\3\2\2\28=\5\4\3\29:\7\3\2\2:<\5\4\3\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2="+
		">\3\2\2\2>\3\3\2\2\2?=\3\2\2\2@C\78\2\2AB\7\4\2\2BD\5*\26\2CA\3\2\2\2"+
		"CD\3\2\2\2DG\3\2\2\2EF\7\5\2\2FH\5\b\5\2GE\3\2\2\2GH\3\2\2\2H\5\3\2\2"+
		"\2IN\5\b\5\2JK\7\6\2\2KM\5\b\5\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2"+
		"\2O\7\3\2\2\2PN\3\2\2\2QT\5\n\6\2RS\t\2\2\2SU\5\n\6\2TR\3\2\2\2TU\3\2"+
		"\2\2U\t\3\2\2\2V`\5\f\7\2W^\7\n\2\2X^\7\13\2\2Y^\7\f\2\2Z^\7\r\2\2[\\"+
		"\7\16\2\2\\^\7\17\2\2]W\3\2\2\2]X\3\2\2\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2"+
		"\2^_\3\2\2\2_a\5\f\7\2`]\3\2\2\2`a\3\2\2\2a\13\3\2\2\2bg\5\16\b\2cd\t"+
		"\3\2\2df\5\16\b\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\r\3\2\2\2i"+
		"g\3\2\2\2jo\5\20\t\2kl\t\4\2\2ln\5\20\t\2mk\3\2\2\2nq\3\2\2\2om\3\2\2"+
		"\2op\3\2\2\2p\17\3\2\2\2qo\3\2\2\2rs\t\3\2\2su\5\22\n\2tr\3\2\2\2tu\3"+
		"\2\2\2u\21\3\2\2\2vz\5\24\13\2wy\5\26\f\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2"+
		"\2z{\3\2\2\2{\23\3\2\2\2|z\3\2\2\2}\u0087\5\30\r\2~\u0087\5\32\16\2\177"+
		"\u0087\5 \21\2\u0080\u0087\5$\23\2\u0081\u0087\5(\25\2\u0082\u0083\7\24"+
		"\2\2\u0083\u0084\5\b\5\2\u0084\u0085\7\25\2\2\u0085\u0087\3\2\2\2\u0086"+
		"}\3\2\2\2\u0086~\3\2\2\2\u0086\177\3\2\2\2\u0086\u0080\3\2\2\2\u0086\u0081"+
		"\3\2\2\2\u0086\u0082\3\2\2\2\u0087\25\3\2\2\2\u0088\u008a\7\24\2\2\u0089"+
		"\u008b\5\6\4\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u0096\7\25\2\2\u008d\u008e\7\26\2\2\u008e\u008f\5\b\5\2\u008f"+
		"\u0090\7\27\2\2\u0090\u0096\3\2\2\2\u0091\u0092\7\30\2\2\u0092\u0096\7"+
		"8\2\2\u0093\u0094\7\30\2\2\u0094\u0096\79\2\2\u0095\u0088\3\2\2\2\u0095"+
		"\u008d\3\2\2\2\u0095\u0091\3\2\2\2\u0095\u0093\3\2\2\2\u0096\27\3\2\2"+
		"\2\u0097\u0098\t\5\2\2\u0098\31\3\2\2\2\u0099\u009a\7!\2\2\u009a\u009c"+
		"\7\24\2\2\u009b\u009d\5\34\17\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2"+
		"\2\u009d\u009e\3\2\2\2\u009e\u00a1\7\25\2\2\u009f\u00a0\7\4\2\2\u00a0"+
		"\u00a2\5*\26\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a4\5\36\20\2\u00a4\33\3\2\2\2\u00a5\u00aa\5\4\3\2\u00a6"+
		"\u00a7\7\6\2\2\u00a7\u00a9\5\4\3\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\35\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ad\u00ae\7\"\2\2\u00ae\u00af\5,\27\2\u00af\u00b0\7#\2\2\u00b0"+
		"\u00b4\3\2\2\2\u00b1\u00b2\7$\2\2\u00b2\u00b4\5\b\5\2\u00b3\u00ad\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b4\37\3\2\2\2\u00b5\u00be\7\26\2\2\u00b6\u00bb"+
		"\5\"\22\2\u00b7\u00b8\7\6\2\2\u00b8\u00ba\5\"\22\2\u00b9\u00b7\3\2\2\2"+
		"\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bf"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00b6\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"!\3\2\2\2\u00c0\u00c1\78\2\2\u00c1\u00c3\7\5\2\2\u00c2\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\5\b\5\2\u00c5#\3\2\2\2"+
		"\u00c6\u00cf\7%\2\2\u00c7\u00cc\5&\24\2\u00c8\u00c9\7\6\2\2\u00c9\u00cb"+
		"\5&\24\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00c7\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7&\2\2\u00d2"+
		"%\3\2\2\2\u00d3\u00d4\5\b\5\2\u00d4\u00d5\7\4\2\2\u00d5\u00d6\5\b\5\2"+
		"\u00d6\'\3\2\2\2\u00d7\u00d9\7\24\2\2\u00d8\u00da\5\6\4\2\u00d9\u00d8"+
		"\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7\25\2\2"+
		"\u00dc)\3\2\2\2\u00dd\u00fd\t\6\2\2\u00de\u00fd\t\7\2\2\u00df\u00e0\7"+
		"!\2\2\u00e0\u00e9\7\24\2\2\u00e1\u00e6\5*\26\2\u00e2\u00e3\7\6\2\2\u00e3"+
		"\u00e5\5*\26\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00e1\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ee\7\25"+
		"\2\2\u00ec\u00ed\7\4\2\2\u00ed\u00ef\5*\26\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00fd\3\2\2\2\u00f0\u00f1\7%\2\2\u00f1\u00fd\7&\2"+
		"\2\u00f2\u00f3\7\26\2\2\u00f3\u00f4\5*\26\2\u00f4\u00f5\7\4\2\2\u00f5"+
		"\u00f6\5*\26\2\u00f6\u00f7\7\27\2\2\u00f7\u00fd\3\2\2\2\u00f8\u00f9\7"+
		"\24\2\2\u00f9\u00fa\5*\26\2\u00fa\u00fb\7\25\2\2\u00fb\u00fd\3\2\2\2\u00fc"+
		"\u00dd\3\2\2\2\u00fc\u00de\3\2\2\2\u00fc\u00df\3\2\2\2\u00fc\u00f0\3\2"+
		"\2\2\u00fc\u00f2\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fd+\3\2\2\2\u00fe\u0103"+
		"\5.\30\2\u00ff\u0100\7\3\2\2\u0100\u0102\5.\30\2\u0101\u00ff\3\2\2\2\u0102"+
		"\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104-\3\2\2\2"+
		"\u0105\u0103\3\2\2\2\u0106\u0110\5\60\31\2\u0107\u0110\5\62\32\2\u0108"+
		"\u0110\5\64\33\2\u0109\u010b\7-\2\2\u010a\u010c\5\b\5\2\u010b\u010a\3"+
		"\2\2\2\u010b\u010c\3\2\2\2\u010c\u0110\3\2\2\2\u010d\u0110\7.\2\2\u010e"+
		"\u0110\5\4\3\2\u010f\u0106\3\2\2\2\u010f\u0107\3\2\2\2\u010f\u0108\3\2"+
		"\2\2\u010f\u0109\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110"+
		"/\3\2\2\2\u0111\u0114\5\22\n\2\u0112\u0113\7/\2\2\u0113\u0115\5\b\5\2"+
		"\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\61\3\2\2\2\u0116\u0117"+
		"\7\60\2\2\u0117\u0118\5\b\5\2\u0118\u0119\7\61\2\2\u0119\u011c\5,\27\2"+
		"\u011a\u011b\7\62\2\2\u011b\u011d\5,\27\2\u011c\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7#\2\2\u011f\63\3\2\2\2\u0120"+
		"\u0123\7\63\2\2\u0121\u0122\78\2\2\u0122\u0124\7\64\2\2\u0123\u0121\3"+
		"\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0128\5\b\5\2\u0126"+
		"\u0127\7\65\2\2\u0127\u0129\5\b\5\2\u0128\u0126\3\2\2\2\u0128\u0129\3"+
		"\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\5\66\34\2\u012b\u0132\3\2\2\2\u012c"+
		"\u012d\7\66\2\2\u012d\u012f\5\b\5\2\u012e\u012c\3\2\2\2\u012e\u012f\3"+
		"\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\5\66\34\2\u0131\u0120\3\2\2\2\u0131"+
		"\u012e\3\2\2\2\u0132\65\3\2\2\2\u0133\u0134\7\67\2\2\u0134\u0135\5,\27"+
		"\2\u0135\u0136\7#\2\2\u0136\67\3\2\2\2\'=CGNT]`gotz\u0086\u008a\u0095"+
		"\u009c\u00a1\u00aa\u00b3\u00bb\u00be\u00c2\u00cc\u00cf\u00d9\u00e6\u00e9"+
		"\u00ee\u00fc\u0103\u010b\u010f\u0114\u011c\u0123\u0128\u012e\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}