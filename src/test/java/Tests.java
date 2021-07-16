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
    public void testDivByZero(Object in1, Object in2) throws ZeroDivideException {
        Calculator.div(in1, in2);
    }

    private void startMainCalculator(Object[] args) throws ZeroDivideException, IncorrectArgsCount, IncorrectOperator {
        String[] params = new String[args.length];
        for (int i = 0; i < params.length; ++i) {
            params[i] = args[i].toString();
        }
        Calculator.main(params);
    }

    @Test(dataProvider = "testIncorrectArgsCount", dataProviderClass = Data.class, expectedExceptions = IncorrectArgsCount.class,
            expectedExceptionsMessageRegExp = "There should be 3 arguments: operation, first number, second number.")
    public void testIncorrectArgsCount(Object[] args) throws ZeroDivideException, IncorrectOperator, IncorrectArgsCount {
        startMainCalculator(args);
    }

    @Test(dataProvider = "testIncorrectOperator", dataProviderClass = Data.class, expectedExceptions = IncorrectOperator.class,
            expectedExceptionsMessageRegExp = "^Operation \".*\" wasn't recognized\\..*")
    public void testIncorrectOperator(Object[] args) throws ZeroDivideException, IncorrectOperator, IncorrectArgsCount {
        startMainCalculator(args);
    }

    @Test(dataProvider = "testIncorrectValues", dataProviderClass = Data.class, expectedExceptions = NumberFormatException.class,
            expectedExceptionsMessageRegExp = "^Parsing exception\\..*")
    public void testIncorrectValues(Object[] args) throws ZeroDivideException, IncorrectOperator, IncorrectArgsCount {
        startMainCalculator(args);
    }
}
