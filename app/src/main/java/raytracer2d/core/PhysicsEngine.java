package raytracer2d.core;

import java.util.LinkedList;
import java.util.List;

import raytracer2d.utils.interfaces.Modification;
import raytracer2d.utils.interfaces.Rule;

public class PhysicsEngine {
    List<Rule> rules = new LinkedList<>();

    public void run() {
        if (rules != null)
            for (Rule rule : rules)
                if (rule.applies())
                    for (Modification modification : rule.getModifications())
                        modification.run();
    }

    public void add(Rule... rules) {
        if (this.rules != null)
            this.rules.addAll(List.of(rules));
        else
            throw new NullPointerException();
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
