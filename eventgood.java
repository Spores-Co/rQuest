public class eventgood
{
    String[] eventList = {"heal", "item", "powerup"};
    String eventType;
    int eventLength = eventList.length;
    double eventSelector;

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public eventgood()
    {
        eventSelector = getRandomIntegerBetweenRange(1, 100);

        if(eventSelector>0&&eventSelector<81)
        {
            eventType = "heal";
        }
        if(eventSelector>80&&eventSelector<91)
        {
            eventType = "item";
        }
        if(eventSelector>90&&eventSelector<101)
        {
            eventType = "powerup";
        } 
    }

    public String getEvent(){return eventType;}

    public String setType(String newEvent) {
        eventType = newEvent;
        return newEvent;
    };

    public String getInfo() {return "This is a good tile that has the event: "+ eventType;
    }
}