package order;

public class TulipsOrder extends Order {
    public TulipsOrder() {
        super();
        setElements();
    }

    protected void setElements(){
        rosesQuantity.setDisable(true);
        chamomilesQuantity.setDisable(true);
    }
}
