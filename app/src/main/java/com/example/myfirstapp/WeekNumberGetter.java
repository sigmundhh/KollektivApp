package com.example.myfirstapp;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class WeekNumberGetter {
    private Calendar now;

    public WeekNumberGetter(){
        this.now = new GregorianCalendar();
    }

    public int getWeekNumber(){
        return now.get(Calendar.WEEK_OF_YEAR);
    }

}
