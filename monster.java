
public class monster {

    String[] firstName = { "Rhaelhall", "Fipa", "Daviecrusha", "Mythicson", "Silvacackle", "Anskelisia", "Reyesookie",
            "Morganhugia", "Iflee", "Benallopa", "Silva", "Hartrositia", "Simsensteinia", "Yosaunders", "Benalka",
            "Olakelley", "Slimerice", "Burgat", "Thudguzman", "Hammasrice", "Philaf", "Harrisrek", "Rhaelrter",
            "Gagruel", "Murphire", "Mcdonahell", "Jikinirthy", "Strogis", "Trivent", "Ednir", "Alvenyo", "Haeghet", "Deslet" };
    String[] lastName = { "the parallel", "the juvenile", "the subdued", "the squalid", "the violent", "the fretful",
            "the powerful", "the wary", "the broad", "the ludicrous", "the dizzy", "the intelligent", "the grotesque",
            "the annoying", "the wealthy", "the puny", "the bizarre", "the learned", "the cumbersome", "the chilly",
            "the resolute", "the juvinile", "the frantic", "the industrious", "the hellish", "the puzzled", "the coy", "the wise" };

    String[] speciesList = { "goblin", "hobgoblin", "rat", "kobold", "banshee", "spider", "lizard", "troll", "giant",
            "beetle", "bandit", "dragon", "bat", "snake", "bear", "slime" };

    String name, species;
    int health;
    double modifier;
    boolean hasWeapon;
    int fnameLength = firstName.length;
    int lnameLength = lastName.length;
    int speciesLength = speciesList.length;

    public monster(boolean carryingWeapon) 
    {
        hasWeapon = carryingWeapon;
        name = firstName[(int) (0 + fnameLength * Math.random())] + " " + lastName[(int) (0 + lnameLength * Math.random())];
        species = speciesList[(int) (0 + speciesLength * Math.random())];

        if (species == "goblin")
        {
            health = (int) (7 + (10 * Math.random()));
            modifier = .5;
        }
        if (species == "hobgoblin")
        {
            health = (int) (10 + (13 * Math.random()));
            modifier = .66;
        }
        if (species == "rat")
        {
            health = (int) (3 + (7 * Math.random()));
            modifier = .33;
        }
        if (species == "kobold")
        {
            health = (int) (8 + (11 * Math.random()));
            modifier = .75;
        }
        if (species == "banshee")
        {
            health = (int) (5 + (8 * Math.random()));
            modifier = .8;
        }
        if (species == "spider")
        {
            health = (int) (5 + (7 * Math.random()));
            modifier = .8;
        }
        if (species == "lizard")
        {
            health = (int) (5 + (10 * Math.random()));
            modifier = .50;
        }
        if (species == "troll")
        {
            health = (int) (15 + (20 * Math.random()));
            modifier = 1.15;
        }
        if (species == "giant")
        {
            health = (int) (20 + (25 * Math.random()));
            modifier = 2.50;
        }
        if (species == "beetle")
        {
            health = (int) (4 + (7 * Math.random()));
            modifier = .50;
        }
        if (species == "bandit")
        {
            health = (int) (7 + (12 * Math.random()));
            modifier = 1.00;
        }
        if (species == "dragon")
        {
            health = (int) (20 + (30 * Math.random()));
            modifier = 3.00;
        }
        if (species == "bat")
        {
            health = (int) (2 + (4 * Math.random()));
            modifier = .15;
        }
        if (species == "snake")
        {
            health = (int) (5 + (6 * Math.random()));
            modifier = .50;
        }
        if (species == "bear")
        {
            health = (int) (13 + (16 * Math.random()));
            modifier = 2.00;
        }
        if (species == "slime")
        {
            health = (int) (1 + (3 * Math.random()));
            modifier = .20;
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

    public String getInfo() {return "This is a "+ species + " named " + name + " with " + health + " hitpoints and a damage modifier of " + modifier + ". Has weapon: " + hasWeapon; 
    }
}