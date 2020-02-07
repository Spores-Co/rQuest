
public class rQuestMain 
{
  static player playerCharacter;
  static int numOfTiles = 30;

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

  public static void generateTiles(questTile[] tileSet, monster[] monsters, eventgood[] eventgood, eventbad[] eventbad) 
  {
    for (int i = 0; i < tileSet.length; i++) 
    {
      tileSet[i] = new questTile(monsters[i], eventbad[i], eventgood[i]);
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

    createPlayer();
    generateWeapons(weapons);
    generateMonster(monsters, weapons);
    generateEventGood(eventgood);
    generateEventBad(eventbad);
    generateTiles(tileSet, monsters, eventgood, eventbad);
  }
}