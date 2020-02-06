public class eventbad
{
    String[] eventList = {"damage", "powerdown"};
    String eventType;
    int eventLength = eventList.length;
    double eventSelector;

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public eventbad()
    {
        eventSelector = getRandomIntegerBetweenRange(1, 100);

        if(eventSelector>0&&eventSelector<81)
        {
            eventType = "damage";
        }
        if(eventSelector>80&&eventSelector<101)
        {
            eventType = "powerdown";
        }
    }

    public String getEvent(){return eventType;}
    
    public String setType(String newEvent) {
        eventType = newEvent;
        return newEvent;
    };

    public String getInfo() {return "This is a bad tile that has the event: "+ eventType;
    }
}