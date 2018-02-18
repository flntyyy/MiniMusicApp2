package staff;

public class Pencil extends Staff {
private String size;
    public Pencil(String brand, String price, String size) {
        super(brand, price);
        this.size = size
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
