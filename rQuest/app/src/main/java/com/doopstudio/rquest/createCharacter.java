package com.doopstudio.rquest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;


public class createCharacter extends AppCompatActivity {

    private int traitCounter;
    private String raceHolder = "none";
    private int numOfRaces = 6;
    private int numOfTraits = 9;
    private int numOfTraitsUsed = 0;
    private CheckBox[] races = new CheckBox[numOfRaces];
    private CheckBox[] traits = new CheckBox[numOfTraits];
    private boolean allTraitsSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);
        //rquestMain.createPlayer(raceHolder);
        addRaceCheckboxesIntoArray();
        addSkillCheckboxesIntoArray();
        setTraitCheckboxesDisabled();
        disablePlayButton();
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, game.class); //creates the intent
        //String message = mMessageEditText.getText().toString(); //takes mMessageEditText and assigns it to a string
        //TEXT_REQUEST is the request code
        startActivity(intent);
    }

    public void addRaceCheckboxesIntoArray() //add extra races here
    {
        final CheckBox humanCheckbox = findViewById(R.id.human);
        final CheckBox orcCheckbox = findViewById(R.id.orc);
        final CheckBox elfCheckbox = findViewById(R.id.elf);
        final CheckBox gnomeCheckbox = findViewById(R.id.gnome);
        final CheckBox dragonbornCheckbox = findViewById(R.id.dragonborn);
        final CheckBox dwarfCheckbox = findViewById(R.id.dwarf);
        for (int i = 0; i < numOfRaces; i++) {
            if (i == 0) {
                races[i] = humanCheckbox;

            }
            if (i == 1) {
                races[i] = orcCheckbox;

            }
            if (i == 2) {
                races[i] = elfCheckbox;

            }
            if (i == 3) {
                races[i] = gnomeCheckbox;

            }
            if (i == 4) {
                races[i] = dragonbornCheckbox;

            }
            if (i == 5) {
                races[i] = dwarfCheckbox;

            }
        }
    }

    public void addSkillCheckboxesIntoArray() //add extra races here
    {
        final CheckBox weaponsmith_checkbox = findViewById(R.id.weaponsmith);
        final CheckBox tough_skin_checkbox = findViewById(R.id.tough_skin);
        final CheckBox slippery_checkbox = findViewById(R.id.slippery);
        final CheckBox one_with_nature_checkbox = findViewById(R.id.one_with_nature);
        final CheckBox sixth_sense_checkbox = findViewById(R.id.sixth_sense);
        final CheckBox heavy_weapons_checkbox = findViewById(R.id.heavy_weapons);
        final CheckBox sword_master_checkbox = findViewById(R.id.sword_master);
        final CheckBox dagger_master_checkbox = findViewById(R.id.dagger_master);
        final CheckBox blunt_weapons_master_checkbox = findViewById(R.id.blunt_weapons_master);
        for (int i = 0; i < numOfTraits; i++) {
            if (i == 0) {
                traits[i] = weaponsmith_checkbox;

            }
            if (i == 1) {
                traits[i] = tough_skin_checkbox;

            }
            if (i == 2) {
                traits[i] = slippery_checkbox;

            }
            if (i == 3) {
                traits[i] = one_with_nature_checkbox;

            }
            if (i == 4) {
                traits[i] = sixth_sense_checkbox;

            }
            if (i == 5) {
                traits[i] = heavy_weapons_checkbox;

            }
            if (i == 6) {
                traits[i] = sword_master_checkbox;

            }
            if (i == 7) {
                traits[i] = dagger_master_checkbox;

            }
            if (i == 8) {
                traits[i] = blunt_weapons_master_checkbox;

            }
        }
    }

    public void fillSkillArray(View view) {
        String traitToAdd = view.getTag().toString();
        if (traitCounter == 2) {
            if (rquestMain.playerCharacter.getSkill(0) == null && rquestMain.playerCharacter.getSkill(1) == null) {
                rquestMain.playerCharacter.setSkill(0, traitToAdd);
            } else if (rquestMain.playerCharacter.getSkill(0) != null && rquestMain.playerCharacter.getSkill(1) == null) {
                rquestMain.playerCharacter.setSkill(1, traitToAdd);
                allTraitsSelected = true;
            } else {
                for (int i = 0; i < numOfTraits; i++) {
                    if (view.getTag().toString() == traits[i].getTag().toString()) {
                        traits[i].setChecked(false);

                    }

                }
            }
        }
        if (traitCounter == 3) {
            if (rquestMain.playerCharacter.getSkill(0) == null && rquestMain.playerCharacter.getSkill(1) == null && rquestMain.playerCharacter.getSkill(2) == null) {
                rquestMain.playerCharacter.setSkill(0, traitToAdd);
            } else if (rquestMain.playerCharacter.getSkill(0) != null && rquestMain.playerCharacter.getSkill(1) == null && rquestMain.playerCharacter.getSkill(2) == null) {
                rquestMain.playerCharacter.setSkill(1, traitToAdd);
            } else if (rquestMain.playerCharacter.getSkill(0) != null && rquestMain.playerCharacter.getSkill(1) != null && rquestMain.playerCharacter.getSkill(2) == null) {
                rquestMain.playerCharacter.setSkill(2, traitToAdd);
                allTraitsSelected = true;
            } else {
                for (int i = 0; i < numOfTraits; i++) {
                    if (view.getTag().toString() == traits[i].getTag().toString()) {
                        traits[i].setChecked(false);
                    }
                }
            }
        }
        if (traitCounter == 4) {
            {
                {
                    if (rquestMain.playerCharacter.getSkill(0) == null && rquestMain.playerCharacter.getSkill(1) == null && rquestMain.playerCharacter.getSkill(2) == null && rquestMain.playerCharacter.getSkill(3) == null) {
                        rquestMain.playerCharacter.setSkill(0, traitToAdd);
                    } else if (rquestMain.playerCharacter.getSkill(0) != null && rquestMain.playerCharacter.getSkill(1) == null && rquestMain.playerCharacter.getSkill(2) == null && rquestMain.playerCharacter.getSkill(3) == null) {
                        rquestMain.playerCharacter.setSkill(1, traitToAdd);
                    } else if (rquestMain.playerCharacter.getSkill(0) != null && rquestMain.playerCharacter.getSkill(1) != null && rquestMain.playerCharacter.getSkill(2) == null && rquestMain.playerCharacter.getSkill(3) == null) {
                        rquestMain.playerCharacter.setSkill(2, traitToAdd);
                    } else if (rquestMain.playerCharacter.getSkill(0) != null && rquestMain.playerCharacter.getSkill(1) != null && rquestMain.playerCharacter.getSkill(2) != null && rquestMain.playerCharacter.getSkill(3) == null) {
                        rquestMain.playerCharacter.setSkill(3, traitToAdd);
                        allTraitsSelected = true;
                    } else {
                        for (int i = 0; i < numOfTraits; i++) {
                            if (view.getTag().toString() == traits[i].getTag().toString()) {
                                traits[i].setChecked(false);


                            }
                        }

                    }

                }
            }
        }
        rquestMain.playerCharacter.getAllSkills();
        if (allTraitsSelected) //checks to see if all skills have been selected and if so disables them
        {
            setTraitCheckboxesDisabled();
            enablePlayButton();
        }
    }

    public void setRaceCheckboxesDisabled() {
        for (int i = 0; i < numOfRaces; i++) {
            races[i].setEnabled(false);
        }
    }

    public void setTraitCheckboxesDisabled() {
        for (int i = 0; i < numOfTraits; i++) {
            traits[i].setEnabled(false);
        }
    }

    public void setTraitCheckboxesEnabled() {
        for (int i = 0; i < numOfTraits; i++) {
            traits[i].setEnabled(true);
        }
    }

    public void setTraitCheckboxesUnchecked() {
        for (int i = 0; i < numOfTraits; i++) {
            traits[i].setChecked(false);
        }
    }

    public void setRaceCheckboxesUnchecked(String raceHolder) {
        for (int i = 0; i < numOfRaces; i++) {
            races[i].setChecked(false);
            if (races[i].getTag().toString().equals(raceHolder)) {
                races[i].setChecked(true);
            }
        }
    }

    public void enablePlayButton()
    {
        final Button play = (Button) findViewById(R.id.play_button);
        play.setTag("enabled");
        play.setEnabled(true);

    }

    public void disablePlayButton()
    {
        final Button play = (Button) findViewById(R.id.play_button);
        play.setTag("disabled");
        play.setEnabled(false);
    }

    public void setPlayerRace(View view) {
        raceHolder = view.getTag().toString();
        System.out.println("Race = " + raceHolder);
        rquestMain.species = raceHolder;
        disablePlayButton();
        setTraitCheckboxesUnchecked();
        allTraitsSelected = false;
        if (raceHolder.equals("human")) {
            traitCounter = 4;
        }
        if (raceHolder.equals("orc")) {
            traitCounter = 2;
        }
        if (raceHolder.equals("elf")) {
            traitCounter = 3;
        }
        if (raceHolder.equals("gnome")) {
            traitCounter = 2;
        }
        if (raceHolder.equals("dragonborn")) {
            traitCounter = 2;
        }
        if (raceHolder.equals("dwarf")) {
            traitCounter = 2;
        }
        rquestMain.skillLength = traitCounter;
        rquestMain.createPlayer(raceHolder);
        System.out.println("Trait Counter = " + rquestMain.playerCharacter.getSkillsLength());
        //rquestMain.playerCharacter.setSpecies(raceHolder);
        System.out.println(rquestMain.playerCharacter.getInfo());
        setRaceCheckboxesUnchecked(raceHolder);
        setTraitCheckboxesEnabled();
    }
}

