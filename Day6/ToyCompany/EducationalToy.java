package ToyCompany;

public class EducationalToy extends Toy {
    private String subject;

    public EducationalToy(String productId, String name, double price, String age, int purchaseMonth, int purchaseYear, String category, double rating, String subject) {
        super(productId, name, price, age, purchaseMonth, purchaseYear, category, rating);
        this.subject = subject;
    }

    @Override
    public String getToyType() {
        return "EducationalToy";
    }

    @Override
    public String toString() {
        return super.toString() + ", subject='" + subject + '\'' + '}';
    }
}
