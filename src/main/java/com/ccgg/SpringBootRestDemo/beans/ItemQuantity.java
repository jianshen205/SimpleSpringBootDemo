package com.ccgg.SpringBootRestDemo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-04 22:54
 **/
@Component
public class ItemQuantity implements Serializable {

//    private static final long serialVersionUID = 1L;
    /**
     * order_id
     */
//    @Id
//    private int id;

//    @Column(name="item_id", nullable = false)
    private Integer item_id;

//    @Column(name = "quantity", nullable = false)
    private Integer quantity;



    public ItemQuantity() {
        super();
    }

    public ItemQuantity(Integer item_idd) {
        super();
        this.item_id = item_idd;
    }

    public ItemQuantity(Integer item_id, Integer quantity) {
        this.item_id = item_id;
        this.quantity = quantity;
    }


    public ItemQuantity(Integer id, Integer item_id, Integer quantity) {
//        this.id = id;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemQuantity{" +
//                "id=" + id +
                "item_id=" + item_id +
                ", quantity=" + quantity +
                '}';
    }

//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
