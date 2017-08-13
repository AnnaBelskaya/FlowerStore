package store;

import flowers.Chamomile;
import flowers.Flowers;
import flowers.Roses;
import flowers.Tulip;

public class FlowerStore {
    private float wallet;
    private float price;

    public FlowerStore() {
        this.wallet = 0;
    }

    public Flowers[] sell(int roses, int chamomiles, int tulips) {
        Flowers[] bouquet = new Flowers[roses + chamomiles + tulips];
        for (int i = 0; i < bouquet.length; i++) {
            if (roses > 0) {
                bouquet[i] = new Roses();
                roses--;
            } else {
                if (chamomiles > 0){
                    bouquet[i] = new Chamomile();
                    chamomiles--;
                } else {
                    bouquet[i] = new Tulip();
                    tulips--;
                }
            }
        }
        return bouquet;
    }

    public Flowers[] sellSequence(int roses, int chamomiles, int tulips) {
        int i = 0;
        Flowers[] bouquet = new Flowers[roses + chamomiles + tulips];
        while (i < bouquet.length){
            if (i < bouquet.length && roses > 0){
                roses--;
                bouquet[i++] = new Roses();
            }
            if (i < bouquet.length && chamomiles > 0){
                chamomiles--;
                bouquet[i++] = new Chamomile();
            }
            if (i < bouquet.length && tulips > 0){
                tulips--;
                bouquet[i++] = new Tulip();
            }
        }
        return bouquet;
    }

    public float countIncome(Flowers[] bouquet){
        price = 0;
        for (int i = 0; i < bouquet.length; i++){
            price += bouquet[i].getPrice();
        }
        return price;
    }

    public void addArrangementPrice(float arrangementPrice){
        price+=arrangementPrice;
    }
/*
    public float getPrice() {
        return price;
    }

    public void addMoneyToWallet(){
        wallet+=price;
    }

    public float getWallet() {
        return wallet;
    }*/
}
