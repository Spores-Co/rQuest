public class player
{
    String name, species;
    int health;
    double modifier;
    boolean hasWeapon;
    String[] speciesList = {"human", "orc", "elf", "gnome", "dragonborn", "dwarf"};
    String[] firstName = { "Rhaelhall", "Fipa", "Daviecrusha", "Mythicson", "Silvacackle", "Anskelisia", "Reyesookie",
            "Morganhugia", "Iflee", "Benallopa", "Silva", "Hartrositia", "Simsensteinia", "Yosaunders", "Benalka",
            "Olakelley", "Slimerice", "Burgat", "Thudguzman", "Hammasrice", "Philaf", "Harrisrek", "Rhaelrter",
            "Gagruel", "Murphire", "Mcdonahell", "Jikinirthy" };
    String[] lastName = { "the parallel", "the juvenile", "the subdued", "the squalid", "the violent", "the fretful",
            "the powerful", "the wary", "the broad", "the ludicrous", "the dizzy", "the intelligent", "the grotesque",
            "the annoying", "the wealthy", "the puny", "the bizarre", "the learned", "the cumbersome", "the chilly",
            "the resolute", "the juvinile", "the frantic", "the industrious", "the hellish", "the puzzled" };
    int fnameLength = firstName.length;
    int lnameLength = lastName.length;
    int speciesLength = speciesList.length;

    public player()
    {
        name = firstName[(int) (0 + fnameLength * Math.random())] + " " + lastName[(int) (0 + lnameLength * Math.random())];
        species = speciesList[(int) (0 + speciesLength * Math.random())];

        if (species == "human")
        {
            health = (int) (50 + (60 * Math.random()));
            modifier = 1;
        }

        if (species == "orc")
        {
            health = (int) (60 + (70 * Math.random()));
            modifier = 1.55;
        }

        if (species == "elf")
        {
            health = (int) (40 + (50 * Math.random()));
            modifier = 1.1;
        }

        if (species == "gnome")
        {
            health = (int) (30 + (40 * Math.random()));
            modifier = .90;
        }

        if (species == "dragonborn")
        {
            health = (int) (55 + (65 * Math.random()));
            modifier = 1.5;
        }

        if (species == "dwarf")
        {
            health = (int) (50 + (65 * Math.random()));
            modifier = 1.25;
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