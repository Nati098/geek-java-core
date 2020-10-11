package professional.hw7;

public class TestedClass {

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
}
