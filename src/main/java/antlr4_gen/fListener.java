package antlr4_gen;// Generated from C:/Users/Timur/IdeaProjects/f-language-compiler/src/main/antlr4\f.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link fParser}.
 */
public interface fListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link fParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(fParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(fParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(fParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(fParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(fParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(fParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(fParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(fParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(fParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(fParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(fParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(fParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(fParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(fParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(fParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(fParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#secondary}.
	 * @param ctx the parse tree
	 */
	void enterSecondary(fParser.SecondaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#secondary}.
	 * @param ctx the parse tree
	 */
	void exitSecondary(fParser.SecondaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(fParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(fParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#tail}.
	 * @param ctx the parse tree
	 */
	void enterTail(fParser.TailContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#tail}.
	 * @param ctx the parse tree
	 */
	void exitTail(fParser.TailContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#elementary}.
	 * @param ctx the parse tree
	 */
	void enterElementary(fParser.ElementaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#elementary}.
	 * @param ctx the parse tree
	 */
	void exitElementary(fParser.ElementaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(fParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(fParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(fParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(fParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(fParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(fParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(fParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(fParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#tupleelement}.
	 * @param ctx the parse tree
	 */
	void enterTupleelement(fParser.TupleelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#tupleelement}.
	 * @param ctx the parse tree
	 */
	void exitTupleelement(fParser.TupleelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(fParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(fParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#mapelement}.
	 * @param ctx the parse tree
	 */
	void enterMapelement(fParser.MapelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#mapelement}.
	 * @param ctx the parse tree
	 */
	void exitMapelement(fParser.MapelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(fParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(fParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(fParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(fParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(fParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(fParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(fParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(fParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#assignmentorcall}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentorcall(fParser.AssignmentorcallContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#assignmentorcall}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentorcall(fParser.AssignmentorcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(fParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(fParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(fParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(fParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link fParser#loopbody}.
	 * @param ctx the parse tree
	 */
	void enterLoopbody(fParser.LoopbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link fParser#loopbody}.
	 * @param ctx the parse tree
	 */
	void exitLoopbody(fParser.LoopbodyContext ctx);
}