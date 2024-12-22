package Day10;
import java.util.Date;
import java.util.ArrayList;

public final class Car {
    private final String make;
    private final String model;
    private final Date mandate;
    private final List<String> colors;

    public Car(String make, String model, Date mandate, List<String> colors) {
        super();
        this.make = make;
        this.model = model;
        this.mandate = new Date(mandate.getDay(), mandate.getMonth(), mandate.getYear());
        List<String> temp = new ArrayList<>();
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) {
            temp.add(it.next());
            
        }
        this.colors = temp;

    
}

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
    
    public Date getMandate() {
        return new Date(mandate.getDay(), mandate.getMonth(), mandate.getYear());
    }
    
    public ArrayList<String> getColors() {
        return (ArrayList<String>)colors.clone();
    }

    @Override
    public String toString() {
        return "Car [make=" + make + ", model=" + model + ", mandate=" + mandate + ", colors=" + colors + "]";
    }


}

