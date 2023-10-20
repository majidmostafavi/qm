package com.majidmostafavi;


import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;


@MongoEntity(collection = "product")
public class Product extends PanacheMongoEntity {

    public String name;
    public  String code;
    public String price;

    public Product() {
    }

    public Product(String name, String code, String price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }
}
