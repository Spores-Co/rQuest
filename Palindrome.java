import java.util.Scanner;

class Palindrome
{
    static Scanner keyboard = new Scanner(System.in);
    static char[] A;
    static char[] inputArray;
    static String input;
    static String lcNoPeriods;
    static char used;
    static int length;

    public Palindrome(){}
   
    public static boolean isPalindrome(char[] A, int used){
        
        for (used = 0; used < (length/2); used++) {
            if (A[used] != A[length - used - 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean repeat(){
    
        System.out.print("Would you like to check another? Enter Yes or No: ");
        String answer = keyboard.nextLine();

        if(answer.equalsIgnoreCase("No")){
            System.out.print("\nProgram ending. Thank you!");
            System.exit(0);
        }

        return true;
    }

    public static void main(String[] args) {

    do{

    System.out.print("\nEnter word or sentence terminated with a period to test if it's a palindrome: ");
        input = keyboard.nextLine();

    String noSpaces = input.replaceAll(" ", "");
    String noPeriods = noSpaces.replace(".", "");
    lcNoPeriods = noPeriods.toLowerCase();
    length = lcNoPeriods.length();
    
    A = new char[length];
    inputArray = new char[length];
    
    for(int i=0; i<length; i++){
        inputArray[i] = lcNoPeriods.charAt(i);
    } 

    for(int i=0; i<length; i++){
        A[i] = inputArray[i];
    }

    if(!isPalindrome(A, used)){
        System.out.println("\n\""+input+"\""+" is not a palindrome.\n");
        }else{ 
            System.out.println("\n\""+input+"\""+" is a palindrome.\n");
        }

    }while(repeat());
    
  }

}