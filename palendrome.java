import java.util.Scanner;

class Palendrome
{
    static Scanner keyboard = new Scanner(System.in);
    static char[] A;
    static char[] inputArray;
    static String input;
    static String lcNoPeriods;
    static char used;
    static int length;

    public Palendrome(){}
   
    public static boolean isPalendrome(char[] A, int used){
        
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
            System.out.print("Program ending. Thank you!");
            System.exit(0);
        }

        return true;
    }

    public static void main(String[] args) {

    do{

    System.out.print("Enter word or sentence terminated with a period to test if it's a palindrome: ");
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

    if(!isPalendrome(A, used)){
        System.out.println("\""+input+"\""+" is not a palindrome.");
        }else{ 
            System.out.println("\""+input+"\""+" is a palindrome.");
        }

    }while(repeat());
    
  }

}