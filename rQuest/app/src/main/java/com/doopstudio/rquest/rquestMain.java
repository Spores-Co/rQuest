package com.doopstudio.rquest;

import java.math.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class rquestMain {
  static player playerCharacter;
  static int skillLength;
  static int enemyMaxHealth;
  static weapon eventWeapon;
  static int gold = 0;
  static int weaponChoice=1;
  static int tileMarker = 0;
  static questTile currentTile;
  static String species = "none";
  static String name;
  static int health;
  static double modifier;
  static double agility;
  static int numOfTiles = 30;
  static weapon[] weapons = new weapon[numOfTiles];
  static String encounterInfo = "";
  static String newEncounterInfo = "";
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
      "You see a small opening near a cliff as you are walking. In order to further investigate, you quickly - yet clumsily - crawl inside. About halfway through, you scrape your arm on some strangely sharp glowing moss and decide to crawl out. As you exit the opening, you feel ",
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

  public static void createPlayer(String race) {
    playerCharacter = new player(species, skillLength);
    //System.out.println(playerCharacter.getInfo());
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
                newEncounterInfo = "\nYou got away!\n";
              encounterInfo += newEncounterInfo;
              currentTile.setDefeated(true);
            } else {
                newEncounterInfo = "\nYou failed to run away!\n";
              encounterInfo += newEncounterInfo;
            }
            if(!currentTile.getDefeated())
            {
                enemyFight(currentTile);
            }
  }

  public static void enemyFight(questTile currentTile)
  {
    double playerDodge = getRandomIntegerBetweenRange(1, 10) * playerCharacter.getAgility();
          System.out.println("Player dodge = " + playerDodge);
          if (playerDodge >= 8) {
              newEncounterInfo = "\nEnemy miss!\n";
            encounterInfo += newEncounterInfo;
            System.out.println(encounterInfo);
          } else {
            int damageDone = (int) (currentTile.encounter.getWeapon().getDamage() * modifier);
            newEncounterInfo = "\nEnemy hit! They do " + damageDone + " damage to you!\n";
            encounterInfo += newEncounterInfo;
            System.out.println(encounterInfo);
            int playerHealth = playerCharacter.getHealth();
            playerHealth -= damageDone;
            playerCharacter.setHealth(playerHealth);
            if (playerCharacter.getHealth() <= 0) {
                newEncounterInfo = "\nYou have been defeated!\n";
              encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
              System.exit(0);
            }
            System.out.println("\nYou have " + playerHealth + " health left!\n");
          }
  }

  public static void fight(questTile currentTile)
  {
      newEncounterInfo = "\nYou swing your " + playerCharacter.getWeapon().getWeaponType() + " at the " + species
              + "!\n";
    encounterInfo += newEncounterInfo;
            System.out.println(encounterInfo);
            double enemyDodge = getRandomIntegerBetweenRange(1, 10) * agility;
            System.out.println("Enemy dodge = " + enemyDodge);
            if (enemyDodge >= 8) {
                newEncounterInfo = "\nYou miss!\n";
              encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
            }
            else
                {
              int damageDone = (int) (playerCharacter.getWeapon().getDamage() * playerCharacter.getModifier());
              newEncounterInfo = "\nYou hit! You do " + damageDone + " damage to " + name + "!\n";
              encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
              health -= damageDone;
              currentTile.encounter.setHealth(health);
              System.out.println("They have " + health + " health left!");

              if (health <= 0) {
                  newEncounterInfo = "\nYou defeated " + name + "!\n";
                encounterInfo += newEncounterInfo;
                System.out.println(encounterInfo);
               currentTile.setDefeated(true);
               //make buttons invisible here
              }
              
            }
            if(!currentTile.getDefeated())
            {
                enemyFight(currentTile);
            }



  }

  public static void tileHint (questTile nextTile)
  {

      //make buttons invisible here
    

  }
  public static void heal()
  {
      newEncounterInfo = "\nYou decide to.\n";
    encounterInfo += newEncounterInfo;
              int amountToHeal = (int) getRandomIntegerBetweenRange(0, 15);
              int newPlayerHealth = playerCharacter.getHealth() + amountToHeal;
              playerCharacter.setHealth(newPlayerHealth);
              newEncounterInfo = "\nYou heal " + amountToHeal + " health! \nYou now have " + playerCharacter.getHealth()
                      + " health!\n";
              encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here

  }

  public static void healDecline()
  {
      newEncounterInfo = "\nYou decide not to. You walk away.\n";
    encounterInfo += newEncounterInfo;
    System.out.println(encounterInfo);
    currentTile.setDefeated(true);
    //make buttons invisible here
  }

  public static void pickUpWeapon()
  {
      newEncounterInfo = "\nYou decide to take the " + eventWeapon.getWeaponType() + ".\n";
    encounterInfo += newEncounterInfo;
            if (playerCharacter.hasWeapon = true && !playerCharacter.getWeapon().getWeaponType().equals("fists")) {
              newEncounterInfo = "\nYou drop your old " + playerCharacter.getWeapon().getWeaponType() + ".\n";
              encounterInfo += newEncounterInfo;
            }
            playerCharacter.setWeapon(eventWeapon);
            System.out.println(encounterInfo);
            currentTile.setDefeated(true);
            //make buttons invisible here

  }

  public static void pickUpWeaponDecline()
  {
      newEncounterInfo = "\nYou decide not to take the " + eventWeapon.getWeaponType() + ". You walk away.\n";
    encounterInfo += newEncounterInfo;
            System.out.println(encounterInfo);
          currentTile.setDefeated(true);
          //make buttons invisible here
  }

  public static void powerupSalesmanAccept()
  {
    int playerGold = playerCharacter.getMoney();
              if (playerGold - gold <= 0) {
                  newEncounterInfo = "\nYou do not have enough money. You exchange farewells and move on.\n";
                encounterInfo += newEncounterInfo;
                System.out.println(encounterInfo);
              } else {
                int selector = (int) getRandomIntegerBetweenRange(0, 2);
                if (selector == 0) // health
                {
                  int addHealth = (int) getRandomIntegerBetweenRange(5, 20);
                  playerCharacter.setHealth(addHealth + playerCharacter.getHealth());
                  newEncounterInfo = "\nYou learn how to keep your body in shape. \nYour health increases by " + addHealth
                          + " points. \nYou now have " + playerCharacter.getHealth() + " health. \n";
                  encounterInfo += newEncounterInfo;

                }
                if (selector == 1)// damage modifier
                {
                  double addModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
                  playerCharacter.setModifier(addModifier + playerCharacter.getModifier());
                  newEncounterInfo = "\nYou learn more effective combat.\nYour damage modifier increases by " + addModifier
                          + " points.\nYou now have a damage modifier of " + playerCharacter.getModifier() + ".\n";
                  encounterInfo += newEncounterInfo;

                }
                if (selector == 2)// agility
                {
                  double addAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
                  playerCharacter.setAgility(addAgility + playerCharacter.getAgility());
                  newEncounterInfo = "\nYou learn to be lighter on your feet.\nYour agility score increases by " + addAgility
                          + " points.\nYou now have an agility score of" + playerCharacter.getAgility() + "\n";
                  encounterInfo += newEncounterInfo;

                }
                playerCharacter.setMoney(playerGold - gold);
                newEncounterInfo = "\nYou have " + playerCharacter.getMoney() + " gold left.\n";
                encounterInfo += newEncounterInfo;
                System.out.println(encounterInfo);
                currentTile.setDefeated(true);
                //make buttons invisible here
              }
  }

  public static void powerupSalesmanDecline()
  {
      newEncounterInfo = "\nYou decline and move on.\n";
    encounterInfo += newEncounterInfo;
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
                newEncounterInfo = "\nMystical power enters your veins and you immediately feel invigorated.\nYour health increases by "
                        + addHealth + " points.\n You now have " + playerCharacter.getHealth() + " health.\n";
                encounterInfo += newEncounterInfo;

              }
              if (selector == 1) {
                double addModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
                playerCharacter.setModifier(addModifier + playerCharacter.getModifier());
                newEncounterInfo = "\nVisions of ancient combat techniques fill your mind.\nYour damage modifier increases by "
                        + addModifier + " points.\nYou now have a damage modifier of " + playerCharacter.getModifier()
                        + ".\n";
                encounterInfo += newEncounterInfo;

              }
              if (selector == 2) {
                double addAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
                playerCharacter.setAgility(addAgility + playerCharacter.getAgility());
                newEncounterInfo = "\nYou begin to float and feel lighter on your feet.\nYour agility score increases by "
                        + addAgility + " points.\nYou now have an agility score of " + playerCharacter.getAgility() + ".\n";
                encounterInfo += newEncounterInfo;
              }
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here
  }

  public static void powerupDecline()
  {
      newEncounterInfo = "\nYou decide not to and move on\n";
    encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here
  }

  public static void selectWeapon(questTile currentTile)
  {
      newEncounterInfo = "\nWhich weapon? (Enter Number): \n";
    encounterInfo += newEncounterInfo;
            System.out.print(encounterInfo);
            //weaponchoice == whatever is in this edittext field
            if ((weaponChoice > -1 && weaponChoice <= currentTile.shop.numOfItems)) {
              if (playerCharacter.getMoney() - currentTile.shop.sellList[weaponChoice - 1].getCost() <= 0) {
                  newEncounterInfo = "\nNot Enough Cash!\n";
                encounterInfo += newEncounterInfo;
                System.out.println(encounterInfo);
              } 
              else 
              {
                playerCharacter.setMoney(playerCharacter.getMoney() - currentTile.shop.sellList[weaponChoice - 1].getCost());
                newEncounterInfo = "\nYou decide to take the " + currentTile.shop.sellList[weaponChoice - 1].getWeaponType()
                        + ".\nYou give the shopkeeper " + currentTile.shop.sellList[weaponChoice - 1].getCost()
                        + " gold.\nYou have " + playerCharacter.getMoney() + " gold left.\n";
                encounterInfo += newEncounterInfo;
                if (playerCharacter.hasWeapon = true && !playerCharacter.getWeapon().getWeaponType().equals("fists")) {
                    newEncounterInfo = "You drop your old " + playerCharacter.getWeapon().getWeaponType() + ".\n";
                  encounterInfo += newEncounterInfo;
                }
                newEncounterInfo = "You leave the shop.\n";
                encounterInfo += newEncounterInfo;
                playerCharacter.setWeapon(currentTile.shop.sellList[weaponChoice - 1]);
                System.out.println(encounterInfo);
                currentTile.setDefeated(true);
                //make buttons invisible here
              }
            }
            else 
            {
                newEncounterInfo = "\nInvalid Weapon\n";
              encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
            }
  }

  public static void declineShop()
  {
      newEncounterInfo = "\nYou leave the shop.\n";
    encounterInfo += newEncounterInfo;
    System.out.println(encounterInfo);
    currentTile.setDefeated(true);
    //make buttons invisible here
  }

  public static void damage()
  {
      newEncounterInfo = "\nYou decide to. ";
    encounterInfo += newEncounterInfo;
              int amountToDamage = (int) getRandomIntegerBetweenRange(0, 15);
              int newPlayerHealth = playerCharacter.getHealth() - amountToDamage;
              playerCharacter.setHealth(newPlayerHealth);
              newEncounterInfo = "\nYou lose " + amountToDamage + " health!\nYou now have " + playerCharacter.getHealth()
                      + " health!\n";
              encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              checkPlayerStats();
              //make buttons invisible here
  }

  public static void declineDamage()
  {
      newEncounterInfo = "\nYou decide not to. You walk away.\n";
    encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible here

  }

  public static void acceptPowerdownSalesman(int gold)
  {
    int playerGold = playerCharacter.getMoney();
              if (playerGold - gold <= 0) {
                  newEncounterInfo = "\nThe traveler takes your gold anyways and runs away.\nYou lose " + playerCharacter.getMoney() + " gold, and are now broke.\n";
                encounterInfo += newEncounterInfo;
                playerCharacter.setMoney(0);
                System.out.println(encounterInfo);
              } else 
              {
                  newEncounterInfo = "\nThe traveler takes the gold and runs away.\nYou lose " + gold + " gold.\nYou now have " + (playerCharacter.getMoney() - gold) + " gold.\n";
                encounterInfo += newEncounterInfo;
                playerCharacter.setMoney(playerCharacter.getMoney() - gold);
                System.out.println(encounterInfo);
              }
              currentTile.setDefeated(true);
              //make buttons invisible
  }

  public static void declinePowerdownSalesman()
  {
      newEncounterInfo = "\nYou decline and move on.\n";
    encounterInfo += newEncounterInfo;
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
                newEncounterInfo = "\nMystical power enters your veins, making you feel sick to your stomach.\nYour health decreases by "
                        + loseHealth + " points.\nYou now have " + playerCharacter.getHealth() + " health.\n";
                encounterInfo += newEncounterInfo;

              }
              if (selector == 1) {
                double loseModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
                playerCharacter.setModifier(playerCharacter.getModifier() - loseModifier);
                newEncounterInfo = "\nYou begin to feel weaker than before.\nYour damage modifier decreases by "
                        + loseModifier + " points.\nYou now have a damage modifier of " + playerCharacter.getModifier()
                        + ".\n";
                encounterInfo += newEncounterInfo;

              }
              if (selector == 2) {
                double loseAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
                playerCharacter.setAgility(playerCharacter.getAgility() - loseAgility);
                newEncounterInfo = "\nYou begin to feel sluggish.\nYour agility score decreases by "
                        + loseAgility + " points.\nYou now have an agility score of " + playerCharacter.getAgility() + ".\n";
                encounterInfo += newEncounterInfo;
              }
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              checkPlayerStats();
              //make buttons invisible
  }

  public static void declinePowerdown()
  {
      newEncounterInfo = "\nYou decide not to and move on\n";
    encounterInfo += newEncounterInfo;
              System.out.println(encounterInfo);
              currentTile.setDefeated(true);
              //make buttons invisible
  }

  public static void checkPlayerStats()
  {
    if (playerCharacter.getHealth() <= 0) {
        newEncounterInfo = "\nYou have been defeated!\n";
      encounterInfo += newEncounterInfo;
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
  

  public static int playTile ()
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
        enemyMaxHealth = currentTile.encounter.getMaxHealth();
        newEncounterInfo = "\nYou encounter a " + species + " named " + name + " with " + health + " health!\n";
        encounterInfo += newEncounterInfo;
        if (currentTile.encounter.hasWeapon()) {
          String weaponType = currentTile.encounter.getWeapon().getWeaponType();
          newEncounterInfo = "They seem to be holding a " + weaponType + "!\n";
          encounterInfo += newEncounterInfo;
        }
        System.out.println(encounterInfo);
        //make buttons visible here
        return 9; //4 is monster encounter
      }
      if (currentTile.getType() == "event-neutral") //NEUTRAL ---------------------------------------------------------------------------------------------------------------------
      {
        species = "Event";
        name = "Neutral";
        health = 0;
        modifier = 0;
        agility = 0;
        enemyMaxHealth = 0;
        String eventType = currentTile.neutral.getEvent();
        if (eventType.equals("nextTileHint")) {
            eventType = tileSet[tileMarker+1].getType();

            if (eventType.equals("encounter")) {
                newEncounterInfo = "\nYou see some footprints in the ground leading up the path ahead.\nYou identify them as a "
                        + tileSet[tileMarker+1].encounter.getSpecies() + "'s.\n";
                encounterInfo += newEncounterInfo;
            }
            if (eventType.equals("event-neutral")) {
                newEncounterInfo = "\nYou do not see anything of note up the path ahead.\n";
                encounterInfo += newEncounterInfo;
            }
            if (eventType.equals("shop")) {
                newEncounterInfo = "\nYou see a shop ahead with " + tileSet[tileMarker+1].shop.numOfItems + " items.\n";
                encounterInfo += newEncounterInfo;
            }
            if (eventType.equals("event-good")) {
                newEncounterInfo = "\nThere seems to be something mysterious ahead.\n";
                encounterInfo += newEncounterInfo;
            }
            if (eventType.equals("event-bad")) {
                newEncounterInfo = "\nThere seems to be something mysterious ahead.\n";
                encounterInfo += newEncounterInfo;
            }
            currentTile.setDefeated(true);;
        }
        if (eventType.equals("flavor")) {
          int selector = (int) getRandomIntegerBetweenRange(0, flavorEventText.length - 1);
          newEncounterInfo = "\n" + flavorEventText[selector] + "\n";
          encounterInfo += newEncounterInfo;
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
        enemyMaxHealth = 0;
        String eventType = currentTile.good.getEvent();
        if (eventType.equals("heal")) 
        {
            int selector = (int) getRandomIntegerBetweenRange(0, damageEventText.length - 1);
            newEncounterInfo = "\n" + healEventText[selector];
            encounterInfo += newEncounterInfo;

            return 8;
        }
        if (eventType.equals("item")) {
          int selector = (int) getRandomIntegerBetweenRange(0, itemEventText.length - 1);
          eventWeapon = weapons[tileMarker+1];
          int damage = (int) eventWeapon.getDamage();
          int lowerDamage = damage - (int) getRandomIntegerBetweenRange(0, 3);
          int upperDamage = damage + (int) getRandomIntegerBetweenRange(1, 3);
          newEncounterInfo = "\n" + itemEventText[selector] + eventWeapon.getWeaponType()
                  + ".\nYou speculate the weapon could do about " + lowerDamage + " to " + upperDamage
                  + " damage.\nDo you take the " + eventWeapon.getWeaponType() + "?\n";
          encounterInfo += newEncounterInfo;
          System.out.print(encounterInfo);
          //make buttons visible here
            return 1;
            
        }
        if (eventType.equals("powerup")) {
            int selector = (int) getRandomIntegerBetweenRange(0, powerupEventText.length - 1);
            newEncounterInfo = "\n" + powerupEventText[selector];
            encounterInfo += newEncounterInfo;
            if (selector == 1)// this if is for bought powerups
            {
                gold = (int) getRandomIntegerBetweenRange(5, 15);
                newEncounterInfo = gold + " gold.\nDo you accept?\n";
                encounterInfo += newEncounterInfo;
                System.out.print(encounterInfo);
                //make buttons visible here
                return 2;
            }
            if (selector == 2)// this if is for yes/no
            {
                System.out.print(encounterInfo);

                //make buttons visible here
                return 3;

            } else // this is for static powerups
            {
                selector = (int) getRandomIntegerBetweenRange(0, 2);
                if (selector == 0) {
                    int addHealth = (int) getRandomIntegerBetweenRange(5, 20);
                    playerCharacter.setHealth(addHealth + playerCharacter.getHealth());
                    newEncounterInfo = "\nYou feel invigorated.\nYour health increases by " + addHealth + " points.\nYou now have "
                            + playerCharacter.getHealth() + " health.\n";
                    encounterInfo += newEncounterInfo;

                }
                if (selector == 1) {
                    double addModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
                    playerCharacter.setModifier(addModifier + playerCharacter.getModifier());
                    newEncounterInfo = "\nYour sword-arm feels more nimble.\nYour damage modifier increases by " + addModifier
                            + " points.\nYou now have a damage modifier of " + playerCharacter.getModifier() + ".\n";
                    encounterInfo += newEncounterInfo;

                }
                if (selector == 2) {
                    double addAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
                    playerCharacter.setAgility(addAgility + playerCharacter.getAgility());
                    newEncounterInfo = "\nYou notice your steps are quicker.\nYour agility score increases by " + addAgility
                            + " points.\nYou now have an agility score of " + playerCharacter.getAgility() + ".\n";
                    encounterInfo += newEncounterInfo;
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
        enemyMaxHealth = 0;
        int selector = (int) getRandomIntegerBetweenRange(0, shopEventText.length - 1);
        newEncounterInfo = "\n" + shopEventText[selector] + "\nThe shop is currently selling " + currentTile.shop.numOfItems
                + " items.\nYou have " + playerCharacter.getMoney() + " gold to spend.\n";
        encounterInfo += newEncounterInfo;
        System.out.println(encounterInfo);
        for (int j = 0; j <= currentTile.shop.numOfItems - 1; j++) {
          newEncounterInfo += "\nItem " + (j + 1) + " - Weapon Type: " + currentTile.shop.sellList[j].getWeaponType()
              + " | \nWeapon Damage: " + currentTile.shop.sellList[j].getDamage() + " | \nSize: "
              + currentTile.shop.sellList[j].getSize() + " | \nCost: " + currentTile.shop.sellList[j].getCost() + "\n";
          System.out.println(encounterInfo);
        }
        encounterInfo += newEncounterInfo;
        
          newEncounterInfo = "\nWould you like to buy a weapon?\n";
          encounterInfo += newEncounterInfo;
          System.out.print(encounterInfo);
          return 4;
        
      }
      if (currentTile.getType() == "event-bad") //BAD ----------------------------------------------------------------------------------------------------------------------------
      {
        species = "Event";
        name = "Shop";
        health = 0;
        modifier = 0;
        agility = 0;
        enemyMaxHealth = 0;
        String eventType = currentTile.bad.getEvent();
        if (eventType.equals("damage")) 
        {
          int selector = (int) getRandomIntegerBetweenRange(0, damageEventText.length - 1);
          newEncounterInfo = "\n" + damageEventText[selector];
          encounterInfo += newEncounterInfo;
          if (selector == 1) // for choice events, add || for new events
          {
            System.out.print(encounterInfo);
            
           //make buttons visible here
              return 5;
          } 
          else //static damage
          {
            int amountToDamage = (int) getRandomIntegerBetweenRange(1, 15);
            int newPlayerHealth = playerCharacter.getHealth() - amountToDamage;
            playerCharacter.setHealth(newPlayerHealth);
            newEncounterInfo = "\nYou lose " + amountToDamage + " health!\nYou now have " + playerCharacter.getHealth()
                    + " health!\n";
            encounterInfo += newEncounterInfo;
            System.out.println(encounterInfo);
            currentTile.setDefeated(true);
          }
        }

        if (eventType.equals("powerdown")) 
        {
          int selector = (int) getRandomIntegerBetweenRange(0, powerdownEventText.length - 1);
          
          if (selector == 1)// this if is for bought powerups
          {
            gold = (int) getRandomIntegerBetweenRange(5, 15);
            newEncounterInfo = "\n" + powerdownEventText[selector] + gold + " gold.\nDo you accept?\n";
            encounterInfo += newEncounterInfo;
            System.out.print(encounterInfo);
            //make buttons visible
            return 6;
          }
          if (selector == 2)// this if is for yes/no
          {

              newEncounterInfo = "\n" + powerdownEventText[selector];
              encounterInfo += newEncounterInfo;
            System.out.print(encounterInfo);
           //make buttons visible
              return 7;
          } 
          else // this is for static powerdowns
          {
            selector = (int) getRandomIntegerBetweenRange(0, 2);
            if (selector == 0) {
              int loseHealth = (int) getRandomIntegerBetweenRange(5, 20);
              playerCharacter.setHealth(playerCharacter.getHealth() - loseHealth);
              newEncounterInfo = "\nYou feel sick.\nYour health decreases by " + loseHealth + " points.\nYou now have "
                      + playerCharacter.getHealth() + " health.\n";
              encounterInfo += newEncounterInfo;

            }
            if (selector == 1) {
              double loseModifier = round(getRandomDoubleBetweenRange(.2, .7), 2);
              playerCharacter.setModifier(playerCharacter.getModifier() - loseModifier);
              newEncounterInfo = "\nYour sword-arm feels sore.\nYour damage modifier decreases by " + loseModifier
                      + " points.\nYou now have a damage modifier of " + playerCharacter.getModifier() + ".\n";
              encounterInfo += newEncounterInfo;

            }
            if (selector == 2) {
              double loseAgility = round(getRandomDoubleBetweenRange(.2, .5), 2);
              playerCharacter.setAgility(playerCharacter.getAgility() - loseAgility);
              newEncounterInfo = "\nYou begin to feel heavier.\nYour agility score decreases by " + loseAgility
                      + " points.\nYou now have an agility score of " + playerCharacter.getAgility() + ".\n";
              encounterInfo += newEncounterInfo;
            }
            System.out.println(encounterInfo);
            currentTile.setDefeated(true);
            checkPlayerStats();
          }

        }
      }
      return 0;
      //0 means error

  }


  public static void rQuest()
  { 
    monster[] monsters = new monster[numOfTiles];
    eventgood[] eventgood = new eventgood[numOfTiles];
    eventbad[] eventbad = new eventbad[numOfTiles];
    eventneutral[] eventneutral = new eventneutral[numOfTiles];
    shop[] shops = new shop[numOfTiles];

    //createPlayer();
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
