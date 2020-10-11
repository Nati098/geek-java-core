package professional.hw7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRunner {

    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();

        // check BeforeSuite and AfterSuite
        boolean manyBeforeSuites = Arrays.stream(methods).filter(it -> it.isAnnotationPresent(BeforeAll.class)).count() > 1;
        boolean manyAfterSuites = Arrays.stream(methods).filter(it -> it.isAnnotationPresent(AfterAll.class)).count() > 1;
        if (manyBeforeSuites || manyAfterSuites) {
            throw new RuntimeException("Many BeforeSuite/AfterSuite annotations");
        }

        Map<Integer, List<Method>> sortedMethods = new TreeMap<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeAll.class)) {
                sortedMethods.put(0, Arrays.asList(m));
            }

            if (m.isAnnotationPresent(AfterAll.class)) {
                sortedMethods.put(11, Arrays.asList(m));
            }

            if (m.isAnnotationPresent(TestAnnotation.class)) {
                int priority = m.getAnnotation(TestAnnotation.class).priority();
                
                if (!sortedMethods.containsKey(priority)) {
                    sortedMethods.put(priority, new ArrayList<>());
                }
                
                sortedMethods.get(priority).add(m);
            }
        }

        sortedMethods.forEach((k, v) -> v.forEach(m -> {
            try {
                m.invoke(null);
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException in priority="+k+" in method "+m);
            } catch (InvocationTargetException e) {
                System.out.println("InvocationTargetException in priority="+k+" in method "+m);
            }
        }));

    }

}
