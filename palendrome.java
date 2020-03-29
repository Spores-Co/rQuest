import java.util.Scanner;

class palendrome
{
    static Scanner keyboard = new Scanner(System.in);
    static char[] A;
    static char[] inputArray;
    static String input;
    static char used;
    static int length;
    static boolean loop = true;
   
    public static boolean isPalendrome(char[] A, int used)
    {
        for (used = 0; used < (length/2); used++) 
        {
            if (A[used] != A[length - used - 1]) 
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) 
  {
    while(loop)
    {
    System.out.print("Enter palendrome: ");
    input = keyboard.nextLine();
    //System.out.println(input);
    String noSpaces = input.replaceAll(" ", "");
    //System.out.println(noSpaces);
    String noPeriods = noSpaces.replace(".", "");
    length = noPeriods.length();
    //System.out.println(noPeriods);
    A = new char[length];
    inputArray = new char[length];
    
    for(int i=0; i<length; i++)
    {
        inputArray[i] = noPeriods.charAt(i);
    } 

    for(int i=0; i<length; i++)
    {
        A[i] = inputArray[i];
      
    }

    /*for(int i=0; i<length; i++)
    {
        System.out.println(A[i]);
    } */
   
        if(!isPalendrome(A, used))
        { System.out.println("FALSE");}
        else{ System.out.println("TRUE");}
        System.out.print("Would you like to play again? Enter Y or N: ");
        String answer = keyboard.nextLine();
        if(answer=="N")
        {
            System.out.print("Program ending. Thank you!");
            break;
        }
    }
    
  }

}