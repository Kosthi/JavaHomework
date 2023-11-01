package Testpack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoopCalTest {
    @Test
    public void TestCase1() {
        assertEquals(Sample.loopCal(0, 0), 24548);
    }

    @Test
    public void TestCase2() {
        assertEquals(Sample.loopCal(0, 1), 26596);
    }
}
