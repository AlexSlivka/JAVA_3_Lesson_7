import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainApp {
    public static void main(String[] args) {
        Class testClass1 = BoxForTest.class;
        try {
            start(testClass1);
        } catch (InvocationTargetException | RuntimeException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = testClass.getDeclaredMethods();
        int numBeforeSuite = 0;
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                numBeforeSuite++;
                if (numBeforeSuite > 1) {
                    throw new RuntimeException("Аннотаций BeforeSuite больше, чем одна");
                }
                m.invoke(null);
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (Method m : methods) {
                if (m.isAnnotationPresent(Test.class)) {
                    if (m.getAnnotation(Test.class).priority() == i) {
                        System.out.println("Приоритет метода: " + m.getAnnotation(Test.class).priority());
                        m.invoke(null);
                    }
                }
            }

        }



        int numAfterSuite = 0;
        for (Method m : methods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                numAfterSuite++;
                if (numAfterSuite > 1) {
                    throw new RuntimeException("Аннотаций AfterSuite больше, чем одна");
                }
                m.invoke(null);
            }

        }
    }
}
