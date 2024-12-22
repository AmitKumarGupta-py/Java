package ToyCompany;

import java.util.Comparator;

public class RatingComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Double.compare(toy1.getRating(), toy2.getRating());
    }
}
