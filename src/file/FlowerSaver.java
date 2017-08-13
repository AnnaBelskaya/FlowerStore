package file;

import flowers.Flowers;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

abstract public class FlowerSaver {
    private static String file = "files\\report.txt";

    public static void save(Flowers[] bouquet, Pane root){
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            Date date = new Date();
            for (int i = 0; i < bouquet.length; i++){
                if (i==0){
                    out.write(date.toString() + "\n");
                }
                out.write(bouquet[i].getClass().getSimpleName() + " ");
            }
            out.write("\n" + date.toString() + "\n");
            out.write("---------------------\n");
            fileSaved(root);
        } catch (IOException e) {

        }

    }

    private static void fileSaved(Pane root){
        ImageView checkmark = new ImageView(new Image("file:checkmark.png"));
        checkmark.setTranslateX(230);
        checkmark.setTranslateY(250);
        root.getChildren().add(checkmark);
    }
}
