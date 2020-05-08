public class shop
{
    
    int numOfItems = (int)getRandomIntegerBetweenRange(1, 3);

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    weapon[] sellList = new weapon[numOfItems];

    public shop(weapon weapon1, weapon weapon2, weapon weapon3)
    {
        if(numOfItems==1)
        {
            sellList[0]=weapon1;
        }
        if(numOfItems==2)
        {
            sellList[0]=weapon1;
            sellList[1]=weapon2;
        }
        if(numOfItems==3)
        {
            sellList[0]=weapon1;
            sellList[1]=weapon2;
            sellList[2]=weapon3;
        }
        else{}
    }

    public int getCost(int weaponNumber) {
        return sellList[weaponNumber].cost;
    };

    public double getDamage(int weaponNumber) {
        return sellList[weaponNumber].damage;
    };

    public String getWeaponType(int weaponNumber) {
        return sellList[weaponNumber].weaponType;
    };

    public String getSize(int weaponNumber) {
        return sellList[weaponNumber].size;
    };

    public boolean isRanged(int weaponNumber) {
        return sellList[weaponNumber].isRanged;
    };

    public int setCost(int newCost, int weaponNumber) {
        sellList[weaponNumber].cost = newCost;
        return newCost;
    };

    public double setDamage(double newDamage, int weaponNumber) {
        sellList[weaponNumber].damage = newDamage;
        return newDamage;
    };

    public String setWeaponType(String newWeaponType, int weaponNumber) {
        sellList[weaponNumber].weaponType = newWeaponType;
        return newWeaponType;
    };

    public String setSize(String newSize, int weaponNumber) {
        sellList[weaponNumber].size = newSize;
        return newSize;
    };

    public boolean setIsRanged(boolean newIsRanged, int weaponNumber) {
        sellList[weaponNumber].isRanged = newIsRanged;
        return newIsRanged;
    };

    public String getInfo() 
    {
        String info = "This shop has " + numOfItems + " items: ";
        if(numOfItems==1)
        {
            info = info + "Item 1 - " + sellList[0].getInfo();
        }
        if(numOfItems==2)
        {
            info = info + "Item 1 - " + sellList[0].getInfo();
            info = info + " Item 2 - " + sellList[1].getInfo();
        }
        if(numOfItems==3)
        {
            info = info + "Item 1 - " + sellList[0].getInfo();
            info = info + " Item 2 - " + sellList[1].getInfo();
            info = info + " Item 3 - " + sellList[2].getInfo();
        }
        return info; 
    }
}