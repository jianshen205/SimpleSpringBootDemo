package com.ccgg.SpringBootRestDemo.beans;

import javax.persistence.*;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-04 11:26
 **/

@Entity
@Table(name="ccgg_product")
public class Product {
    //todo: entity 都要加这个id吗
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "CCGG_PRODUCT_SEQ")
    private Integer id;

    @Column(name = "productPrice", nullable = false)
    private Integer productPrice;

    @Column(name = "productName", nullable = false)
    private String productName;

    public Product() {
    }


    public Product(Integer productPrice, String productName) {
        this.productPrice = productPrice;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productPrice=" + productPrice +
                ", productName='" + productName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
