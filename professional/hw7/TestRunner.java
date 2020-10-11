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
        Stream<Method> beforeSuites = Arrays.stream(methods).filter(it -> it.isAnnotationPresent(BeforeAll.class));
        Stream<Method> afterSuites = Arrays.stream(methods).filter(it -> it.isAnnotationPresent(AfterAll.class));
        if (beforeSuites.count() > 1 || afterSuites.count() > 1) {
            throw new RuntimeException("Many BeforeSuite/AfterSuite annotations");
        }

        LinkedHashMap<Integer, List<Method>> sortedMethods = new LinkedHashMap<>();
        sortedMethods.put(0, beforeSuites.collect(Collectors.toList()));
        sortedMethods.put(11, afterSuites.collect(Collectors.toList()));

        for (Method m : methods) {
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
//                e.printStackTrace();
            } catch (InvocationTargetException e) {
                System.out.println("InvocationTargetException in priority="+k+" in method "+m);
//                e.printStackTrace();
            }
        }));
    }

}
