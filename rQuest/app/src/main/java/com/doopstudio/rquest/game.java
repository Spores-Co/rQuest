package com.doopstudio.rquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class game extends AppCompatActivity {

    public void updatePlayerStats() {
        final TextView playerCurrentHealth = (TextView) findViewById(R.id.player_current_health);
        final TextView playerGold = (TextView) findViewById(R.id.player_gold);
        final TextView playerWeapon = (TextView) findViewById(R.id.player_current_weapon);
        String currentHealth = String.valueOf(rquestMain.playerCharacter.getHealth());
        String gold = String.valueOf(rquestMain.playerCharacter.getMoney());
        playerCurrentHealth.setText(currentHealth);
        playerWeapon.setText(rquestMain.playerCharacter.getWeapon().getWeaponType());
        playerGold.setText(gold);

    }

    public void disableNext()
    {
        final Button nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setEnabled(false);

    }

    public void enableNext()
    {
        final Button nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setEnabled(true);

    }
    private TextView enemyCurrentHealth;
    private TextView enemyMaxHealth;
    private TextView enemySpecies;
    private TextView enemyName;
    private TextView enemyCurrentHealthLabel;
    private TextView enemyMaxHealthLabel;
    private TextView enemySpeciesLabel;
    private TextView enemyNameLabel;

    public void updateEnemyStats() {

        String currentHealth = String.valueOf(rquestMain.currentTile.encounter.getHealth());
        String maxHealth = String.valueOf(rquestMain.currentTile.encounter.getMaxHealth());
        String name = rquestMain.currentTile.encounter.getName();
        String species = rquestMain.currentTile.encounter.getSpecies();
        enemyCurrentHealth.setText(currentHealth);
        //System.out.println("Enemy health is now; " + currentHealth);
        enemyName.setText(name);
        enemySpecies.setText(species);
        enemyMaxHealth.setText(maxHealth);

    }

    private TextView playerMaxHealth;

    public void setEnemyStatsInvisible()
    {
        enemyCurrentHealth.setVisibility(View.INVISIBLE);
        enemyMaxHealth.setVisibility(View.INVISIBLE);
        enemySpecies.setVisibility(View.INVISIBLE);
        enemyName.setVisibility(View.INVISIBLE);
        enemyCurrentHealthLabel.setVisibility(View.INVISIBLE);
        enemyMaxHealthLabel.setVisibility(View.INVISIBLE);
        enemySpeciesLabel.setVisibility(View.INVISIBLE);
        enemyNameLabel.setVisibility(View.INVISIBLE);
    }

    public void setEnemyStatsVisible()
    {
        enemyCurrentHealth.setVisibility(View.VISIBLE);
        enemyMaxHealth.setVisibility(View.VISIBLE);
        enemySpecies.setVisibility(View.VISIBLE);
        enemyName.setVisibility(View.VISIBLE);
        enemyCurrentHealthLabel.setVisibility(View.VISIBLE);
        enemyMaxHealthLabel.setVisibility(View.VISIBLE);
        enemySpeciesLabel.setVisibility(View.VISIBLE);
        enemyNameLabel.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        rquestMain.rQuest();
        encounterText = findViewById(R.id.encounter_name);
        playerMaxHealth = findViewById(R.id.player_max_health);
        String maxHealth = String.valueOf(rquestMain.playerCharacter.getHealth());
        playerMaxHealth.setText(maxHealth);
        final Button nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playTile(encounterText);

            }
        });

        enemyCurrentHealth = (TextView) findViewById(R.id.enemy_current_health);
        enemyMaxHealth = (TextView) findViewById(R.id.enemy_max_health);
        enemySpecies = (TextView) findViewById(R.id.species_name);
        enemyName = (TextView) findViewById(R.id.enemy_name);
        enemyCurrentHealthLabel = (TextView) findViewById(R.id.label_enemy_current_health);
        enemyMaxHealthLabel = (TextView) findViewById(R.id.label_enemy_max_health);
        enemySpeciesLabel = (TextView) findViewById(R.id.label_enemy_species);
        enemyNameLabel = (TextView) findViewById(R.id.label_enemy_name);

        playTile(encounterText);
        scrollToBottom();
    }

    //1 is pick up weapon or not
    //2 is buy powerup or not
    //3 is do task for powerup or not
    //4 is shop
    //5 is do task for damage or not
    //6 is buy powerdown or not
    //7 is do action for powerdown or not
    //8 is heal or not
    //0 is other event types
    //9 is encounter


    private TextView encounterText; //holds reply textview element
    

    public void encounter_set(View view) {

        encounterText.setText(rquestMain.encounterInfo);

    }

    public void set_and_scroll()
    {
        encounterText.setText(rquestMain.encounterInfo);
        scrollToBottom();
    }

    public void set_new_encounter_info()
    {
       //final TextView newEncounterText = findViewById(R.id.encounter_new_info); THIS IS TO CHANGE THE INFO STUFF AT TOP, PROBS NOT GONNA USE
        //newEncounterText.setText(rquestMain.newEncounterInfo);
    }

    public void disableYesNo() {
        final Button yesButton = (Button) findViewById(R.id.button_yes);
        final Button noButton = (Button) findViewById(R.id.button_no);
        yesButton.setEnabled(false);
        noButton.setEnabled(false);
    }

    public void enableYesNo() {
        final Button yesButton = (Button) findViewById(R.id.button_yes);
        final Button noButton = (Button) findViewById(R.id.button_no);
        yesButton.setEnabled(true);
        noButton.setEnabled(true);
    }

    public void disableFightRun() {
        final Button fightButton = (Button) findViewById(R.id.button_fight);
        final Button runButton = (Button) findViewById(R.id.button_run);
        fightButton.setEnabled(false);
        runButton.setEnabled(false);
    }

    public void enableFightRun() {
        final Button fightButton = (Button) findViewById(R.id.button_fight);
        final Button runButton = (Button) findViewById(R.id.button_run);
        fightButton.setEnabled(true);
        runButton.setEnabled(true);
    }

    public void scrollToBottom()
    {
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.info));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }


    public void playTile(View view) {
        setEnemyStatsInvisible();
        final Button yesButton = (Button) findViewById(R.id.button_yes);
        final Button noButton = (Button) findViewById(R.id.button_no);
        final Button fightButton = (Button) findViewById(R.id.button_fight);
        final Button runButton = (Button) findViewById(R.id.button_run);
        disableYesNo();
        disableFightRun();
        disableNext();
        set_new_encounter_info();
        //updateEnemyStats();

        int buttonType = rquestMain.playTile();
        System.out.println("next tile");
        if (buttonType == 1) {
            enableYesNo();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.pickUpWeapon();
                    updatePlayerStats();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.pickUpWeaponDecline();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });
            set_and_scroll();
        }
        if (buttonType == 2) {
            enableYesNo();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.powerupSalesmanAccept();
                    updatePlayerStats();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.powerupSalesmanDecline();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });
            set_and_scroll();
        }
        if (buttonType == 3) {
            enableYesNo();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.powerupAccept();
                    updatePlayerStats();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.powerupDecline();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });
            set_and_scroll();
        }
        if (buttonType == 4) {
            enableYesNo();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.selectWeapon(rquestMain.currentTile);
                    updatePlayerStats();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.declineShop();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });
            set_and_scroll();
        }
        if (buttonType == 5) {
            enableYesNo();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.damage();
                    updatePlayerStats();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.declineDamage();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });
            set_and_scroll();
        }
        if (buttonType == 6) {
            enableYesNo();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.acceptPowerdownSalesman(rquestMain.gold);
                    updatePlayerStats();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.declinePowerdownSalesman();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });
            set_and_scroll();
        }
        if (buttonType == 7) {
            enableYesNo();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.acceptPowerdown();
                    updatePlayerStats();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.declinePowerdown();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });
            set_and_scroll();
        }
        if (buttonType == 8) {
            enableYesNo();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.heal();
                    updatePlayerStats();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.healDecline();
                    disableYesNo();
                    enableNext();
                    set_and_scroll();
                }
            });
            set_and_scroll();

        }

        if (buttonType == 9) {

            disableNext();
            updatePlayerStats();
            enableFightRun();
            set_new_encounter_info();
            updateEnemyStats();
            setEnemyStatsVisible();
            fightButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.fight(rquestMain.currentTile);
                    updatePlayerStats();
                    updateEnemyStats();
                    disableYesNo();
                    set_new_encounter_info();
                    if(rquestMain.currentTile.encounter.getHealth() <=0)
                    {
                        enableNext();
                        disableFightRun();
                        set_and_scroll();
                    }
                    set_and_scroll();
                }
            });

            runButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rquestMain.run(rquestMain.currentTile);
                    updatePlayerStats();
                    updateEnemyStats();
                    disableYesNo();
                    set_new_encounter_info();
                    if(rquestMain.currentTile.getDefeated())
                    {
                        set_and_scroll();
                        enableNext();
                        disableFightRun();
                    }
                    set_and_scroll();
                }
            });
            set_and_scroll();
        }

        if (buttonType == 0) {
            enableNext();
            yesButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });
            set_and_scroll();
        }
        set_and_scroll();
        set_new_encounter_info();
        updatePlayerStats();
        scrollToBottom();

    }

    public void openShop(View view) {


    }
}
