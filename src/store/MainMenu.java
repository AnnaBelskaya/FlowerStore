package store;

import file.FlowerLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import order.*;


public class MainMenu {
    public static Label wallet = new Label("0.0");

    private Stage stage;
    private Pane root;
    private Scene scene;
    private ImageView imageView =
            new ImageView(new Image("file:mainbackground.jps"));


    public MainMenu(Stage stage) {
        this.stage = stage;
        sceneBuilder();
        addBtns();
    }

    private void sceneBuilder(){
        root = new Pane();
        root.getChildren().add(imageView);
        scene = new Scene(root);
        scene.getStylesheets().add("buttonStyle.css");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:icon.png"));
        stage.setResizable(false);
        stage.show();
    }

    private void addBtns(){
        Button rosesBTN = new Button("\n\n\nRoses");
        rosesBTN.setOnMouseClicked(event -> rosesBTNClicked());
        rosesBTN.setMinSize(160,160);

        Button chamomilesBTN = new Button("\n\n\nChamomiles");
        chamomilesBTN.setOnMouseClicked(event -> chamomilesBTNclicked());
        chamomilesBTN.setMinSize(160,160);

        Button tulipsBTN = new Button("\n\n\nTulips");
        tulipsBTN.setOnMouseClicked(event -> tulipsBTNclicked());
        tulipsBTN.setMinSize(160,160);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(rosesBTN, chamomilesBTN, tulipsBTN);
        hBox1.setSpacing(80);

        Button mixedBTN = new Button("\n\n\nMixed");
        mixedBTN.setOnMouseClicked(event -> mixedBTNclicked());
        mixedBTN.setMinSize(160,160);

        Button bouquetBTN = new Button("\n\n\n Exclusive\n bouquets");
        bouquetBTN.setTextAlignment(TextAlignment.CENTER);
        bouquetBTN.setOnMouseClicked(event -> bouquetBTNclicked());
        bouquetBTN.setMinSize(160,160);

        Button loadFileBTN = new Button("\n\n\nLoad\norder details");
        loadFileBTN.setTextAlignment(TextAlignment.CENTER);
        loadFileBTN.setOnMouseClicked(event -> loadFile());
        loadFileBTN.setMinSize(160,160);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(mixedBTN, bouquetBTN, loadFileBTN);
        hBox2.setSpacing(80);

        VBox vBox = new VBox();
        vBox.setSpacing(54);
        vBox.setTranslateX(90);
        vBox.setTranslateY(150);

        vBox.getChildren().addAll(hBox1, hBox2);

        wallet.setTranslateX(65);
        wallet.setTranslateY(70);
        wallet.setTextFill(Color.web("ffcc00"));
        wallet.setFont(new Font(14));

        root.getChildren().addAll(wallet, vBox);
    }

    public void rosesBTNClicked(){
        new RosesOrder().show();
    }

    public void chamomilesBTNclicked(){
        new ChamomilesOrder().show();
    }

    public void tulipsBTNclicked(){
        new TulipsOrder().show();
    }

    public void mixedBTNclicked(){
        new MixedBouquetOrder().show();
    }

    public void bouquetBTNclicked(){
        new ExclusiveBouquet().show();
    }

    public void loadFile(){
        FlowerLoader.open();
    }
}
