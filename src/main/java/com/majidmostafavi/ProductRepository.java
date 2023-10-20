package com.majidmostafavi;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@RequestScoped
public class ProductRepository  implements PanacheMongoRepository<Product> {

    public Product findByName(String name){
        return find("name", name).firstResult();
    }
    public Product findByCode(String code){
        return find("code", code).firstResult();
    }
    public List<Product> findOrderedByName(){
        return findAll(Sort.by("code")).list();
    }

}
