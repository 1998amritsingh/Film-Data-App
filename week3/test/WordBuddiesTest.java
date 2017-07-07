import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1998a on 1/23/2017.
 */
public class WordBuddiesTest {
    @Test
    public void compareWord() throws Exception {
        String input = "scar";
        String input2 = "feature";

        assertEquals("scar",WordBuddies.CompareWord(input,input2));
    }

    @Test
    public void compareArray() throws Exception {
        String [] input = {"scar", "feature", "fee", "tsarina"};
        String [] input2 = {"lol", "fail", "epicfail", "superfail"};
        String [] input3 = {"scar", "tsarina", "lol", "fail"};
        String [] input4 = {"scar", "feature", "fee", "feels"};

        assertArrayEquals(new String[]{"ar","fe","fe","ar"},WordBuddies.CompareArray(input));
        assertArrayEquals(new String[]{"Not Buddies"},WordBuddies.CompareArray(input2));
        assertArrayEquals(new String[]{"Not Buddies"},WordBuddies.CompareArray(input3));
        assertArrayEquals(new String[]{"Not Buddies"},WordBuddies.CompareArray(input4));


    }

    @Test
    public void printArray() throws Exception {
        String [] input = {"scar", "feature", "fee", "tsarina"};
        String [] input2 = {"lol", "fail", "epicfail", "superfail"};
        String [] input3 = {"scar", "tsarina", "lol", "fail"};
        String [] input4 = {"scar", "feature", "fee", "feels"};

        assertEquals("ar fe fe ar",WordBuddies.printArray(input));
        assertEquals("Not Buddies",WordBuddies.printArray(input2));
        assertEquals("Not Buddies",WordBuddies.printArray(input3));
        assertEquals("Not Buddies",WordBuddies.printArray(input4));



    }

}