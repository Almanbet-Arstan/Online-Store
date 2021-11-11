package com.example.onlinestore.controller;

import com.example.onlinestore.entity.Product;
import com.example.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteById(@PathVariable Long id){
        return productService.deleteById(id);
    }

//    public void buyItems(List<Product> products, Long userId) {
//        Order order = new Order();
//
//        User user = new User(); //получить по userId
//        order.setUser(user);
//
//        for(Product product : products) {
//            order.setTotalSum(order.getTotalSum() + product.getPrice());
//        }
//        //orderService.saveOrder(order); --> id = 1;
//
//        for(Product product : products) {
//            UserProduct userProduct = new UserProduct();
//
//            userProduct.setProduct(product);
//            userProduct.setUser(user);
//            userProduct.setOrder(order);
//
//            //userProductService.save(userProduct)
//        }
//
////        считаем сумму for each product in products
////        orderService.save(order) -- сохранили order и теперь знаем его ID
////        опять проходимся по продуктам и сохраняем в таблицу user_products, userId, product.getId, order.getId
//
//        return; //orderId
//    }
//
//    public void getByOrderId(Long orderId) {
//
//        //getAllUserProductsByOrderId;
//
//
//    }
}
