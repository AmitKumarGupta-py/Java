package ToyCompany;

public abstract class Toy {
    private String productId;
    private String name;
    private double price;
    private String age; 
    private int purchaseMonth;
    private int purchaseYear;
    private String category; 
    private double rating; 

    public Toy(String productId, String name, double price, String age, int purchaseMonth, int purchaseYear, String category, double rating) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.age = age;
        this.purchaseMonth = purchaseMonth;
        this.purchaseYear = purchaseYear;
        this.category = category;
        this.rating = rating;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAge() {
        return age;
    }

    public int getPurchaseMonth() {
        return purchaseMonth;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public abstract String getToyType(); 

    @Override
    public String toString() {
        return getToyType() + "{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", age='" + age + '\'' +
                ", purchaseMonth=" + purchaseMonth +
                ", purchaseYear=" + purchaseYear +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                '}';
    }
}
