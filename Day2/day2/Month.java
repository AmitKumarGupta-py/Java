package day2;

public enum Month
{
JANUARY("JAN"),FEBUARY("FEB"),MARCH("MAR"),APRIL("APR"),MAY("MAY"),JUNE("JUN"),JULY("JUL"),AUGUST("AUG"),SEPTEMBER("SEPT"),OCTOBER("OCT"),NOVEMBER("NOV"),DECEMBER("DEC");
   
String months;
private Month(String months)
    {
        this.months = months;
    }

    public String getMonth()
    {
        return months;
    }
}
