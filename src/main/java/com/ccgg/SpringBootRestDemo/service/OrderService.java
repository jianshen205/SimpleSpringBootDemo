package com.ccgg.SpringBootRestDemo.service;

import com.ccgg.SpringBootRestDemo.beans.*;
import com.ccgg.SpringBootRestDemo.dao.OrderDao;
import com.ccgg.SpringBootRestDemo.dao.UserDao;
import com.ccgg.SpringBootRestDemo.http.Response;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-05 09:43
 **/
@Service
@Transactional
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserDao userDao;

    public Response createOrder(ArrayList<ItemQuantity> items){
        Order newOrder = new Order();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails) principal).getUsername();
            newOrder.setUserId(userDao.findByUsername(username).getId());
            //todo check if product item_id exists

            newOrder.setItems(items);


            System.out.println(newOrder);
            System.out.println(newOrder.getItems().size());
            orderDao.save(newOrder);

            return new Response(true,"create order successfully!");
        }
        return new Response(false,"fail to create order");
    }


    public Response deleteOrder(int id){
        if (orderDao.existsById(id)) {
            orderDao.deleteById(id);
            return new Response(true);
        } else {
            return new Response(false, "order is not found!");
        }
    }

    public Response updateOrder(ItemQuantityOrderIdWrapper itemQuantityOrderIdWrapper){
        //todo user only be able to update his own orders.

        ArrayList<ItemQuantity> items = itemQuantityOrderIdWrapper.getItemQuantities();

        Integer id = itemQuantityOrderIdWrapper.getId();

        Order order = orderDao.findById(id).get();

        order.setItems(items);
//        Order updatedOrder = new Order(items);
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(principal instanceof UserDetails){
//            String username = ((UserDetails) principal).getUsername();

//            updatedOrder.setUserId(userDao.findByUsername(username).getId());

//            updatedOrder.setId(id);

            System.out.println(order);
            orderDao.save(order);

            return new Response(true,"update order successfully!");
//        }
//        return new Response(false, "fail to update order ");

    }

    public Response getOrder(Integer id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        if(hasAdminRole){
            return orderDao.existsById(id)?
                    new Response(true, orderDao.findById(id).get().toString()):
                    new Response(false, "no order with corresponding order id found");
        }else{
            Object principal = authentication.getPrincipal();
            Integer userId = 0;
            if(principal instanceof UserDetails){
                String username = ((UserDetails) principal).getUsername();

                userId = userDao.findByUsername(username).getId();
            }
            if(orderDao.existsById(id)){
                if(orderDao.findById(id).get().getUserId() == userId){
                   return new Response(true, orderDao.findById(id).get().toString());
                }else{
                    return new Response(false, "no access authorized");
                }
            }
        }
        return new Response(false,"fail to get order");
    }

}
