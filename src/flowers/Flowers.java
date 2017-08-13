package flowers;

abstract public class Flowers {
    private final float price;

    public Flowers(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

}
