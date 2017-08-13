package order.UI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

abstract public class GraphicInterface {
    protected TextField rosesQuantity, chamomilesQuantity, tulipsQuantity;
    protected Button closeBTN, sellBTN;
    protected Label priceLabel = new Label("Price: 0.0"),
                addPriceLabel = new Label();

    protected Pane root;
    protected Scene scene;
    protected Stage stage;

    public GraphicInterface() {
        root = new Pane();
        scene = new Scene(root);
        stage = new Stage();
        setStage();
        drawPane();
        addLabel();
    }

    private void setStage(){
        scene.getStylesheets().add("style.css");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(350);
        stage.setTitle("New order");
    }

    private void drawPane(){
        ImageView background = new ImageView(new Image("file:order.jps"));
        ImageView saveIMG = new ImageView(new Image("file:save.png"));
        saveIMG.setTranslateX(240);
        saveIMG.setTranslateY(240);

        rosesQuantity = new TextField();
        chamomilesQuantity = new TextField();
        tulipsQuantity = new TextField();

        VBox vBox = new VBox();
        vBox.setTranslateX(50);
        vBox.setTranslateY(55);
        vBox.setMaxWidth(160);

        vBox.setSpacing(35);
        vBox.getChildren().addAll(rosesQuantity, tulipsQuantity, chamomilesQuantity);

        closeBTN = new Button("Close");
        sellBTN = new Button("Sell");

        HBox buttonz = new HBox(sellBTN, closeBTN);
        buttonz.setSpacing(15);
        buttonz.setTranslateX(60);
        buttonz.setTranslateY(300);

        priceLabel.setText("Price: 0.0");
        priceLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));
        priceLabel.setTextFill(Color.web("#696969"));
        priceLabel.setTranslateX(40);
        priceLabel.setTranslateY(230);

        root.getChildren().addAll(background, saveIMG,
                vBox, buttonz, priceLabel);
    }

    protected void addLabel() {
        addPriceLabel.setText(" + 150 to price");
        addPriceLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));
        addPriceLabel.setTextFill(Color.RED);
        addPriceLabel.setTranslateX(70);
        addPriceLabel.setTranslateY(250);
    }
}
