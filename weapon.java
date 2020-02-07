public class weapon
{
    int cost;
    String[] weaponList = { "dagger", "shortsword", "longsword", "greatsword", "handaxe", "greataxe"};
    String weaponType, size;
    boolean isRanged;
    double weaponListLength = weaponList.length;
    double damage;

    public static double getRandomIntegerBetweenRange(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public weapon()
    {
        weaponType = weaponList[(int)getRandomIntegerBetweenRange(0, weaponListLength-1)];

        if(weaponType == "dagger")
        {
            cost = (int)getRandomIntegerBetweenRange(2, 4);
            damage = (int)getRandomIntegerBetweenRange(2, 4);
            isRanged = false;
            size = "small";
        }

        if(weaponType == "shortsword")
        {
            cost = (int)getRandomIntegerBetweenRange(6, 8);
            damage = (int)getRandomIntegerBetweenRange(7, 8);
            isRanged = false;
            size = "medium";
        }

        if(weaponType == "longsword")
        {
            cost = (int)getRandomIntegerBetweenRange(8, 10);
            damage = (int)getRandomIntegerBetweenRange(8, 9);
            isRanged = false;
            size = "medium";
        }

        if(weaponType == "greatsword")
        {
            cost = (int)getRandomIntegerBetweenRange(15, 20);
            damage = (int)getRandomIntegerBetweenRange(14, 18);
            isRanged = false;
            size = "large";
        }

        if(weaponType == "handaxe")
        {
            cost = (int)getRandomIntegerBetweenRange(7, 9);
            damage = (int)getRandomIntegerBetweenRange(8, 9);
            isRanged = false;
            size = "small";
        }

        if(weaponType == "greataxe")
        {
            cost = (int)getRandomIntegerBetweenRange(17, 22);
            damage = (int)getRandomIntegerBetweenRange(15, 20);
            isRanged = false;
            size = "large";
        }

    }

    public int getCost() {
        return cost;
    };

    public double getDamage() {
        return damage;
    };

    public String getWeaponType() {
        return weaponType;
    };

    public String getSize() {
        return size;
    };

    public boolean isRanged() {
        return isRanged;
    };

    public int setCost(int newCost) {
        cost = newCost;
        return cost;
    };

    public double setDamage(double newDamage) {
        damage = newDamage;
        return newDamage;
    };

    public String setWeaponType(String newWeaponType) {
        weaponType = newWeaponType;
        return newWeaponType;
    };

    public String setSize(String newSize) {
        size = newSize;
        return newSize;
    };

    public boolean setIsRanged(boolean newIsRanged) {
        isRanged = newIsRanged;
        return newIsRanged;
    };

    public String getInfo() {
        return "This " + weaponType + " is " + size + " and has a cost of " + cost + " gold and a damage level of " + damage + ". Is ranged: " + isRanged;
    }
}