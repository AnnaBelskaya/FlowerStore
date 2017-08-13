package order;

public class RosesOrder extends Order {
    public RosesOrder() {
        super();
        setElements();
    }

    protected void setElements(){
        tulipsQuantity.setDisable(true);
        chamomilesQuantity.setDisable(true);
    }
}
