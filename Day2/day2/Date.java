package day2;
public class Date {


private int day;
private String month;
private int year;



public void setDate(int d,String m,int y)
{
	this.day = d;
	this.month = m;
	this.year = y;
}

public void displayDate(){
	System.out.println("Date: " + day + "/" + month + "/" + year);
}



public String toString()
{
	return day + "/" + month + "/" + year;
}

}