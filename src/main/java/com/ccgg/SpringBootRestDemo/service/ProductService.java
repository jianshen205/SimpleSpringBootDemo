package com.ccgg.SpringBootRestDemo.service;

import com.ccgg.SpringBootRestDemo.beans.Product;
import com.ccgg.SpringBootRestDemo.dao.ProductDao;
import com.ccgg.SpringBootRestDemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-04 11:43
 **/

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public Response addProduct(Product product){
        productDao.save(product);
        System.out.println(product);
        return new Response(true);
    }

    public Response deleteProduct(Integer id){
        if(productDao.existsById(id)){
            productDao.deleteById(id);
            return new Response(true);
        }else{
            return new Response(false, "product not found, fail to delete");
        }
    }

    public Response updateProduct(Product product){
        Integer id = product.getId();
        //findById() return Optional.empty if is null
        if(productDao.existsById(id)){
            productDao.save(product);
            return new Response(true);
        }else{
            return new Response(false, "product not exists, fail to update");
        }
    }

    public Response getProduct(Integer id){
        if(!productDao.findById(id).equals(Optional.empty())){
            // 用 optional.get() 返回找到的结果.
            Product product = productDao.findById(id).get();
            String msg = product.toString();
            return new Response(true, msg);
        }else{
            return new Response(false, "product not found");
        }
    }
}
