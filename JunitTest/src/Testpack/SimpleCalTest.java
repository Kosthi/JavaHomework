package Testpack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleCalTest {
    @Test
    public void TestCase1() {
        assertEquals(Sample.simplyCal(10), 170);
        assertEquals(Sample.simplyCal(100), 9800);
    }
}
