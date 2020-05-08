
import java.math.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class rquestMain {
  static player playerCharacter;
  static weapon eventWeapon;
  static int gold = 0;
  static int weaponChoice=4;
  static int tileMarker = 0;
  static questTile currentTile;
  static String species;
  static String name;
  static int health;
  static double modifier;
  static double agility;
  static int numOfTiles = 30;
  static weapon[] weapons = new weapon[numOfTiles];
  static String encounterInfo;
  static String[] shopEventText = { "As you are travelling, you see a small shop and decide to stop by. ",
      "A traveler walks up to you and shows you their wares. " };
  static String[] healEventText = { "You trip over a half-consumed healing potion and decide to drink it. ",
      "As you walk down the path, you notice a bush with fruit growing from it. Do you eat the fruit? " };
  static String[] damageEventText = { "You trip over a stone. ",
  "As you walk down the path, you notice a bush with fruit growing from it. Do you eat the fruit? " };
  static String[] itemEventText = {
      "You stumble over something while walking down the road. Upon further inspection, you notice it's a ",
      "You come across a dead body. You notice a weapon still in its sheath. Upon inspection, you identify it as a " };
  static String[] powerupEventText = {
      "You see a small opening near a cliff as you are walking. In order to further investigate, you quicky - yet clumsily - crawl inside. About halfway through, you scrape your arm on some stragely sharp glowing moss and decide to crawl out. As you exit the opening, you feel ",
      "You meet a traveler along the path you are walking down. They tell you they can improve a random stat for ",
      "As you walk through a rough patch of forest, you step on a crumpled up piece of paper. Do you read the paper? " };
  static String[] powerdownEventText = powerupEventText; //same as powerup text because there is a chance a "powerup" is actually a powerdown
  static String[] flavorEventText = { "You look around you and take in the scenery.",
      "You feel the breeze blow through your hair." };
  static questTile[] tileSet = new questTile[numOfTiles];
  static String[] speciesList = { "human", "orc", "elf", "gnome", "dragonborn", "dwarf" };
  static String[] monsterSpeciesList = { "goblin", "hobgoblin", "rat", "kobold", "banshee", "spider", "lizard", "troll",
      "giant", "beetle", "bandit", "dragon", "bat", "snake", "bear", "slime" };
  static String[] firstName = { "Rhaelhall", "Fipa", "Daviecrusha", "Mythicson", "Silvacackle", "Anskelisia",
      "Reyesookie", "Morganhugia", "Iflee", "Benallopa", "Silva", "Hartrositia", "Simsensteinia", "Yosaunders",
      "Benalka", "Olakelley", "Slimerice", "Burgat", "Thudguzman", "Hammasrice", "Philaf", "Harrisrek", "Rhaelrter",
      "Gagruel", "Murphire", "Mcdonahell", "Jikinirthy" };
  static String[] lastName = { "the parallel", "the juvenile", "the subdued", "the squalid", "the violent",
      "the fretful", "the powerful", "the wary", "the broad", "the ludicrous", "the dizzy", "the intelligent",
      "the grotesque", "the annoying", "the wealthy", "the puny", "the bizarre", "the learned", "the cumbersome",
      "the chilly", "the resolute", "the juvinile", "the frantic", "the industrious", "the hellish", "the puzzled" };

  public static double getRandomIntegerBetweenRange(double min, double max) {
    double x = (int) (Math.random() * ((max - min) + 1)) + min;
    return x;
  }

  public static double getRandomDoubleBetweenRange(double min, double max) {
    double x = (Math.random() * ((max - min) + 1)) + min;
    return x;
  }

  public static double round(double value, int places) {
    if (places < 0)
      throw new IllegalArgumentException();

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }

  public static void generateMonster(monster[] monsters, weapon[] weapons) {

    for (int i = 0; i < monsters.length; i++) {
      boolean hasWeapon = hasWeapon();
      monsters[i] = new monster(hasWeapon, weapons[i]);
    }
    /*
     * for (int i = 0; i < monsters.length; i++) {
     * System.out.println(monsters[i].getInfo());
     */
  }
  // }

  public static void generateShop(shop[] shops, weapon[] weapons) {

    for (int i = 0; i < shops.length; i++) {
      shops[i] = new shop(weapons[(int) getRandomIntegerBetweenRange(0, numOfTiles - 1)],
          weapons[(int) getRandomIntegerBetweenRange(0, numOfTiles - 1)],
          weapons[(int) getRandomIntegerBetweenRange(0, numOfTiles - 1)]);
    }
    /*
     * for (int i = 0; i < shops.length; i++) {
     * System.out.println(shops[i].getInfo());
     */
  }
  // }

  public static void generateTiles(questTile[] tileSet, monster[] monsters, eventgood[] eventgood, eventbad[] eventbad,
      eventneutral[] eventneutral, shop[] shops) {
    for (int i = 0; i < tileSet.length; i++) {
      tileSet[i] = new questTile(monsters[i], eventbad[i], eventgood[i], eventneutral[i], shops[i]);
      while (i != 0 && tileSet[i].getType() == "shop" && tileSet[i - 1].getType() == "shop") {
        tileSet[i] = new questTile(monsters[i], eventbad[i], eventgood[i], eventneutral[i], shops[i]);
      }
    }
    for (int i = 0; i < tileSet.length; i++) {
      System.out.println(tileSet[i].getInfo());
    }
  }

  public static void generateEventGood(eventgood[] eventgood) {
    for (int i = 0; i < eventgood.length; i++) {
      eventgood[i] = new eventgood();
    }
    /*
     * for (int i = 0; i < eventgood.length; i++) {
     * System.out.println(eventgood[i].getInfo());
     */
  }

  // }
  public static void generateEventNeutral(eventneutral[] eventneutral) {
    for (int i = 0; i < eventneutral.length; i++) {
      eventneutral[i] = new eventneutral();
    }
    /*
     * for (int i = 0; i < eventneutral.length; i++) {
     * System.out.println(eventneutral[i].getInfo());
     */
  }

  // }
  public static void generateEventBad(eventbad[] eventbad) {
    for (int i = 0; i < eventbad.length; i++) {
      eventbad[i] = new eventbad();
    }
    /*
     * for (int i = 0; i < eventbad.length; i++) {
     * System.out.println(eventbad[i].getInfo());
     */
  }
  // }

  public static void generateWeapons(weapon[] weapons) {
    for (int i = 0; i < weapons.length; i++) {
      weapons[i] = new weapon();
    }
    /*
     * for (int i = 0; i < weapons.length; i++) {
     * System.out.println(weapons[i].getInfo());
     */
  }
  // }

  public static void createPlayer() {
    playerCharacter = new player();
    System.out.println(playerCharacter.getInfo());
  }

  public static boolean hasWeapon() {
    int rand = (int) (0 + 2 * Math.random());
    if (rand == 1) {
      return true;
    } else {
      return false;
    }
  }

  public static void run(questTile currentTile)
  {
    System.out.println("----------------------------------------------------------------------------------------------");
          
            double runFromBattle = getRandomIntegerBetweenRange(1, 10) * playerCharacter.getAgility();
            System.out.println("Player runFromBattle double = " + runFromBattle);
            if (runFromBattle >= 10) {
              encounterInfo = "You got away!";
              currentTile.setDefeated(true);
            } else {
              encounterInfo = "You failed to run away!";
            }
            enemyFight(currentTile);
          
          
          

  }

  public static void enemyFight(questTile currentTile)
  {
    double playerDodge = getRandomIntegerBetweenRange(1, 10) * playerCharacter.getAgility();
          System.out.println("Player dodge = " + playerDodge);
          if (playerDodge >= 8) {
            encounterInfo = "Enemy miss!";
            System.out.println(encounterInfo);
          } else {
            int damageDone = (int) (currentTile.encounter.getWeapon().getDamage() * modifier);
            encounterInfo = "Enemy hit! They do " + damageDone + " damage to you!";
            System.out.println(encounterInfo);
            int playerHealth = playerCharacter.getHealth();
            playerHealth -= damageDone;
            playerCharacter.setHealth(playerHealth);
            if (playerCharacter.getHealth() <= 0) {
              encounterInfo = "You have been defeated!";
              System.out.println(encounterInfo);
              System.exit(0);
            }
            System.out.println("You have " + playerHealth + " health left!");
          }
  }

  public static void fight(questTile currentTile)
  {
    encounterInfo = "You swing your " + playerCharacter.getWeapon().getWeaponType() + " at the " + species
                + "!";
            System.out.println(encounterInfo);
            double enemyDodge = getRandomIntegerBetweenRange(1, 10) * agility;
            System.out.println("Enemy dodge = " + enemyDodge);
            if (enemyDodge >= 8) {
              encounterInfo = "You miss!";
              System.out.println(encounterInfo);
            } else {
              int damageDone = (int) (playerCharacter.getWeapon().getDamage() * playerCharacter.getModifier());
              encounterInfo = "You hit! You do " + damageDone + " damage to " + name + "!";
              System.out.println(encounterInfo);
              health -= damageDone;
              System.out.println("They have " + health + " health left!");

              if (health <= 0) {
                encounterInfo = "You defeated " + name + "!";
                System.out.println(encounterInfo);
               currentTile.setDefeated(true);
               //make buttons invisible here
              }
              
            }
            enemyFight(currentTile);
            

  }

  public static void tileHint (questTile nextTile)
  {
      String eventType = nextTile.neutral.getEvent();
   
      if (eventType.equals("encounter")) {
        encounterInfo = "You see some footprints in the ground leading up the path ahead. You identify them as a "
            + nextTile.encounter.getSpecies() + "'s.";
      }
      if (eventType.equals("event-neutral")) {
        encounterInfo = "You do not see anything of note up the path ahead.";
      }
      if (eventType.equals("shop")) {
        encounterInfo = "You see a shop ahead with " + nextTile.shop.numOfItems + " items.";
      }
      if (eventType.equals("event-good")) {
        encounterInfo = "There seems to be something mysterious ahead.";
      }
      if (eventType.equals("event-bad")) {
        encounterInfo = "There seems to be something mysterious ahead.";
      }
      currentTile.setDefeated(true);
      //make buttons invisible here
    

  }
  public static void heal()
  {
    encounterInfo = "You decide to. ";
              int amountToHeal = (int) getRandomIntegerBetweenRange(0, 15);
              int newPlayerHealth = playerCharacter.getHealth() + amountToHeal;
              playerCharacter.setHealth(newPlayerHealth);
              encounterInfo += "You heal " + amountToHeal + " health! You now have " + playerCharacter.getHealth()
                  + " health!";
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here

  }

  public static void healDecline()
  {
    encounterInfo = "You decide not to. You walk away.";
    System.out.println(encounterInfo);
    currentTile.setDefeated(true);
    //make buttons invisible here
  }

  public static void pickUpWeapon()
  {
    encounterInfo = "You decide to take the " + eventWeapon.getWeaponType() + ".";
            if (playerCharacter.hasWeapon = true && !playerCharacter.getWeapon().getWeaponType().equals("fists")) {
              encounterInfo += " You drop your old " + playerCharacter.getWeapon().getWeaponType() + ".";
            }
            playerCharacter.setWeapon(eventWeapon);
            System.out.println(encounterInfo);
            currentTile.setDefeated(true);
            //make buttons invisible here
  }

  public static void pickUpWeaponDecline()
  {
    encounterInfo = "You decide not to take the " + eventWeapon.getWeaponType() + ". You walk away.";
            System.out.println(encounterInfo);
          currentTile.setDefeated(true);
          //make buttons invisible here
  }

  public static void powerupSalesmanAccept()
  {
    int playerGold = playerCharacter.getMoney();
              if (playerGold - gold <= 0) {
                encounterInfo = "You do not have enough money. You exchange farewells and move on.";
                System.out.println(encounterInfo);
              } else {
                int selector = (int) getRandomIntegerBetweenRange(0, 2);
                if (selector == 0) // health
                {
                  int addHealth = (int) getRandomIntegerBetweenRange(5, 20);
                  playerCharacter.setHealth(addHealth + playerCharacter.getHealth());
                  encounterInfo = "You learn how to keep your body in shape. Your health increases by " + addHealth
                      + " points. You now have " + playerCharacter.getHealth() + " health. ";

                }
                if (selector == 1)// damage modifier
                {
                  double addModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
                  playerCharacter.setModifier(addModifier + playerCharacter.getModifier());
                  encounterInfo = "You learn more effective combat. Your damage modifier increases by " + addModifier
                      + " points. You now have a damage modifier of " + playerCharacter.getModifier() + ". ";

                }
                if (selector == 2)// agility
                {
                  double addAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
                  playerCharacter.setAgility(addAgility + playerCharacter.getAgility());
                  encounterInfo = "You learn to be lighter on your feet. Your agility score increases by " + addAgility
                      + " points. You now have an agility score of " + playerCharacter.getAgility() + ". ";

                }
                playerCharacter.setMoney(playerGold - gold);
                encounterInfo += "You have " + playerCharacter.getMoney() + " gold left.";
                System.out.println(encounterInfo);
                currentTile.setDefeated(true);
                //make buttons invisible here
              }
  }

  public static void powerupSalesmanDecline()
  {
    encounterInfo = "You decline and move on.";
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here
  }

  public static void powerupAccept()
  {
    int selector = (int) getRandomIntegerBetweenRange(0, 2);
              if (selector == 0) {
                int addHealth = (int) getRandomIntegerBetweenRange(5, 20);
                playerCharacter.setHealth(addHealth + playerCharacter.getHealth());
                encounterInfo = "Mystical power enters your veins and you immediately feel invigorated. Your health increases by "
                    + addHealth + " points. You now have " + playerCharacter.getHealth() + " health. ";

              }
              if (selector == 1) {
                double addModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
                playerCharacter.setModifier(addModifier + playerCharacter.getModifier());
                encounterInfo = "Visions of ancient combat techniques fill your mind. Your damage modifier increases by "
                    + addModifier + " points. You now have a damage modifier of " + playerCharacter.getModifier()
                    + ". ";

              }
              if (selector == 2) {
                double addAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
                playerCharacter.setAgility(addAgility + playerCharacter.getAgility());
                encounterInfo = "You begin to float and feel ligher on your feet. Your agility score increases by "
                    + addAgility + " points. You now have an agility score of " + playerCharacter.getAgility() + ". ";
              }
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here
  }

  public static void powerupDecline()
  {
    encounterInfo = "You decide not to and move on";
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here
  }

  public static void selectWeapon()
  {
    encounterInfo = "Which weapon? (Enter Number): ";
            System.out.print(encounterInfo);
            //weaponchoice == whatever is in this edittext field
            if ((weaponChoice > -1 && weaponChoice <= currentTile.shop.numOfItems)) {
              if (playerCharacter.getMoney() - currentTile.shop.sellList[weaponChoice - 1].getCost() <= 0) {
                encounterInfo = "Not Enough Cash!";
                System.out.println(encounterInfo);
              } 
              else 
              {
                playerCharacter.setMoney(playerCharacter.getMoney() - currentTile.shop.sellList[weaponChoice - 1].getCost());
                encounterInfo = "You decide to take the " + currentTile.shop.sellList[weaponChoice - 1].getWeaponType()
                    + ". You give the shopkeeper " + currentTile.shop.sellList[weaponChoice - 1].getCost()
                    + " gold. You have " + playerCharacter.getMoney() + " gold left.";
                if (playerCharacter.hasWeapon = true && !playerCharacter.getWeapon().getWeaponType().equals("fists")) {
                  encounterInfo += " You drop your old " + playerCharacter.getWeapon().getWeaponType() + ".";
                }
                encounterInfo += " You leave the shop.";
                playerCharacter.setWeapon(currentTile.shop.sellList[weaponChoice - 1]);
                System.out.println(encounterInfo);
                currentTile.setDefeated(true);
                //make buttons invisible here
              }
            }
            else 
            {
              encounterInfo = "Invalid Weapon";
              System.out.println(encounterInfo);
            }
  }

  public static void declineShop()
  {
    encounterInfo = " You leave the shop.";
    System.out.println(encounterInfo);
    currentTile.setDefeated(true);
    //make buttons invisible here
  }

  public static void damage()
  {
    encounterInfo = "You decide to. ";
              int amountToDamage = (int) getRandomIntegerBetweenRange(0, 15);
              int newPlayerHealth = playerCharacter.getHealth() - amountToDamage;
              playerCharacter.setHealth(newPlayerHealth);
              encounterInfo += "You lose " + amountToDamage + " health! You now have " + playerCharacter.getHealth()
                  + " health!";
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              checkPlayerStats();
              //make buttons invisible here
  }

  public static void declineDamage()
  {
    encounterInfo = "You decide not to. You walk away.";
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here

  }

  public static void acceptPowerdownSalesman()
  {
    int playerGold = playerCharacter.getMoney();
              if (playerGold - gold <= 0) {
                encounterInfo = "The traveler takes your gold anyways and runs away. You lose " + playerCharacter.getMoney() + " gold, and are now broke.";
                playerCharacter.setMoney(0);
                System.out.println(encounterInfo);
              } else 
              {
                encounterInfo = "The traveler takes the gold and runs away. You lose " + gold + " gold. You now have " + (playerCharacter.getMoney() - gold) + " gold.";
                playerCharacter.setMoney(playerCharacter.getMoney() - gold);
                System.out.println(encounterInfo);
              }
              currentTile.setDefeated(true);
              //make buttons invisible
  }

  public static void declinePowerdownSalesman()
  {
    encounterInfo = "You decline and move on.";
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible
  }

  public static void acceptPowerdown()
  {
    int selector = (int) getRandomIntegerBetweenRange(0, 2);
              if (selector == 0) {
                int loseHealth = (int) getRandomIntegerBetweenRange(5, 20);
                playerCharacter.setHealth(playerCharacter.getHealth() - loseHealth);
                encounterInfo = "Mystical power enters your veins, making you feel sick to your stomach. Your health decreases by "
                    + loseHealth + " points. You now have " + playerCharacter.getHealth() + " health. ";

              }
              if (selector == 1) {
                double loseModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
                playerCharacter.setModifier(playerCharacter.getModifier() - loseModifier);
                encounterInfo = "You begin to feel weaker than before. Your damage modifier decreases by "
                    + loseModifier + " points. You now have a damage modifier of " + playerCharacter.getModifier()
                    + ". ";

              }
              if (selector == 2) {
                double loseAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
                playerCharacter.setAgility(playerCharacter.getAgility() - loseAgility);
                encounterInfo = "You begin to feel sluggish. Your agility score decreases by "
                    + loseAgility + " points. You now have an agility score of " + playerCharacter.getAgility() + ". ";
              }
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              checkPlayerStats();
              //make buttons invisible
  }

  public static void declinePowerdown()
  {
    encounterInfo = "You decide not to and move on";
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible
  }

  public static void checkPlayerStats()
  {
    if (playerCharacter.getHealth() <= 0) {
      encounterInfo = "You have been defeated!";
      System.out.println(encounterInfo);
      System.exit(0);
    }
    if (playerCharacter.getModifier() <= 0) {
      System.out.println("Modifier reset to 0.3");
      playerCharacter.setModifier(.3);
    }
    if (playerCharacter.getAgility() <= 0) {
      System.out.println("Agility reset to 0.3");
      playerCharacter.setAgility(.3);
    }
  }
  

  public static void playTile (questTile[] tileSet, questTile currentTile)
  {
    if(currentTile.getDefeated())
    {
      tileMarker++;
      currentTile = tileSet[tileMarker];
    }
    if (currentTile.getType() == "encounter")  
      {
        System.out.println("----------------------------------------------------------------------------------------------");
        species = currentTile.encounter.getSpecies();
        name = currentTile.encounter.getName();
        health = currentTile.encounter.getHealth();
        modifier = currentTile.encounter.getModifier();
        agility = currentTile.encounter.getAgility();
        encounterInfo = "You encounter a " + species + " named " + name + " with " + health + " health!";
        if (currentTile.encounter.hasWeapon()) {
          String weaponType = currentTile.encounter.getWeapon().getWeaponType();
          encounterInfo += " They seem to be holding a " + weaponType + "!";
        }
        System.out.println(encounterInfo);
        //make buttons visible here
        
      }
      if (currentTile.getType() == "event-neutral") //NEUTRAL ---------------------------------------------------------------------------------------------------------------------
      {
        species = "Event";
        name = "Neutral";
        health = 0;
        modifier = 0;
        agility = 0;
        String eventType = currentTile.neutral.getEvent();
        if (eventType.equals("nextTileHint")) {
          tileHint(tileSet[tileMarker+1]);
        }
        if (eventType.equals("flavor")) {
          int selector = (int) getRandomIntegerBetweenRange(0, flavorEventText.length - 1);
          encounterInfo = flavorEventText[selector];
          currentTile.setDefeated(true);
        }
       
        System.out.println(encounterInfo);

      }
      if(currentTile.getType() == "event-good")
      {
        species = "Event";
        name = "Good";
        health = 0;
        modifier = 0;
        agility = 0;
        String eventType = currentTile.good.getEvent();
        if (eventType.equals("heal")) 
        {
          //make buttons visible here
        }
        if (eventType.equals("item")) {
          int selector = (int) getRandomIntegerBetweenRange(0, itemEventText.length - 1);
          eventWeapon = weapons[tileMarker+1];
          int damage = (int) eventWeapon.getDamage();
          int lowerDamage = damage - (int) getRandomIntegerBetweenRange(0, 3);
          int upperDamage = damage + (int) getRandomIntegerBetweenRange(1, 3);
          encounterInfo = itemEventText[selector] + eventWeapon.getWeaponType()
              + ". You speculate the weapon could do about " + lowerDamage + " to " + upperDamage
              + " damage. Do you take the " + eventWeapon.getWeaponType() + "? ";
          System.out.print(encounterInfo);
          //make buttons visible here
            
        }
        if (eventType.equals("powerup")) {
          int selector = (int) getRandomIntegerBetweenRange(0, powerupEventText.length - 1);
          encounterInfo = powerupEventText[selector];
          if (selector == 1)// this if is for bought powerups
          {
            gold = (int) getRandomIntegerBetweenRange(5, 15);
            encounterInfo += gold + " gold. Do you accept? ";
            System.out.print(encounterInfo);
            //make buttons visible here
          }
          if (selector == 2)// this if is for yes/no
          {
            System.out.print(encounterInfo);
            
            //make buttons visible here

          } 
          else // this is for static powerups
          {
            selector = (int) getRandomIntegerBetweenRange(0, 2);
            if (selector == 0) {
              int addHealth = (int) getRandomIntegerBetweenRange(5, 20);
              playerCharacter.setHealth(addHealth + playerCharacter.getHealth());
              encounterInfo = "You feel invigorated. Your health increases by " + addHealth + " points. You now have "
                  + playerCharacter.getHealth() + " health. ";

            }
            if (selector == 1) {
              double addModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
              playerCharacter.setModifier(addModifier + playerCharacter.getModifier());
              encounterInfo = "Your sword-arm feels more nimble. Your damage modifier increases by " + addModifier
                  + " points. You now have a damage modifier of " + playerCharacter.getModifier() + ". ";

            }
            if (selector == 2) {
              double addAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
              playerCharacter.setAgility(addAgility + playerCharacter.getAgility());
              encounterInfo = "You notice your steps are quicker. Your agility score increases by " + addAgility
                  + " points. You now have an agility score of " + playerCharacter.getAgility() + ". ";
            }
            System.out.println(encounterInfo);
            currentTile.setDefeated(true);
          }
        }
      }
      if (currentTile.getType() == "shop") //SHOP ----------------------------------------------------------------------------------------------------------------------------
      {
        species = "Event";
        name = "Shop";
        health = 0;
        modifier = 0;
        agility = 0;
        int selector = (int) getRandomIntegerBetweenRange(0, shopEventText.length - 1);
        encounterInfo = shopEventText[selector] + "The shop is currently selling " + currentTile.shop.numOfItems
            + " items. You have " + playerCharacter.getMoney() + " gold to spend.";
        System.out.println(encounterInfo);
        for (int j = 0; j <= currentTile.shop.numOfItems - 1; j++) {
          encounterInfo = "Item " + (j + 1) + " - Weapon Type: " + currentTile.shop.sellList[j].getWeaponType()
              + " | Weapon Damage: " + currentTile.shop.sellList[j].getDamage() + " | Size: "
              + currentTile.shop.sellList[j].getSize() + " | Cost: " + currentTile.shop.sellList[j].getCost();
          System.out.println(encounterInfo);
        }
        
          
          encounterInfo = "Would you like to buy a weapon? ";
          System.out.print(encounterInfo);
        
        
      }
      if (currentTile.getType() == "event-bad") //BAD ----------------------------------------------------------------------------------------------------------------------------
      {
        species = "Event";
        name = "Shop";
        health = 0;
        modifier = 0;
        agility = 0;
        String eventType = currentTile.bad.getEvent();
        if (eventType.equals("damage")) 
        {
          int selector = (int) getRandomIntegerBetweenRange(0, damageEventText.length - 1);
          encounterInfo = damageEventText[selector];
          if (selector == 1) // for choice events, add || for new events
          {
            System.out.print(encounterInfo);
            
           //make buttons visible here
          } 
          else //static damage 
          {
            int amountToDamage = (int) getRandomIntegerBetweenRange(1, 15);
            int newPlayerHealth = playerCharacter.getHealth() - amountToDamage;
            playerCharacter.setHealth(newPlayerHealth);
            encounterInfo += "You lose " + amountToDamage + " health! You now have " + playerCharacter.getHealth()
                + " health!";
            System.out.println(encounterInfo);
            currentTile.setDefeated(true);
          }
        }

        if (eventType.equals("powerdown")) 
        {
          int selector = (int) getRandomIntegerBetweenRange(0, powerdownEventText.length - 1);
          
          if (selector == 1)// this if is for bought powerups
          {
            int gold = (int) getRandomIntegerBetweenRange(5, 15);
            encounterInfo = powerdownEventText[selector];
            encounterInfo += gold + " gold. Do you accept? ";
            System.out.print(encounterInfo);
            //make buttons visible
            
          }
          if (selector == 2)// this if is for yes/no
          {
            System.out.print(encounterInfo);
           //make buttons visible
          } 
          else // this is for static powerdowns
          {
            selector = (int) getRandomIntegerBetweenRange(0, 2);
            if (selector == 0) {
              int loseHealth = (int) getRandomIntegerBetweenRange(5, 20);
              playerCharacter.setHealth(playerCharacter.getHealth() - loseHealth);
              encounterInfo += " You feel sick. Your health decreases by " + loseHealth + " points. You now have "
                  + playerCharacter.getHealth() + " health. ";

            }
            if (selector == 1) {
              double loseModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
              playerCharacter.setModifier(playerCharacter.getModifier() - loseModifier);
              encounterInfo += " Your sword-arm feels sore. Your damage modifier decreases by " + loseModifier
                  + " points. You now have a damage modifier of " + playerCharacter.getModifier() + ". ";

            }
            if (selector == 2) {
              double loseAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
              playerCharacter.setAgility(playerCharacter.getAgility() - loseAgility);
              encounterInfo += " You begin to feel heavier. Your agility score decreases by " + loseAgility
                  + " points. You now have an agility score of " + playerCharacter.getAgility() + ". ";
            }
            System.out.println(encounterInfo);
            currentTile.setDefeated(true);
            checkPlayerStats();
          }
          
        }
      }

  }


  public static void main(String[] args) throws InterruptedException
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
    currentTile = tileSet[tileMarker];
   
    
  }
}
