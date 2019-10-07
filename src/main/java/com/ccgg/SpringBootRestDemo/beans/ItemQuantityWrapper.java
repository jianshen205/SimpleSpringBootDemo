package com.ccgg.SpringBootRestDemo.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-05 15:30
 **/


public class ItemQuantityWrapper {
    private ArrayList<ItemQuantity> itemQuantities;

    public ArrayList<ItemQuantity> getItemQuantities() {
        return itemQuantities;
    }

    public void setItemQuantities(ArrayList<ItemQuantity> itemQuantities) {
        this.itemQuantities = itemQuantities;
    }

    @Override
    public String toString() {
        return "ItemQuantityWrapper{" +
                "itemQuantities=" + itemQuantities +
                '}';
    }
}
