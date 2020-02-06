
public class rquestMain {

  public static void generateMonster(monster[] monsters) 
  {
    
    for (int i = 0; i < monsters.length; i++) 
    {
      boolean hasWeapon = hasWeapon();
      monsters[i] = new monster(hasWeapon);
    }
    for (int i = 0; i < monsters.length; i++) {
      System.out.println(monsters[i].getInfo());
    }
  }
  
  public static boolean hasWeapon()
  {
    int rand = (int) (0 + 2 * Math.random());
    if(rand == 1)
    {return true;}
    else{return false;}
  }

  public static void main(String[] args) {

    monster[] monsters = new monster[10];
    generateMonster(monsters);

  }
}