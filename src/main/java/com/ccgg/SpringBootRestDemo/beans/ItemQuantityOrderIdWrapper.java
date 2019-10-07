package com.ccgg.SpringBootRestDemo.beans;

import java.util.ArrayList;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-05 18:40
 **/
public class ItemQuantityOrderIdWrapper {
    private Integer id;
    private ArrayList<ItemQuantity> itemQuantities;

    public ItemQuantityOrderIdWrapper(Integer id, ArrayList<ItemQuantity> itemQuantities) {
        this.id = id;
        this.itemQuantities = itemQuantities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<ItemQuantity> getItemQuantities() {
        return itemQuantities;
    }

    public void setItemQuantities(ArrayList<ItemQuantity> itemQuantities) {
        this.itemQuantities = itemQuantities;
    }
}
