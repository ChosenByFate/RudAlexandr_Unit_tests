import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider
    private static Object[][] testAdd() {
        return new Object[][] {
                {1., 0, 1},
                {0., 0, 0},
                {100., -111, 211},
                {-Double.MAX_VALUE+1, -Double.MAX_VALUE, 1},
                {Double.MAX_VALUE, Double.MAX_VALUE-1, 1},
        };
    }

    @DataProvider
    private static Object[][] testSub() {
        return new Object[][] {
                {-1., 0, 1},
                {0., 0, 0},
                {100., 11, -89},
                {-Double.MAX_VALUE, -Double.MAX_VALUE+1, 1},
                {Double.MAX_VALUE-1, Double.MAX_VALUE, 1},
        };
    }

    @DataProvider
    public static Object[][] testMul() {
        return new Object[][] {
                {0., 51, 0},
                {-1000., -10, 100},
                {-979., 11, -89},
                {-Double.MAX_VALUE, -Double.MAX_VALUE / 2, 2},
                {Double.MAX_VALUE, Double.MAX_VALUE / 2, 2},
        };
    }

    @DataProvider
    public static Object[][] testDiv() {
        return new Object[][] {
                {0., 0, 20},
                {-10., 50, -5},
                {Double.MIN_VALUE, Double.MIN_VALUE, 1},
                {Double.MAX_VALUE, Double.MAX_VALUE, 1}
        };
    }

    @DataProvider
    public static Object[][] testDivByZero() {
        return new Object[][] {
                {11, 0},
                {-11, 0},
        };
    }

    @DataProvider
    public static Object[][] testIncorrectArgsCount() {
        return new Object[][] {
                {"*", "str", "str", "str"},
                {"*", "7"},
                {"+"}
        };
    }

    @DataProvider
    public static Object[][] testIncorrectOperator() {
        return new Object[][] {
                {"str", 11, 0}
        };
    }

    @DataProvider
    public static Object[][] testIncorrectValues() {
        return new Object[][] {
                {"/", "*", 10},
                {"/", 11, "*"},
                {"*", "str", "str"}
        };
    }
}
