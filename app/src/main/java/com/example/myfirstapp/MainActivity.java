package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WeekNumberGetter ukeNummerHenter = new WeekNumberGetter();
        int ukeNummer = ukeNummerHenter.getWeekNumber();
        TextView sigmundVask = findViewById(R.id.sigmundVask);
        TextView simenVask = findViewById(R.id.simenVask);
        TextView stianVask = findViewById(R.id.stianVask);
        List<String> vaskeListe = Arrays.asList("Bad", "Gulv/Stue", "Kjøkken");
        List<String> sortedList = new ArrayList<String>();
        for(int i = ukeNummer%vaskeListe.size() ; i < vaskeListe.size(); i++){
            sortedList.add(vaskeListe.get(i));
        }

        for(int i=0; i < ukeNummer%vaskeListe.size();i++){
            sortedList.add(vaskeListe.get(i));
        }

        sigmundVask.setText(sortedList.get(0));
        simenVask.setText(sortedList.get(1));
        stianVask.setText(sortedList.get(2));
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendResult(View view) {
        TextView errorMsgView = findViewById(R.id.errorView);
        errorMsgView.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String input = editText.getText().toString();
        if(!checkInput(input)){
            errorMsgView.setVisibility(View.VISIBLE);
            errorMsgView.setText("Skriv inn et tall! Kan ikke lage pizza til " + input + " personer liksom!");
            return;
        }
        if(input.matches("")){
            return;
        }
        if(Double.parseDouble(input) > Integer.MAX_VALUE){
            errorMsgView.setVisibility(View.VISIBLE);
            errorMsgView.setText("Du skal vel ikke ha såå mye pizza?");
            return;
        }

        PizzaIngredients ingredientsBasedOnInput = new PizzaIngredients(Integer.parseInt(input));
        intent.putExtra("ingredientsObject",ingredientsBasedOnInput);
        startActivity(intent);
    }

    public boolean checkInput(String input){
        //Sjekker om input kun er digits :)
        for(char character : input.toCharArray()){
            if(!Character.isDigit(character)){
                return false;
            }
        }
        return true;
    }


}
