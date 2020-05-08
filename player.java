public class player {
    String name, species;
    int health, money;
    double modifier, armor, agility;
    boolean hasWeapon;
    weapon currentWeapon;
   
    int fnameLength = rquestMain.firstName.length;
    int lnameLength = rquestMain.lastName.length;
    int speciesLength = rquestMain.speciesList.length;

    public static double getRandomIntegerBetweenRange(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public player() {
        money = (int)getRandomIntegerBetweenRange(20, 50);
        name = rquestMain.firstName[(int) (0 + fnameLength * Math.random())] + " "
                + rquestMain.lastName[(int) (0 + lnameLength * Math.random())];
        species = rquestMain.speciesList[(int) (0 + speciesLength * Math.random())];
        currentWeapon = new weapon();
        currentWeapon.setWeaponType("fists");
        currentWeapon.setDamage(getRandomIntegerBetweenRange(3, 5));
        currentWeapon.setSize("medium");
        currentWeapon.setCost(0);

        //pretty sure modifier is for damage, kinda forgot it's been a while
        //tradeoff for more damage is less agility
        if (species == "human") { //humans are pretty basic
            health = (int) (50 + (60 * Math.random()));
            modifier = 1;
            agility = 1.5;
        }

        if (species == "orc") {//more power, less agility
            health = (int) (60 + (70 * Math.random()));
            modifier = 1.55;
            agility = .7;
        }

        if (species == "elf") {//like humans
            health = (int) (40 + (50 * Math.random()));
            modifier = 1.1;
            agility = 1.4;
        }

        if (species == "gnome") {//nimble
            health = (int) (30 + (40 * Math.random()));
            modifier = .90;
            agility = 2;
        }

        if (species == "dragonborn") {//like orcs
            health = (int) (55 + (65 * Math.random()));
            modifier = 1.5;
            agility = 1.75;
        }

        if (species == "dwarf") {//small, powerful
            health = (int) (50 + (65 * Math.random()));
            modifier = 1.25;
            agility = 1.25;
        }
    }

    public String getName() {
        return name;
    };

    public String getSpecies() {
        return species;
    };

    public int getHealth() {
        return health;
    };

    public double getModifier() {
        return modifier;
    };

    public int getMoney() {
        return money;
    };

    public double getAgility() {
        return agility;
    };

    public int setHealth(int newHealth) {
        health = newHealth;
        return newHealth;
    };

    public weapon setWeapon(weapon newWeapon) {
        currentWeapon = newWeapon;
        return newWeapon;
    };

    public weapon getWeapon() {
        return currentWeapon;
    };

    public double setAgility(double newAgility) {
        agility = newAgility;
        return newAgility;
    };

    public double setModifier(double newModifier) {
        modifier = newModifier;
        return newModifier;
    };

    public int setMoney(int newMoney) {
        money = newMoney;
        return money;
    };

    public String setName(String newName) {
        name = newName;
        return newName;
    };

    public String setSpecies(String newSpecies) {
        species = newSpecies;
        return newSpecies;
    };

    public boolean setHasWeapon(boolean newHasWeapon) {
        hasWeapon= newHasWeapon;
        return hasWeapon;
    };

    public boolean getHasWeapon() {
        return hasWeapon;
    };

    public String getInfo() {
        return "This player is a " + species + " named " + name + " with " + health + " hitpoints, " + agility + " agility, " + money
                + " gold, and a damage modifier of " + modifier + ". Has weapon: " + hasWeapon;
    }
}