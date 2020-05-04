public class eventgood
{

    String[] eventList = {"heal", "item", "powerup"};
    String eventType;
    int eventLength = eventList.length;
    double eventSelector;
    boolean visited = false;

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public eventgood()
    {
        eventSelector = getRandomIntegerBetweenRange(1, 100);

        if(eventSelector>=1&&eventSelector<=50)
        {
            eventType = "heal";
        }
        if(eventSelector>=51&&eventSelector<=80)
        {
            eventType = "item";
        }
        if(eventSelector>=81&&eventSelector<=100)
        {
            eventType = "powerup";
        } 
    }

    public String getEvent(){return eventType;}

    public String setType(String newEvent) {
        eventType = newEvent;
        return newEvent;
    };

    public boolean getVisited()
    {
        return visited;
    }

    public boolean setVisited(boolean newVisited)
    {
        visited = newVisited;
        return visited;
    }

    public String getInfo() {return "This is a good tile that has the event: "+ eventType;
    }
}