public class Time{
    private int hour;
    private int minute;
    //vairable for am or pm
    private String session="";
    //default constructor
    public Time(){
        //call to setTime(int, int) method with default values
        setTime(0,0);
    }

    public Time(int newHour, int newMinute){
        setTime(newHour, newMinute);
    }

    public Time(int newHour, int newMinute, boolean isAM){
        setTime(newHour, newMinute, isAM);
    }

    public void setTime(int newHour, int newMinute){
        //call isValid method
        if(isValid(newHour, newMinute)){
            hour = newHour;
            minute = newMinute;
            if(newHour<12){
                session = "am";
            }else{
                session = "pm";
            }
        }
    }

    public void setTime(int newHour, int newMinute, boolean isAM){
        if(isValid(newHour, newMinute)){
            hour = newHour;
            minute = newMinute;
            if(newHour<12)
                session="am";
             else if(newHour >= 12)
                    session = "pm";
             else
                session = "not valid.";
            }

    }
    

        public String getTime24(){
            String time = "";
            if(hour<10){
                time += "0";
                time += hour;
            }else{
                time += hour;
            }
            if(minute<10){
                time +="0";
                time += minute;
            }else{
                time += minute;
            }
            return time;
        }

        public String getTime12(){
            String time="";
            if(hour == 0){
                time += 12;
                time+=":";

            }
            if(hour<=12 && hour>0){
                time += hour;
                time+=":";
            }
            if(hour>12){
                time += hour%12;
                time+=":";
            }

            String newTime="";
            
            if(minute<10){
                newTime+="0";
                newTime+=minute+" "+session;

            }else{
                newTime = minute+" "+ session;
            }
            time += newTime;
            return time;
        }

        private boolean isValid(int hour, int minute){
            if((hour<0||hour>23)||(minute<0||minute>59)){
                return false;
            }
            return true;
        }

      
    
        public static void main(String[] args){
            Time insertTime = new Time(23,59);
            System.out.println(insertTime.getTime12());
            System.out.println(insertTime.getTime24());
        }

    }  
