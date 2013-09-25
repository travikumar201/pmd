package net.sourceforge.pmd.lang.vm.rule;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RuleViolation;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.rule.AbstractRuleViolationFactory;
import net.sourceforge.pmd.lang.rule.ParametricRuleViolation;
import net.sourceforge.pmd.lang.rule.RuleViolationFactory;
import net.sourceforge.pmd.lang.vm.ast.SimpleNode;

public final class VmRuleViolationFactory extends AbstractRuleViolationFactory {

    public static final RuleViolationFactory INSTANCE = new VmRuleViolationFactory();

    private VmRuleViolationFactory() {
    }

    @Override
    protected RuleViolation createRuleViolation(final Rule rule, final RuleContext ruleContext, final Node node,
            final String message) {
        return new ParametricRuleViolation<SimpleNode>(rule, ruleContext, (SimpleNode) node, message);
    }

    @Override
    protected RuleViolation createRuleViolation(final Rule rule, final RuleContext ruleContext, final Node node,
            final String message, final int beginLine, final int endLine) {
        final ParametricRuleViolation<SimpleNode> violation = new ParametricRuleViolation<SimpleNode>(rule,
                ruleContext, (SimpleNode) node, message);
        violation.setLines(beginLine, endLine);
        return violation;
    }
}
