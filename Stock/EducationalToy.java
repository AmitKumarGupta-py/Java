

public class EducationalToy extends Toy {
    private String subject;

    public EducationalToy(String productId, String name, double price, String ageGroup, 
                          int purchaseMonth, int purchaseYear, String category, 
                          double rating, String subject) {
        super(productId, name, price, ageGroup, purchaseMonth, purchaseYear, category, rating);
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty.");
        }
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty.");
        }
        this.subject = subject;
    }

    @Override
    public String getToyType() {
        return "EducationalToy";
    }

    @Override
    public String toString() {
        return "EducationalToy{" +
                super.toString() +
                ", subject='" + subject + '\'' + 
                '}';
    }
}
