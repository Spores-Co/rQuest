package com.doopstudio.rquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class openShop extends AppCompatActivity {

    private int maxShopitems = 3;
    public TextView[] item_info = new TextView[maxShopitems];
    public Button[] buy_item_buttons = new Button[maxShopitems];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_shop);
        addItemTextToArray();
        addBuyItemButtonsToArray();
        setItemText();
        disableUnusedItems();
    }

    public void buyitem(View view)
    {
        if(view.getTag().equals("1"))
        {
            rquestMain.playerCharacter.setWeapon(rquestMain.currentTile.shop.sellList[0]);
            System.out.println("Player weapon set to: " + rquestMain.currentTile.shop.sellList[0].getWeaponType());
            disableBuyButtons();
        }
        if(view.getTag().equals("2"))
        {
            rquestMain.playerCharacter.setWeapon(rquestMain.currentTile.shop.sellList[1]);
            System.out.println("Player weapon set to: " + rquestMain.currentTile.shop.sellList[1].getWeaponType());
            disableBuyButtons();
        }
        if(view.getTag().equals("3"))
        {
            rquestMain.playerCharacter.setWeapon(rquestMain.currentTile.shop.sellList[2]);
            System.out.println("Player weapon set to: " + rquestMain.currentTile.shop.sellList[2].getWeaponType());
            disableBuyButtons();
        }

    }

    public void disableBuyButtons()
    {
        for(int i = 0; i<maxShopitems; i++)
        {
            buy_item_buttons[i].setEnabled(false);
        }
    }

    public void addBuyItemButtonsToArray()
    {
        final Button buy_item_1 = findViewById(R.id.buy_item_1);
        final Button buy_item_2 = findViewById(R.id.buy_item_2);
        final Button buy_item_3 = findViewById(R.id.buy_item_3);
        for(int i = 0; i<maxShopitems; i++)
        {
            if(i==0)
            {
                buy_item_buttons[i] = buy_item_1;
            }
            if(i==1)
            {
                buy_item_buttons[i] = buy_item_2;
            }
            if(i==2)
            {
                buy_item_buttons[i] = buy_item_3;
            }
        }
    }

    public void addItemTextToArray()
    {
        final TextView info_item_1 = findViewById(R.id.info_item_1);
        final TextView info_item_2 = findViewById(R.id.info_item_2);
        final TextView info_item_3 = findViewById(R.id.info_item_3);
        for(int i = 0; i<maxShopitems; i++)
        {
            if(i==0)
            {
                item_info[i] = info_item_1;
            }
            if(i==1)
            {
                item_info[i] = info_item_2;
            }
            if(i==2)
            {
                item_info[i] = info_item_3;
            }
        }
    }

    public void disableUnusedItems()
    {
        int numOfItems = rquestMain.currentTile.shop.numOfItems;
        if(numOfItems == 1)
        {
            item_info[1].setVisibility(View.INVISIBLE);
            buy_item_buttons[1].setVisibility(View.INVISIBLE);
            item_info[2].setVisibility(View.INVISIBLE);
            buy_item_buttons[2].setVisibility(View.INVISIBLE);
        }
        if(numOfItems == 2)
        {
            item_info[2].setVisibility(View.INVISIBLE);
            buy_item_buttons[2].setVisibility(View.INVISIBLE);
        }
    }

    public void setItemText()
    {
        for (int j = 0; j <= rquestMain.currentTile.shop.numOfItems - 1; j++) {
            String itemText = "\nItem " + (j + 1) + " - Weapon Type: " + rquestMain.currentTile.shop.sellList[j].getWeaponType()
                    + " | \nWeapon Damage: " + rquestMain.currentTile.shop.sellList[j].getDamage() + " | \nSize: "
                    + rquestMain.currentTile.shop.sellList[j].getSize() + " | \nCost: " + rquestMain.currentTile.shop.sellList[j].getCost() + "\n";
            item_info[j].setText(itemText) ;
        }
    }
}
