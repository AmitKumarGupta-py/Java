package ToyCompany;

import java.util.Comparator;

public class ProductIdComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getProductId().compareTo(toy2.getProductId());
    }
}
