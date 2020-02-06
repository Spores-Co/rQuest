import java.util.*;

public class goblin
{
    int health, modifier;
    String name;
    String [] firstName;
    String [] lastName;
    int fnameLength = firstName.length;
    int lnameLength = lastName.length;
    public goblin()
    {
        health = (int) (7 + 10 * Math.random());
        modifier = .75;
        name = firstName[(int) (0 + fnameLength * Math.random())] +  lastName[(int) (0 + lnameLength * Math.random())];
    }
}