
public class rQuestMain 
{
  static player playerCharacter;
  static int numOfTiles = 30;

  public static double getRandomIntegerBetweenRange(double min, double max)
  {
    double x = (int)(Math.random()*((max-min)+1))+min;
    return x;
  }

  public static void generateMonster(monster[] monsters, weapon[] weapons) 
  {
    
    for (int i = 0; i < monsters.length; i++) 
    {
      boolean hasWeapon = hasWeapon();
      monsters[i] = new monster(hasWeapon, weapons[i]);
    }
    for (int i = 0; i < monsters.length; i++) {
      System.out.println(monsters[i].getInfo());
    }
  }

  public static void generateShop(shop[] shops, weapon[] weapons) 
  {
    
    for (int i = 0; i < shops.length; i++) 
    {
      shops[i] = new shop(weapons[(int)getRandomIntegerBetweenRange(0, numOfTiles-1)], weapons[(int)getRandomIntegerBetweenRange(0, numOfTiles-1)], weapons[(int)getRandomIntegerBetweenRange(0, numOfTiles-1)]);
    }
    for (int i = 0; i < shops.length; i++) {
      System.out.println(shops[i].getInfo());
    }
  }

  public static void generateTiles(questTile[] tileSet, monster[] monsters, eventgood[] eventgood, eventbad[] eventbad, shop[] shops) 
  {
    for (int i = 0; i < tileSet.length; i++) 
    {
      tileSet[i] = new questTile(monsters[i], eventbad[i], eventgood[i], shops[i]);
      while(i!=0 && tileSet[i].getType()=="shop" && tileSet[i-1].getType()=="shop")
      {
        tileSet[i] = new questTile(monsters[i], eventbad[i], eventgood[i], shops[i]);
      }
    }
    for (int i = 0; i < tileSet.length; i++) {
      System.out.println(tileSet[i].getInfo());
    }
  }
  public static void generateEventGood(eventgood[] eventgood) 
  {
    for (int i = 0; i < eventgood.length; i++) 
    {
      eventgood[i] = new eventgood();
    }
    for (int i = 0; i < eventgood.length; i++) {
      System.out.println(eventgood[i].getInfo());
    }
  }
  public static void generateEventBad(eventbad[] eventbad) 
  {
    for (int i = 0; i < eventbad.length; i++) 
    {
      eventbad[i] = new eventbad();
    }
    for (int i = 0; i < eventbad.length; i++) {
      System.out.println(eventbad[i].getInfo());
    }
  }

  public static void generateWeapons(weapon[] weapons) 
  {
    for (int i = 0; i < weapons.length; i++) 
    {
      weapons[i] = new weapon();
    }
    for (int i = 0; i < weapons.length; i++) {
      System.out.println(weapons[i].getInfo());
    }
  }

  public static void createPlayer()
  {
    playerCharacter = new player();
    System.out.println(playerCharacter.getInfo());
  }

  public static boolean hasWeapon()
  {
    int rand = (int) (0 + 2 * Math.random());
    if(rand == 1){return true;}
    else{return false;}
  }

  public static void main(String[] args) 
  {
    monster[] monsters = new monster[numOfTiles];
    weapon[] weapons = new weapon[numOfTiles];
    questTile[] tileSet = new questTile[numOfTiles];
    eventgood[] eventgood = new eventgood[numOfTiles];
    eventbad[] eventbad = new eventbad[numOfTiles];
    shop[] shops = new shop[numOfTiles];

    createPlayer();
    generateWeapons(weapons);
    generateMonster(monsters, weapons);
    generateEventGood(eventgood);
    generateEventBad(eventbad);
    generateShop(shops, weapons);
    generateTiles(tileSet, monsters, eventgood, eventbad, shops);
  }
}