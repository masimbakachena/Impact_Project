package za.co.kachena;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class NumberRangeSummarizerTest {
    NumberRangeSummarizer numberRangeSummarizer;
    String input1 = "1,2,3";
    String input2 = "100,4678,5,4,605605,605606,605607,0,5,7,6,7";
    String input3 = "1,2,3,4,5,6,7,8,9,10,11,12";
    String input4 = "12,11,10,9,8,7,77,76,75,6,7";
    String input5 = "1,2";
    @Before
    public void setup() {
        numberRangeSummarizer = new NumberRangeSummarizerImpl();
    }

    @Test
    public void test_Collect(){
        Assert.assertNotNull(input1);
        Assert.assertTrue(input1.matches("(\\d+,)+\\d+"));
        Assert.assertEquals(List.of(1,2,3), numberRangeSummarizer.collect(input1));
        Assert.assertNotNull(input2);
        Assert.assertTrue(input2.matches("(\\d+,)+\\d+"));
        Assert.assertEquals(List.of(100,4678,5,4,605605,605606,605607,0,5,7,6,7), numberRangeSummarizer.collect(input2));
        Assert.assertNotNull(input3);
        Assert.assertTrue(input3.matches("(\\d+,)+\\d+"));
        Assert.assertEquals(List.of(1,2,3,4,5,6,7,8,9,10,11,12), numberRangeSummarizer.collect(input3));
        Assert.assertNotNull(input4);
        Assert.assertTrue(input4.matches("(\\d+,)+\\d+"));
        Assert.assertEquals(List.of(12,11,10,9,8,7,77,76,75,6,7), numberRangeSummarizer.collect(input4));
        Assert.assertNotNull(input4);
        Assert.assertTrue(input4.matches("(\\d+,)+\\d+"));
        Assert.assertEquals(List.of(1,2), numberRangeSummarizer.collect(input5));
    }

    @Test
    public void test_SummarizeCollection(){
        Assert.assertEquals("1-3", numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(input1)));
        Assert.assertEquals("100,4678,5,4,605605-605607,0,5,7,6-7", numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(input2)));
        Assert.assertEquals("1-12", numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(input3)));
        Assert.assertEquals("12,11,10,9,8,7,77,76,75,6-7", numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(input4)));
        Assert.assertEquals("1-2", numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(input5)));

    }



}
