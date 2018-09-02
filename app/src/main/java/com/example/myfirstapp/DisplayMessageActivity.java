package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        /*//Get the intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);*/

        Intent intent = getIntent();
        PizzaIngredients ingredients = (PizzaIngredients) intent.getSerializableExtra("ingredientsObject");
        TextView flourView = findViewById(R.id.flour);
        TextView waterView = findViewById(R.id.water);
        TextView oliveOilView = findViewById(R.id.oliveOil);
        TextView yeastView = findViewById(R.id.yeast);
        TextView saltView = findViewById(R.id.salt);
        flourView.setText(ingredients.getFlourAmount() + " dl");
        waterView.setText(ingredients.getAmountWaterAmount() + " dl");
        oliveOilView.setText(ingredients.getOliveOilAmount() + ((ingredients.getOliveOilAmount() > 1) ? " spiseskjeer" : " spiseskje"));
        yeastView.setText(ingredients.getYeastAmount() + ((ingredients.getYeastAmount() > 1) ? " pakker" : " pakke"));
        saltView.setText(ingredients.getSaltAmount() + " teskje" + ((ingredients.getSaltAmount() > 1) ? "er" : ""));


    }
}
