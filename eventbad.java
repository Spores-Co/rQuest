public class eventbad
{
    String[] eventList = {"damage", "powerdown"};
    String eventType;
    int eventLength = eventList.length;
    double eventSelector;
    boolean visited = false;

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public eventbad()
    {
        eventSelector = getRandomIntegerBetweenRange(1, 100);

        if(eventSelector>=1&&eventSelector<=50)
        {
            eventType = "damage";
        }
        if(eventSelector>=51&&eventSelector<=100)
        {
            eventType = "powerdown";
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

    public String getInfo() {return "This is a bad tile that has the event: "+ eventType;
    }
}