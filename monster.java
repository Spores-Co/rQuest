
public class monster {

    String name, species;
    int health;
    double modifier, agility;
    boolean hasWeapon;
    int fnameLength = rquestMain.firstName.length;
    int lnameLength = rquestMain.lastName.length;
    int monsterSpeciesLength = rquestMain.monsterSpeciesList.length;
    boolean visited = false;
    weapon currentWeapon;

    public monster(boolean carryingWeapon, weapon weapon) 
    {
        hasWeapon = false;
        name = rquestMain.firstName[(int) (0 + fnameLength * Math.random())] + " " + rquestMain.lastName[(int) (0 + lnameLength * Math.random())];
        species = rquestMain.monsterSpeciesList[(int) (0 + monsterSpeciesLength * Math.random())];

        if (species == "goblin")
        {
            health = (int) (7 + (10 * Math.random()));
            modifier = .5;
            hasWeapon = carryingWeapon;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
            agility = .75;
        }
        if (species == "hobgoblin")
        {
            health = (int) (10 + (13 * Math.random()));
            modifier = .66;
            hasWeapon = carryingWeapon;
            agility = .7;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "rat")
        {
            health = (int) (3 + (7 * Math.random()));
            modifier = .33;
            agility = 2;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "kobold")
        {
            health = (int) (8 + (11 * Math.random()));
            modifier = .75;
            hasWeapon = carryingWeapon;
            agility = .5;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "banshee")
        {
            health = (int) (5 + (8 * Math.random()));
            modifier = .8;
            agility = 1.75;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "spider")
        {
            health = (int) (5 + (7 * Math.random()));
            modifier = .8;
            agility = 2;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "lizard")
        {
            health = (int) (5 + (10 * Math.random()));
            modifier = .50;
            agility = 1;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "troll")
        {
            health = (int) (15 + (20 * Math.random()));
            modifier = 1.15;
            hasWeapon = carryingWeapon;
            agility = .75;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "giant")
        {
            health = (int) (20 + (25 * Math.random()));
            modifier = 2.50;
            agility = .5;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "beetle")
        {
            health = (int) (4 + (7 * Math.random()));
            modifier = .50;
            agility = 1.5;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "bandit")
        {
            health = (int) (7 + (12 * Math.random()));
            modifier = 1.00;
            hasWeapon = carryingWeapon;
            agility = 1.5;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "dragon")
        {
            health = (int) (20 + (30 * Math.random()));
            modifier = 3.00;
            agility = 1;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "bat")
        {
            health = (int) (2 + (4 * Math.random()));
            modifier = .15;
            agility = 3;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "snake")
        {
            health = (int) (5 + (6 * Math.random()));
            modifier = .50;
            agility = 2;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "bear")
        {
            health = (int) (13 + (16 * Math.random()));
            modifier = 2.00;
            agility = .5;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if (species == "slime")
        {
            health = (int) (1 + (3 * Math.random()));
            modifier = .20;
            agility = 1;
            if(!hasWeapon){
                currentWeapon = new weapon();
                currentWeapon.setWeaponType("fists");
                currentWeapon.setDamage(rquestMain.getRandomIntegerBetweenRange(3, 5));
                currentWeapon.setSize("medium");
                currentWeapon.setCost(0);
            }
        }
        if(hasWeapon)
        {
            currentWeapon = weapon;
        }
    }

    public String getName() {
        return name;
    };

    public boolean hasWeapon() {
        return hasWeapon;
    };

    public String getSpecies() {
        return species;
    };

    public weapon getWeapon() {
        return currentWeapon;
    };

    public int getHealth() {
        return health;
    };

    public double getModifier() {
        return modifier;
    };

    public double getAgility() {
        return agility;
    };

    public int setAgility(int newAgility) {
        health = newAgility;
        return newAgility;
    };

    public int setHealth(int newHealth) {
        health = newHealth;
        return newHealth;
    };

    public double setModifier(double newModifier) {
        modifier = newModifier;
        return newModifier;
    };

    public String setName(String newName) {
        name = newName;
        return newName;
    };
    public String setSpecies(String newSpecies) {
        species = newSpecies;
        return newSpecies;
    };

    public boolean setVisited(boolean newVisited)
    {
        visited = newVisited;
        return visited;
    }

    public boolean getVisited()
    {
        return visited;
    }

    public String getInfo() 
    {
        if(hasWeapon)
        {
            return "This is a "+ species + " named " + name + " with " + health + " hitpoints, " + agility + " agility, and a damage modifier of " + modifier + ". Has weapon: " + currentWeapon.getWeaponType();
        }
        return "This is a "+ species + " named " + name + " with " + health + " hitpoints, " + agility + " agility, and a damage modifier of " + modifier + ".";
    }
}
