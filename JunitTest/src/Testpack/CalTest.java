package Testpack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalTest {

    // 第1个判定中的“AND”错写成了“OR”
    @Test
    public void TestWrongOrForAnd1() {
        assertEquals(2, Sample.cal(2, 0, 3));
    }

    // 第2个判定中的“x>1”错写成了“x<=1”
    @Test
    public void TestXLessOrEqual1() {
        assertEquals(2, Sample.cal(2, 0, 3));
    }

    // 第1个判定中的“AND”错写成了“OR”
    @Test
    public void TestWrongOrForAnd2() {
        assertEquals(0, Sample.cal(3, 0, 1));
        assertEquals(3, Sample.cal(2, 1, 2));
    }

    // 第2个判定中的“x>1”错写成了“x<=1”
    @Test
    public void TestXLessOrEqual2() {
        assertEquals(0, Sample.cal(3, 0, 1));
        assertEquals(3, Sample.cal(2, 1, 2));
    }

    // 第2个判定中的“x>1”错写成了“x<=1”
    @Test
    public void TestXLessOrEqual3() {
        // assertEquals(0, Sample.cal(2, 0, 3));
        assertEquals(1, Sample.cal(1, 1, 1));
    }

    // 第1个判定中的“a>1”错写成了“a<=1”，且把“b=0”错写成了“b<>0”
    @Test
    public void TestCase6() {
        assertEquals(2, Sample.cal(2, 1, 1));
        assertEquals(3, Sample.cal(1, 0, 2));
    }

    // 第1个判定中的“a>1”错写成了“a<=1”，且把“b=0”错写成了“b<>0”
    @Test
    public void TestCase7() {
        assertEquals(2, Sample.cal(2, 1, 1));
        assertEquals(2, Sample.cal(2, 0, 2));
        assertEquals(1, Sample.cal(1, 1, 1));
        assertEquals(3, Sample.cal(1, 0, 2));
    }
}
