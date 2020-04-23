public class eventneutral
{
    String[] eventList = {"flavor", "nextTileHint"};
    String eventType;
    int eventLength = eventList.length;
    double eventSelector;

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public eventneutral()
    {
        eventSelector = getRandomIntegerBetweenRange(1, 100);

        if(eventSelector>0&&eventSelector<51)
        {
            eventType = "flavor";
        }
        if(eventSelector>50&&eventSelector<101)
        {
            eventType = "nextTileHint";
        }
    }

    public String getEvent(){return eventType;}

    public String setType(String newEvent) {
        eventType = newEvent;
        return newEvent;
    };

    public String getInfo() {return "This is a neutral tile that has the event: "+ eventType;
    }
}