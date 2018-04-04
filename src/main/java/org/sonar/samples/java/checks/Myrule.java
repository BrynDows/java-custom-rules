package org.sonar.samples.java.checks;

import java.util.List;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.google.common.collect.ImmutableList;
import org.sonar.plugins.java.api.semantic.Type;

	 
//Esta clase ha de extender de IssuableSubscriptionVisitor
public class Myrule extends IssuableSubscriptionVisitor {

	/*
	 * Regla, contiene la implementación de la regla
	 */
	@Override
	public List<Kind> nodesToVisit() {
		//return ImmutableList.of();// returns empty list, similar to Collections.emptyList()
		return ImmutableList.of(Kind.METHOD);
	}

	@Override
	public void visitNode(Tree tree) {
		MethodTree method = (MethodTree) tree;
		if (method.parameters().size() == 1) {
			MethodSymbol symbol = method.symbol(); //
			Type firstparameterType = symbol.parameterTypes().get(0);
			Type returnType = symbol.returnType().type();
			if ( returnType.is(firstparameterType.fullyQualifiedName()) ){
				reportIssue(method.simpleName(), "Nunca hagas eso");
			}
			
		}
	}

}
