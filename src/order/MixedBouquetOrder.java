package order;

public class MixedBouquetOrder extends Order {

    public void load(int roses, int chamomiles, int tulips){
        rosesQuantity.setText(Integer.toString(roses));
        chamomilesQuantity.setText(Integer.toString(chamomiles));
        tulipsQuantity.setText(Integer.toString(tulips));
        show();
        priceLabel.setText("Price: " + (roses*100 + chamomiles * 70 +
        tulips * 40));
    }
}
