package day2;
public enum Flavour
{
    CHOCOLATE(120), MINT(100), CREAM(90);
    int price;
    private Flavour(int price)
    {
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }
}