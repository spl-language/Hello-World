// Generated from /home/george/Projects/simpletruffle/language/src/main/java/simpletruffle/parser/Hello.g4 by ANTLR 4.7
package simpletruffle.parser;

import java.util.List;
import java.util.ArrayList;

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.RootCallTarget;

import simpletruffle.HelloLanguage;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(HelloParser.RContext ctx);
}