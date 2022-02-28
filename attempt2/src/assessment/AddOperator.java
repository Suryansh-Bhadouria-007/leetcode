package assessment;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddOperator {
    private Set<String> result;
    private int target;
    private final char[] ops = {'+', '-', '*', '/'};
    ScriptEngine scriptEngine;

    public List<String> addOperators(String num, int target) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        this.scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        this.result = new HashSet<>();
        this.target = target;
        addOperatorsUtil(num.substring(1), String.valueOf(num.charAt(0)));
        return new ArrayList<>(result);
    }

    private void addOperatorsUtil(String num, String currentExpression) {
        if (num.length() == 0) {
            Integer currentVal = null;
            try {
                if (this.scriptEngine == null) {
                    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                    this.scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
                }
                if (this.scriptEngine.eval(currentExpression) instanceof Double)
                    currentVal = ((Double) this.scriptEngine.eval(currentExpression)).intValue();
                else if (this.scriptEngine.eval(currentExpression) instanceof Integer)
                    currentVal = (Integer) (this.scriptEngine.eval(currentExpression));
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            if (currentVal == this.target) {
//                System.out.println(currentExpression);
                this.result.add(currentExpression);
            }
            return;
        }
        int currentCharIntValue = Integer.parseInt(String.valueOf(num.charAt(0)));

        addOperatorsUtil(num.substring(1), currentExpression + this.ops[0] + currentCharIntValue);
        addOperatorsUtil(num.substring(1), currentExpression + this.ops[1] + currentCharIntValue);
        addOperatorsUtil(num.substring(1), currentExpression + this.ops[2] + currentCharIntValue);
        addOperatorsUtil(num.substring(1), currentExpression + this.ops[3] + currentCharIntValue);
    }

    public static void main(String[] args) {
        AddOperator addOperator = new AddOperator();
        List<String> strings = addOperator.addOperators("123", 6);
        strings.forEach(System.out::println);
    }
}
