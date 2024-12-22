

public abstract class Toy {
    private String productId;
    private String name;
    private double price;
    private String ageGroup; 
    private int purchaseMonth;
    private int purchaseYear;
    private String category;
    private double rating;

    public Toy(String productId, String name, double price, String ageGroup, int purchaseMonth, int purchaseYear, String category, double rating) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non-negative.");
        }
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5.");
        }
        if (ageGroup == null || ageGroup.trim().isEmpty()) {
            throw new IllegalArgumentException("Age group must not be null or empty.");
        }
        if (purchaseMonth < 1 || purchaseMonth > 12) {
            throw new IllegalArgumentException("Purchase month must be between 1 and 12.");
        }
        if (purchaseYear < 0) {
            throw new IllegalArgumentException("Purchase year must be non-negative.");
        }

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
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

    public String getAgeGroup() {
        return ageGroup;
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
                ", ageGroup='" + ageGroup + '\'' +
                ", purchaseMonth=" + purchaseMonth +
                ", purchaseYear=" + purchaseYear +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Toy)) return false;
        Toy toy = (Toy) obj;
        return productId.equals(toy.productId);
    }

    @Override
    public int hashCode() {
        return productId.hashCode();
    }
}
