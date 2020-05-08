package com.doopstudio.rquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, createCharacter.class); //creates the intent
        //String message = mMessageEditText.getText().toString(); //takes mMessageEditText and assigns it to a string
        //TEXT_REQUEST is the request code
        startActivity(intent);
    }

}
