import java.util.ArrayList;

/**
 * Created by Stephen on 9/5/16.
 */
public class Strike
{
    public static int roll (int score, ArrayList numArray, int numThrows)
    {
        score = score + ((Integer)numArray.get(numThrows))+ ((Integer)numArray.get(numThrows+1)) + ((Integer)numArray.get(numThrows+2));
        return score;
    }
}
