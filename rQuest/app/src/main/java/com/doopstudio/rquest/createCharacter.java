package com.doopstudio.rquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;


public class createCharacter extends AppCompatActivity {

    private int traitCounter;
    private String raceHolder = "none";
    private int numOfRaces = 6;
    private CheckBox[] races = new CheckBox[numOfRaces];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);
        //rquestMain.createPlayer(raceHolder);
        addRaceCheckboxesIntoArray();
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
        for(int i = 0; i< numOfRaces; i++)
        {
            if(i == 0)
            {
                races[i] = humanCheckbox;
                traitCounter = 4;
            }
            if(i == 1)
            {
                races[i] = orcCheckbox;
                traitCounter = 2;
            }
            if(i == 2)
            {
                races[i] = elfCheckbox;
                traitCounter = 3;
            }
            if(i == 3)
            {
                races[i] = gnomeCheckbox;
                traitCounter = 2;
            }
            if(i == 4)
            {
                races[i] = dragonbornCheckbox;
                traitCounter = 2;
            }
            if(i == 5)
            {
                races[i] = dwarfCheckbox;
                traitCounter = 2;
            }
        }
    }




    public void setRaceCheckboxesDisabled()
    {
        for(int i = 0; i< numOfRaces; i++)
        {
            races[i].setEnabled(false);
        }
    }

    public void setRaceCheckboxesUnchecked(String raceHolder)
    {
        for(int i = 0; i< numOfRaces; i++)
        {
            races[i].setChecked(false);
            if(races[i].getTag().toString().equals(raceHolder))
            {
                races[i].setChecked(true);
            }
        }
    }

    public void setPlayerRace(View view) {
        raceHolder = view.getTag().toString();
        System.out.println("Race = "  + raceHolder);
        rquestMain.species = raceHolder;
        rquestMain.skillLength = traitCounter;
        rquestMain.createPlayer(raceHolder);
        //rquestMain.playerCharacter.setSpecies(raceHolder);
        System.out.println(rquestMain.playerCharacter.getInfo());
        setRaceCheckboxesUnchecked(raceHolder);


    }
}
/*TODO make it so the traits go into the trait / skill list */
