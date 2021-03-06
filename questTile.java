public class questTile
{
    String[] tileList = {"encounter", "event-good", "event-bad", "event-neutral", "shop"};
    String tileType;
    int tileLength = tileList.length;
    double tileSelector;
    monster encounter;
    eventgood good;
    eventbad bad;
    eventneutral neutral;
    shop shop;
    boolean tileDefeated = false;

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public questTile(monster monster, eventbad eventbad, eventgood eventgood, eventneutral eventneutral, shop newShop)
    {
        encounter = null;
        bad = null;
        good = null;
        neutral = null;
        shop = null;
        tileSelector = getRandomIntegerBetweenRange(1, 100);

        if(tileSelector>0&&tileSelector<16) //these if statements have to equal 100 in total. also, sorry future me but for some reason i wanted to use only
        {                                   // less than and greater than, not equal to... maybe ill fix it one day
            tileType = "encounter";
            encounter = monster;
        }
        if(tileSelector>15&&tileSelector<41)
        {
            tileType = "event-neutral";
            neutral = eventneutral;
        }
        if(tileSelector>40&&tileSelector<71)
        {
            tileType = "shop";
            shop = newShop;
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

    public boolean getDefeated() {
        return tileDefeated;
    };

    public boolean setDefeated(boolean changeDefeated) {
        tileDefeated = changeDefeated;
        return tileDefeated;
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
        if(neutral != null)
        {
            return "This tile is a "+ tileType + " with the event: " + neutral.getEvent(); 
        }
        if(shop != null)
        {
            return "This tile is a "+ tileType + " and " + shop.getInfo(); 
        }
        return "This tile is a "+ tileType;
    }
}