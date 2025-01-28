package org.example.service;

import org.example.model.Customer;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartService {

    private final Map<Customer, List<Product>> cart = new HashMap<>();

    public void putToCart(Customer customer, Product product) {
        List<Product> customerProductList = cart.get(customer);
        System.out.println("Клиент: " + customer + " продукт: " + product);
        if (customerProductList == null) {
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            cart.put(customer, productList);
        } else {
            if (!customerProductList.contains(product)) {
                customerProductList.add(product);
            }
        }
    }

    public List<Product> getCustomerCart(Customer customer) {
        return cart.get(customer);
    }
}
