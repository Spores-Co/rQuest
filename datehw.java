import java.util.Scanner;
public class datehw{
    public static void main(String[] args){
        String date;
        int month, day, year;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a date in the format mm/dd/yyyy");
        date = keyboard.next();
        String[] splitDate = date.split("/");

        month = Integer.parseInt(splitDate[0]);
        day = Integer.parseInt(splitDate[1]);
        year = Integer.parseInt(splitDate[2]);

        System.out.println(month);
        System.out.println(day);
        System.out.println(year);
        if (month>=1 && month<=12){
        }   else {
           System.out.println(date+" is not valid because "+month+" doesn't exist");
           System.exit(0);
        }
       
        if (month==4 || month==6 || month==9 || month==11)
              {
           if (day<=30)
                    System.out.print("");
                  else{
                    System.out.println(date+" is not a valid date because "+day+" is not a day in month "+month);
                    System.exit(0);
                }
            }
        
        if (month==1 || month==3 || month==5 || month<=8 && month>6 || month<=10 && month>9 || month==12)
              { 
           if (day<=31)
                    System.out.print("");
           else {
                    System.out.println(date+" is not a valid date because "+day+" is not a day in month "+month); 
                    System.exit(0);
                }
            }    
        
        if(month==2)
              {
            if (day<=28 || day<=29)
                    System.out.print("");
            else{
                    System.out.print(date+" is not a valid date because "+day+" is not a day in month "+month);
                    System.exit(0);
                }
            }
            
        if(month==2 && day==29){
            if(year % 4 == 0 && year % 100!= 0 || year%400 == 0)
                System.out.print(""); 
            else{
                  System.out.println(date+ " is not a valid date because "+ year+" is not a leap year.");
                  System.exit(0);
                }
            }
            
        System.out.println(date+" is a valid date");
        
    }
}
