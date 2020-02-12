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


    }
}
