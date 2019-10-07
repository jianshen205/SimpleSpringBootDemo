package com.ccgg.SpringBootRestDemo.controller;

import com.ccgg.SpringBootRestDemo.beans.*;
import com.ccgg.SpringBootRestDemo.http.Response;
import com.ccgg.SpringBootRestDemo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-05 09:42
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;


    /**
     * create new order
     * @param wrapper
     * @return
     */
    @PostMapping
    @PreAuthorize(value = "hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public Response createOrder(@RequestBody ItemQuantityWrapper wrapper){
        return orderService.createOrder(wrapper.getItemQuantities());
    }

    /**
     * delete an order
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN')")
    public Response deleteOrder(@PathVariable Integer id){
        return orderService.deleteOrder(id);
    }


    /**
     *update an order details
     * @param itemQuantityOrderIdWrapper
     * @return
     */
    @PutMapping
    @PreAuthorize(value = "hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public Response updateOrder(@RequestBody ItemQuantityOrderIdWrapper itemQuantityOrderIdWrapper){

        //todo notes:这里json里直接传wrapper里的fields

        return orderService.updateOrder(itemQuantityOrderIdWrapper);
    }


    /**
     * get order details
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public Response getOrder(@PathVariable Integer id){
        //todo show total price
        return orderService.getOrder(id);
    }








}
