package order;

import file.FlowerSaver;
import flowers.Chamomile;
import flowers.Flowers;
import flowers.Roses;
import flowers.Tulip;
import order.UI.GraphicInterface;
import store.FlowerStore;
import store.MainMenu;

abstract public class Order extends GraphicInterface{
    protected double price = 0;

    protected FlowerStore flowerStore;

    public Order() {
        flowerStore = new FlowerStore();
    }

    public void show(){
        setActions();
        addListeners();
        stage.show();
    }

    private void setActions(){
        closeBTN.setOnMouseClicked(event -> stage.close());
        sellBTN.setOnMouseClicked(event -> sellBTNClicked());
    }


    protected void sellBTNClicked(){
        Flowers[] bouquet = flowerStore.sell(getRQuantity(),
                getCQuantity(),getTQuantity());
        FlowerSaver.save(flowerStore.sell(getRQuantity(),
                getCQuantity(),getTQuantity()), root);
        rosesQuantity.clear();
        chamomilesQuantity.clear();
        tulipsQuantity.clear();
        double income = flowerStore.countIncome(bouquet) +
                Double.parseDouble(MainMenu.wallet.getText());
        MainMenu.wallet.setText(Double.toString(income));
    }

    protected int getRQuantity(){
        try {
            return Integer.parseInt(rosesQuantity.getText());
        } catch (NumberFormatException e){
            return 0;
        }
    }

    protected int getCQuantity(){
        try {
            return Integer.parseInt(chamomilesQuantity.getText());
        } catch (NumberFormatException e){
            return 0;
        }
    }

    protected int getTQuantity(){
        try {
            return Integer.parseInt(tulipsQuantity.getText());
        } catch (NumberFormatException e){
            return 0;
        }
    }

    protected void addListeners(){
        rosesQuantity.textProperty().addListener((observable, oldValue, newValue) -> count());
        chamomilesQuantity.textProperty().addListener((observable, oldValue, newValue) -> count());
        tulipsQuantity.textProperty().addListener((observable, oldValue, newValue) -> count());
    }

    protected void count(){
        price = getRQuantity()* new Roses().getPrice() +
                getCQuantity()*new Chamomile().getPrice() +
                getTQuantity()*new Tulip().getPrice();
        priceLabel.setText("Price: " + price);
    }
}