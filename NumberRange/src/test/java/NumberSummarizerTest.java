import org.example.NumberSummarizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;


public class NumberSummarizerTest {
    //Testing a collection integers method
    @Test
    public void testCollectedNumbers(){
        NumberSummarizer numberRange = new NumberSummarizer();
        String numbers = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> result =numberRange.collect(numbers);
        Assert.assertEquals(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31),result);

    }
// Testing Summarized range of numbers.
    @Test
    public void testSummarizedCollection(){

        NumberSummarizer numberRange = new NumberSummarizer();
        Collection<Integer> listCollected =  Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
        String summarizedNumbers = numberRange.summarizeCollection(listCollected);
        System.out.println(summarizedNumbers);
        Assert.assertEquals("1, 3, 6 - 8, 12 - 15, 21 - 24, 31",summarizedNumbers);
    }

}
