package mypack;

public class calender{
	public static void main(String[] args){
		Date d = new Date();

		d.setDate(12,"Dec",2000);
		d.displayDate();
		
		Date d1 = new Date();
		d1.setDay(11);
		d1.setMonth("Jan");
		d1.setYear(2024);
		
		
		System.out.println(d1);
	}
}
