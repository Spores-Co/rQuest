public class questTile
{
    String[] tileList = {"encounter", "event-good", "event-bad", "shop"};
    String tileType;
    int tileLength = tileList.length;
    double tileSelector;
    monster encounter;
    eventgood good;
    eventbad bad;

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public questTile(monster monster, eventbad eventbad, eventgood eventgood)
    {
        encounter = null;
        bad = null;
        good = null;
        tileSelector = getRandomIntegerBetweenRange(1, 100);

        if(tileSelector>0&&tileSelector<61)
        {
            tileType = "encounter";
            encounter = monster;
        }
        if(tileSelector>60&&tileSelector<71)
        {
            tileType = "shop";
        }
        if(tileSelector>70&&tileSelector<86)
        {
            tileType = "event-good";
            good = eventgood;
        }
        if(tileSelector>85&&tileSelector<101)
        {
            tileType = "event-bad";
            bad = eventbad;
        }
    }

    public String getType() {
        return tileType;
    };

    public String setType(String newType) {
        tileType = newType;
        return newType;
    };

    public monster getEncounter() {
        return encounter;
    };

    public monster setEncounter(monster newEncounter) {
        encounter = newEncounter;
        return newEncounter;
    };

    public String getInfo() 
    {
        if(encounter != null)
        {
            return "This tile is a "+ tileType + " with a(n): " + encounter.getSpecies(); 
        }
        if(bad != null)
        {
            return "This tile is a "+ tileType + " with the event: " + bad.getEvent(); 
        }
        if(good != null)
        {
            return "This tile is a "+ tileType + " with the event: " + good.getEvent(); 
        }
        return "This tile is a "+ tileType;
    }
}