package com.majidmostafavi;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

import java.util.List;

@Path("/products")
@RequestScoped
public class ProductResource {

    @Inject
    private ProductRepository productRepository;

    @POST
    public Response create(Product product) {
        productRepository.persist(product);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Product product) {
        product.id = new ObjectId(id);
        productRepository.update(product);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        Product product = productRepository.findById(new ObjectId(id));
        productRepository.delete(product);
    }

    @GET
    @Path("/{id}")
    public Product get(@PathParam("id") String id) {
        return productRepository.findById(new ObjectId(id));
    }

    @GET
    public List<Product> list() {
        return productRepository.listAll();
    }

    @GET
    @Path("/orderedByName")
    public List<Product> listAllOrderedByName() {
        return productRepository.findOrderedByName();
    }

    @GET
    @Path("/search/{name}")
    public Product search(@PathParam("name") String name) {
        return productRepository.findByName(name);
    }

    @GET
    @Path("/count")
    public Long count() {
        return productRepository.count();
    }


}
