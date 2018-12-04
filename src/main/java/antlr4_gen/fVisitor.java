package antlr4_gen;// Generated from C:/Users/Timur/IdeaProjects/f-language-compiler/src/main/antlr4\f.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link fParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface fVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link fParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(fParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(fParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(fParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(fParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(fParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(fParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(fParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(fParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#secondary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondary(fParser.SecondaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(fParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTail(fParser.TailContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#elementary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementary(fParser.ElementaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(fParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(fParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(fParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(fParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#tupleelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleelement(fParser.TupleelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(fParser.MapContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#mapelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapelement(fParser.MapelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(fParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(fParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(fParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(fParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#assignmentorcall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentorcall(fParser.AssignmentorcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(fParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(fParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link fParser#loopbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopbody(fParser.LoopbodyContext ctx);
}