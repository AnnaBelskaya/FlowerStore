package file;

import flowers.Chamomile;
import flowers.Flowers;
import flowers.Roses;
import flowers.Tulip;
import order.MixedBouquetOrder;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Scanner;

abstract public class FlowerLoader {
    private static String file = "files\\order.txt";

    public static void open(){
        try {
            int r = 0, t = 0, c = 0;
            FileReader reader = new FileReader(file);
            Scanner sc = new Scanner(reader);
            String[] order = sc.nextLine().split(" ");
            Flowers[] bouquet = new Flowers[order.length];
            for (int i = 0; i < order.length; i++){
                if (order[i].equals("Roses")){
                    bouquet[i] = new Roses();
                    r++;
                } else {
                    if (order[i].equals("Chamomile")){
                        bouquet[i] = new Chamomile();
                        c++;
                    } else {
                        bouquet[i] = new Tulip();
                        t++;
                    }
                }
            }
            new MixedBouquetOrder().load(r, c, t);
        } catch (FileNotFoundException e) { }
    }
}
