package order;

import file.FlowerSaver;
import flowers.Flowers;
import store.MainMenu;

public class ExclusiveBouquet extends Order {

    @Override
    protected void sellBTNClicked() {
        Flowers[] bouquet = flowerStore.sellSequence(getRQuantity(),
                getCQuantity(), getTQuantity());
        FlowerSaver.save(flowerStore.sell(getRQuantity(),
                getCQuantity(), getTQuantity()), root);
        rosesQuantity.clear();
        chamomilesQuantity.clear();
        tulipsQuantity.clear();
        double income = flowerStore.countIncome(bouquet) +
                Double.parseDouble(MainMenu.wallet.getText()) + 150;
        MainMenu.wallet.setText(Double.toString(income));
    }

    @Override
    protected void addLabel() {
        super.addLabel();
        root.getChildren().add(addPriceLabel);
    }

}