package Store_Dessert;
class Cart {
    private static final int MAX_ITEMS = 100; 
    private Dessert[] desserts;
    private int[] quantities;
    private double totalPrice;
    private int itemCount;

    public Cart() {
        desserts = new Dessert[MAX_ITEMS];
        quantities = new int[MAX_ITEMS];
        totalPrice = 0.0;
        itemCount = 0;
    }

    public void addToCart(Dessert dessert, int quantity) {
        
        for (int i = 0; i < itemCount; i++) {
            if (desserts[i].getClass().getSimpleName().equals(dessert.getClass().getSimpleName())) {
                quantities[i] += quantity;
                totalPrice += dessert.calculatePrice(quantity);
                return;
            }
        }

        
        if (itemCount < MAX_ITEMS) {
            desserts[itemCount] = dessert;
            quantities[itemCount] = quantity;
            totalPrice += dessert.calculatePrice(quantity);
            itemCount++;
        } else {
            System.out.println("Cart is full! Cannot add more items.");
        }
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        for (int i = 0; i < itemCount; i++) {
            System.out.printf("%s: %d units - %.2f%n", 
                desserts[i].getClass().getSimpleName(), 
                quantities[i], 
                desserts[i].calculatePrice(quantities[i]));
        }
        System.out.printf("Total: %.2f%n", totalPrice);
    }
}
