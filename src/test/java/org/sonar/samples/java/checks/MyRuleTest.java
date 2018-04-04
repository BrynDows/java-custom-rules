package org.sonar.samples.java.checks;

import java.util.List;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree.Kind;

public class MyRuleTest  extends IssuableSubscriptionVisitor{

	/*
	 * Prueba unitaria que comprueba la regla.
	 */
	@Test
	public void test() {
		JavaCheckVerifier.verify("src/test/files/Myrule.java", new Myrule());
	}

	@Override
	public List<Kind> nodesToVisit() {
		// TODO Auto-generated method stub
		return null;
	}

}
