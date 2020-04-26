import java.util.Scanner;

public class rquestMain 
{
  static player playerCharacter;
  static int numOfTiles = 30;
  static weapon[] weapons = new weapon[numOfTiles];
  static String encounterInfo;
  static String[] healEventText = { "You trip over a half-consumed healing potion and decide to drink it. ", "As you walk down the path, you notice a bush with fruit growing from it. Do you eat the fruit? "};
  static String[] itemEventText = { "You stumble over something while walking down the road. Upon further inspection, you notice it's a ", "You come across a dead body. You notice a weapon still in its sheath. Upon inspection, you identify it as a "};
  static questTile[] tileSet = new questTile[numOfTiles];
  static String[] speciesList = { "human", "orc", "elf", "gnome", "dragonborn", "dwarf" };
  static String[] monsterSpeciesList = { "goblin", "hobgoblin", "rat", "kobold", "banshee", "spider", "lizard", "troll", "giant",
            "beetle", "bandit", "dragon", "bat", "snake", "bear", "slime" };
  static String[] firstName = { "Rhaelhall", "Fipa", "Daviecrusha", "Mythicson", "Silvacackle", "Anskelisia", "Reyesookie",
          "Morganhugia", "Iflee", "Benallopa", "Silva", "Hartrositia", "Simsensteinia", "Yosaunders", "Benalka",
          "Olakelley", "Slimerice", "Burgat", "Thudguzman", "Hammasrice", "Philaf", "Harrisrek", "Rhaelrter",
          "Gagruel", "Murphire", "Mcdonahell", "Jikinirthy" };
  static String[] lastName = { "the parallel", "the juvenile", "the subdued", "the squalid", "the violent", "the fretful",
          "the powerful", "the wary", "the broad", "the ludicrous", "the dizzy", "the intelligent", "the grotesque",
          "the annoying", "the wealthy", "the puny", "the bizarre", "the learned", "the cumbersome", "the chilly",
          "the resolute", "the juvinile", "the frantic", "the industrious", "the hellish", "the puzzled" };

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
    /*for (int i = 0; i < monsters.length; i++) {
      System.out.println(monsters[i].getInfo());*/
    }
  //}

  public static void generateShop(shop[] shops, weapon[] weapons) 
  {
    
    for (int i = 0; i < shops.length; i++) 
    {
      shops[i] = new shop(weapons[(int)getRandomIntegerBetweenRange(0, numOfTiles-1)], weapons[(int)getRandomIntegerBetweenRange(0, numOfTiles-1)], weapons[(int)getRandomIntegerBetweenRange(0, numOfTiles-1)]);
    }
    /*for (int i = 0; i < shops.length; i++) {
      System.out.println(shops[i].getInfo());*/
    }
  //}

  public static void generateTiles(questTile[] tileSet, monster[] monsters, eventgood[] eventgood, eventbad[] eventbad, eventneutral[] eventneutral, shop[] shops) 
  {
    for (int i = 0; i < tileSet.length; i++) 
    {
      tileSet[i] = new questTile(monsters[i], eventbad[i], eventgood[i], eventneutral[i], shops[i]);
      while(i!=0 && tileSet[i].getType()=="shop" && tileSet[i-1].getType()=="shop")
      {
        tileSet[i] = new questTile(monsters[i], eventbad[i], eventgood[i], eventneutral[i], shops[i]);
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
    /*for (int i = 0; i < eventgood.length; i++) {
      System.out.println(eventgood[i].getInfo());*/
    }
 // }
  public static void generateEventNeutral(eventneutral[] eventneutral) 
  {
    for (int i = 0; i < eventneutral.length; i++) 
    {
      eventneutral[i] = new eventneutral();
    }
    /*for (int i = 0; i < eventneutral.length; i++) {
      System.out.println(eventneutral[i].getInfo());*/
    }
  //}
  public static void generateEventBad(eventbad[] eventbad) 
  {
    for (int i = 0; i < eventbad.length; i++) 
    {
      eventbad[i] = new eventbad();
    }
    /*for (int i = 0; i < eventbad.length; i++) {
      System.out.println(eventbad[i].getInfo());*/
    }
  //}

  public static void generateWeapons(weapon[] weapons) 
  {
    for (int i = 0; i < weapons.length; i++) 
    {
      weapons[i] = new weapon();
    }
   /* for (int i = 0; i < weapons.length; i++) {
      System.out.println(weapons[i].getInfo());*/
    }
  //}

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

  public static void playGame(questTile[] tileSet)
  {
      for (int i = 0; i < tileSet.length; i++) 
      {
          //System.out.println(tileSet[i].getInfo());

          if (tileSet[i].getType() == "encounter")
          {
            boolean encounterComplete = false;
            String species = tileSet[i].encounter.getSpecies();
            String name = tileSet[i].encounter.getName();
            int health = tileSet[i].encounter.getHealth();
            double modifier = tileSet[i].encounter.getModifier();
            double agility = tileSet[i].encounter.getAgility();
            encounterInfo = "You encounter a " + species + " named " + name + " with " + health + " health!";
            if(tileSet[i].encounter.hasWeapon())
            {
              String weaponType = tileSet[i].encounter.getWeapon().getWeaponType();
              encounterInfo += " They seem to be holding a " + weaponType + "!";
            }
            while(!encounterComplete)
            {
              encounterInfo += " What will you do?";
              Scanner cin = new Scanner(System.in);
              System.out.print(encounterInfo + "\nEnter your action: F = fight, R = run: ");
              String userChoice = cin.nextLine();
              System.out.println("Player input = " + userChoice);
              System.out.println("Player agility = " + playerCharacter.getAgility());
  
              if(userChoice.equals("R"))
              {
                double runFromBattle = getRandomIntegerBetweenRange(1, 10) * playerCharacter.getAgility();
                System.out.println("Player runFromBattle double = " + runFromBattle);
                if(runFromBattle >= 10)
                {
                  encounterInfo = "You got away!";
                  break;
                }
                else
                {
                  encounterInfo = "You failed to run away!";
                }
              }
              if(userChoice.equals("F"))
              {
                 encounterInfo = "You swing your " + playerCharacter.getWeapon().getWeaponType() + " at the " + species + "!";
                 System.out.println(encounterInfo);
                 double enemyDodge = getRandomIntegerBetweenRange(1, 10) * agility;
                 System.out.println("Enemy dodge = " + enemyDodge);
                 if(enemyDodge >= 8)
                 {
                   encounterInfo = "You miss!";
                 }
                 else
                 {
                    int damageDone = (int)(playerCharacter.getWeapon().getDamage() * playerCharacter.getModifier());
                    encounterInfo = "You hit! You do " + damageDone + " damage to " + name + "!";
                    System.out.println(encounterInfo);
                    health -= damageDone;
                    System.out.println("They have " + health + " health left!");
                    
                    if(health <= 0)
                  {
                    encounterInfo = "You defeated " + name + "!";
                    System.out.println(encounterInfo);
                    break;
                  }
                 }
              }
              double playerDodge = getRandomIntegerBetweenRange(1, 10) * playerCharacter.getAgility();
            System.out.println("Player dodge = " + playerDodge);
            if(playerDodge >= 8)
            {
              encounterInfo = "Enemy miss!";
            }
            else
            {
               int damageDone = (int)(tileSet[i].encounter.getWeapon().getDamage() * modifier);
               encounterInfo = "Enemy hit! They do " + damageDone + " damage to you!";
               int playerHealth = playerCharacter.getHealth();
               playerHealth -= damageDone;
               playerCharacter.setHealth(playerHealth); 
               System.out.println("You have " + playerHealth + " health left!");
               
               if(health <= 0)
             {
               encounterInfo = "You have been defeated!";
               System.out.println(encounterInfo);
               break;
             }
            }
            }
            
            
          }

          if (tileSet[i].getType() == "event-neutral")
          {

          }

          if (tileSet[i].getType() == "event-good")
          {
            tileSet[i].good.setVisited(true);
            String eventType = tileSet[i].good.getEvent();
            if(eventType.equals("heal"))
            {
              int selector = (int)getRandomIntegerBetweenRange(0, healEventText.length-1);
              encounterInfo = healEventText[selector];
              if(selector == 1) //for choice events, add || for new events
              {
                System.out.print(encounterInfo);
                Scanner cin = new Scanner(System.in);
                String userChoice = cin.nextLine();
                if(userChoice.equals("Y"))
                {
                  encounterInfo = "You decide to. ";
                  int amountToHeal = (int)getRandomIntegerBetweenRange(0, 15);
                  int newPlayerHealth = playerCharacter.getHealth() + amountToHeal;
                  playerCharacter.setHealth(newPlayerHealth);
                  encounterInfo += "You heal " + amountToHeal + " health! You now have " + playerCharacter.getHealth() + " health!";
                  System.out.println(encounterInfo);
                }
                if(userChoice.equals("N"))
                {
                  encounterInfo = "You decide not to. You walk away.";
                  System.out.println(encounterInfo);
                }
              }
              else
              {
                int amountToHeal = (int)getRandomIntegerBetweenRange(0, 15);
                int newPlayerHealth = playerCharacter.getHealth() + amountToHeal;
                playerCharacter.setHealth(newPlayerHealth);
                encounterInfo += "You heal " + amountToHeal + " health! You now have " + playerCharacter.getHealth() + " health!";
                System.out.println(encounterInfo);
              }

            }
            if(eventType.equals("item"))
            {
              int selector = (int)getRandomIntegerBetweenRange(0, itemEventText.length-1);
              weapon eventWeapon = weapons[i];
              int damage = (int)eventWeapon.getDamage();
              int lowerDamage = damage - (int)getRandomIntegerBetweenRange(0, 3);
              int upperDamage = damage + (int)getRandomIntegerBetweenRange(1, 3);
              encounterInfo = itemEventText[selector] + eventWeapon.getWeaponType() +". You speculate the weapon could do about " + lowerDamage + " to " + upperDamage + " damage. Do you take the " + eventWeapon.getWeaponType() + "? ";
              System.out.print(encounterInfo);
              Scanner cin = new Scanner(System.in);
              String userChoice = cin.nextLine();
              if(userChoice.equals("Y"))
              {
                encounterInfo = "You decide to take the " + eventWeapon.getWeaponType() + ".";
                if(playerCharacter.hasWeapon)
                {
                  encounterInfo += " You drop your old " + playerCharacter.getWeapon().getWeaponType() + ".";
                }
                playerCharacter.setWeapon(eventWeapon);
                System.out.println(encounterInfo);
              }
              if(userChoice.equals("N"))
              {
                encounterInfo = "You decide not to take the " + eventWeapon.getWeaponType() + ". You walk away.";
                System.out.println(encounterInfo);
              }
            }
            if(eventType.equals("powerup"))
            {
              
              
            }


          }

          if (tileSet[i].getType() == "event-bad")
          {

          }

          if (tileSet[i].getType() == "shop")
          {

          }
      }
  }

  public static void main(String[] args) 
  {
    monster[] monsters = new monster[numOfTiles];
    eventgood[] eventgood = new eventgood[numOfTiles];
    eventbad[] eventbad = new eventbad[numOfTiles];
    eventneutral[] eventneutral = new eventneutral[numOfTiles];
    shop[] shops = new shop[numOfTiles];

    createPlayer();
    generateWeapons(weapons);
    generateMonster(monsters, weapons);
    generateEventGood(eventgood);
    generateEventBad(eventbad);
    generateEventNeutral(eventneutral);
    generateShop(shops, weapons);
    generateTiles(tileSet, monsters, eventgood, eventbad, eventneutral, shops);
    playGame(tileSet);
  }
}