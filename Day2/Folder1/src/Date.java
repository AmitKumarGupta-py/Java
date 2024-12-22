package com.myproject;
public class Date {
//variable Declaration

private int day;
private String month;
private int year;

//method declaration

public void setDate(int d,String m,int y)
{
	day = d;
	month = m;
	year = y;
}

public void displayDate(){
	System.out.println("Date: " + day + "/" + month + "/" + year);
}

}