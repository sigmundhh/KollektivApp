package com.example.myfirstapp;

import java.io.Serializable;

public class PizzaIngredients implements Serializable {
    private double persons;
    static final double AmountFlourPerPerson = 7.0/4;
    static final double AmountOliveOilPerPerson = 2.0/4;
    static final double AmountWaterPerPerson = 3.0/4;
    static final double AmountYeastPerPerson = 0.5/4;
    static final double AmountSaltPerPerson = 0.5/4;




    public PizzaIngredients(int persons){
        this.persons = persons*2;
    }

    private double roundToOneDecimal(double r){
        return Math.round(r * 100.0) / 100.0;
    }
    private double roundToTwoDecimals(double r){
        return Math.round(r * 1000.0) / 1000.0;
    }

    public double getFlourAmount(){
        return roundToOneDecimal(persons * AmountFlourPerPerson);
    }
    public double getOliveOilAmount(){
        return roundToOneDecimal(persons * AmountOliveOilPerPerson);
    }
    public double getAmountWaterAmount(){
        return roundToOneDecimal(persons * AmountWaterPerPerson);
    }
    public double getYeastAmount(){
        return roundToOneDecimal(persons * AmountYeastPerPerson);
    }
    public double getSaltAmount(){
        return roundToOneDecimal(persons * AmountSaltPerPerson);
    }


}
