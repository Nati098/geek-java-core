package professional.hw7;

import org.junit.jupiter.api.BeforeAll;

public class TestedClass {
    @BeforeAll
    public static void init(){
        System.out.println("Before All init() method called");
    }

    @TestAnnotation(priority = 1)
    public static void test1(){
        System.out.println("test1");
    }

    @TestAnnotation()
    public static void test2(){
        System.out.println("test2");
    }

    @TestAnnotation(priority = 9)
    public static void test3(){
        System.out.println("test3");
    }

    @TestAnnotation(priority = 3)
    public static void test4(){
        System.out.println("test4");
    }

    @TestAnnotation()
    public static void test5(){
        System.out.println("test5");
    }
}
