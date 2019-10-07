package com.ccgg.SpringBootRestDemo.controller;

import com.ccgg.SpringBootRestDemo.beans.Product;
import com.ccgg.SpringBootRestDemo.http.Response;
import com.ccgg.SpringBootRestDemo.service.ProductService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-04 11:41
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //todo  what's diff btw pathVariable and requestBody?


    /**
     * add product
     * @param product
     * @return
     */
    @PostMapping
    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN')")
    public Response addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    /**
     * update product price or name
     * @param product
     * @return
     */
    @PutMapping
    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN')")
    public Response updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


    /**
     * delete product
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN')")
    public Response deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }


    /**
     * retrieve product details
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public Response getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }


}
