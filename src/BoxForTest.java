public class BoxForTest {
    @BeforeSuite
    public static void test1(){
        System.out.println("Test 1 START");
    }

    @Test(priority = 2)
    public static void test2(){
        System.out.println("Test 2");
    }

    @Test
    public static void test3(){
        System.out.println("Test 3");
    }

    @Test(priority = 2)
    public static void test4(){
        System.out.println("Test 5");
    }

    @Test(priority = 3)
    public static void test5(){
        System.out.println("Test 6");
    }

    @Test(priority = 3)
    public static void test6(){
        System.out.println("Test 6");
    }

    @Test(priority = 7)
    public static void test7(){
        System.out.println("Test 7");
    }

    @Test
    public static void test8(){
        System.out.println("Test 8");
    }

    @Test(priority = 5)
    public static void test9(){
        System.out.println("Test 9");
    }

    @AfterSuite
    public static void test10(){
        System.out.println("Test 10 END");
    }
}
