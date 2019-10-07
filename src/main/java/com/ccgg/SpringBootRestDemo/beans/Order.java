package com.ccgg.SpringBootRestDemo.beans;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-04 11:27
 **/
@Entity
@Table(name = "ccgg_order")
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "SEQ")
    @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "CCGG_ORDER_SEQ")
    private Integer id;


    /**
     * user <-->  order
     */
    @Column(name = "user_id", nullable = false)
    private Integer userId;


    /**
     * product_item <--> order
     */
//
//    @OneToMany(fetch = FetchType.EAGER)
////    @LazyCollection(LazyCollectionOption.FALSE)//todo the problem is that the JPA annotations are parsed not to allow more than 2 eagerly loaded collection. But the hibernate-specific annnotations allow it.
//    @JoinTable(name = "c_order_c_itemQuantity", joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "itemQuantity_id", referencedColumnName = "id")})
//    private List<ItemQuantity> items = new ArrayList<>();

    @Column(name="items", nullable = false, length = 10000)
    private ArrayList<ItemQuantity> items = new ArrayList<>();

    public Order() {
        super();
    }

    //remark:
    //怎么区分是id 还是userid?
    //multiple constructors with same data type is not allowed.
    public Order(Integer id) {
        super();
        this.id = id;
        this.items = items;
        this.userId = userId;
    }


//    public Order(Integer userId) {
//        super();
//        this.userId = userId;
//        this.items = items;//todo 即使参数没出现,也要在这里赋值..why?
//        this.id=id;
//    }


    public Order(Integer userId, ArrayList<ItemQuantity> items) {
        super();
        this.userId = userId;
        this.items = items;
        this.id=id;
    }

    public Order(ArrayList<ItemQuantity> items) {
        super();
        this.items = items;
        this.id=id;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public CcggUser getUser() {
//        return user;
//    }
//
//    public void setUser(CcggUser user) {
//        this.user = user;
//    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ArrayList<ItemQuantity> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemQuantity> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", items=" + items +
                '}';
    }
}
