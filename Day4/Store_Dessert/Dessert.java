package Store_Dessert;
abstract class Dessert {
    abstract double calculatePrice(int quantity);
}

class Candy extends Dessert {
    private double pricePerKg;

    public Candy(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    double calculatePrice(int quantity) {
        return pricePerKg * quantity;
    }
}

class Cookie extends Dessert {
    private double pricePerDozen;

    public Cookie(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    double calculatePrice(int quantity) {
        return pricePerDozen * (quantity / 12.0);
    }
}

class IceCream extends Dessert {
    private double pricePerPiece;

    public IceCream(double pricePerPiece) {
        this.pricePerPiece = pricePerPiece;
    }

    @Override
    double calculatePrice(int quantity) {
        return pricePerPiece * quantity;
    }
}
