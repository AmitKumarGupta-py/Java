package Day10;

public class Contact {
    // program to save name and phone number  of the user.
    private String name;
    private String phone_no;

    public Contact(String name, String phone_no){
        this.name = name;
        this.phone_no = phone_no;
    }

    public String getName(){
        return name;
    }

    public String getphone_no(){
        return phone_no;
    }

    public void setname(String new_name){
        this.name = new_name;
    } 

    public void setphone_no(String new_phone_no){
        this.phone_no = new_phone_no;
    }

    public String toString(){
        return "Name: " + name + ", Phone Number: " + phone_no;
    }
}
