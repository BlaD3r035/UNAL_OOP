package e4_400;

import java.util.ArrayList;
import java.util.List;

public class ExceptionDemo {

    public static List<String> runFirstBlock() {
        List<String> log = new ArrayList<>();
        try {
            log.add("Entering first try");
            double quotient = 10000 / 0;
            log.add("After division");
        } catch (ArithmeticException e) {
            log.add("Division by zero");
        } finally {
            log.add("Entering first finally");
        }
        return log;
    }

    public static List<String> runSecondBlock() {
        List<String> log = new ArrayList<>();
        try {
            log.add("Entering second try");
            Object object = null;
            object.toString();
            log.add("Printing object");
        } catch (ArithmeticException e) {
            log.add("Division by zero");
        } catch (Exception e) {
            log.add("An exception occurred");
        } finally {
            log.add("Entering second finally");
        }
        return log;
    }
}