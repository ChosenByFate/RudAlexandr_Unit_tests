import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {
    @Test(dataProvider = "testAdd", dataProviderClass = Data.class)
    public void testAdd(Object expected, Object in1, Object in2) {
        Assert.assertEquals(expected, Calculator.add(in1, in2));
    }

    @Test(dataProvider = "testSub", dataProviderClass = Data.class)
    public void testSub(Object expected, Object in1, Object in2) {
        Assert.assertEquals(expected, Calculator.sub(in1, in2));
    }

    @Test(dataProvider = "testMul", dataProviderClass = Data.class)
    public void testMul(Object expected, Object in1, Object in2) {
        Assert.assertEquals(expected, Calculator.mul(in1, in2));
    }

    @Test(dataProvider = "testDiv", dataProviderClass = Data.class)
    public void testDiv(Object expected, Object in1, Object in2) throws ZeroDivideException {
        Assert.assertEquals(expected, Calculator.div(in1, in2));
    }

    @Test(dataProvider = "testDivByZero", dataProviderClass = Data.class, expectedExceptions = ZeroDivideException.class)
    public void testDivByZero(Object expected, Object in1, Object in2) throws ZeroDivideException {
        Calculator.div(in1, in2);
        Calculator.main(new String[]{"s"});
    }

    @Test(dataProvider = "testIncorrectValues", dataProviderClass = Data.class)
    public void testIncorrectValues(Object[] args) throws ZeroDivideException {
        String[] params = new String[args.length];
        for (int i = 0; i < params.length; ++i) {
            params[i] = args[i].toString();
        }
        Calculator.main(params);
    }
}
