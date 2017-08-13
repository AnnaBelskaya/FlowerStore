package order;

public class ChamomilesOrder extends Order{
    public ChamomilesOrder() {
        super();
        setElements();
    }

    protected void setElements(){
        tulipsQuantity.setDisable(true);
        rosesQuantity.setDisable(true);
    }
}
