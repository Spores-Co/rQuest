import java.util.*;

public class monster
{
    String species, type, name, weapon;
    int health, power;
    String [] speciesList = { "goblin", "hobgoblin", "rat", "kobold", "banshee", "spider", "lizard", "troll", "giant", "beetle", "bandit", "dragon", "bat", "snake", "bear", "slime"};
    String [] typeList;
    String [] weaponList;
    int speciesLength = speciesList.length;
    public monster()
    {
        species = speciesList[(int) (0 + speciesLength * Math.random())];

        
    }
}