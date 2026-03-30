package com.dev.ecommerce.mappers;

import com.dev.ecommerce.DTOs.requests.ProductRequest;
import com.dev.ecommerce.DTOs.responses.ProductResponse;
import com.dev.ecommerce.entities.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

    public static Product toProductRequest(ProductRequest productRequest) {
        return Product
                .builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .description(productRequest.description())
                .imgURL(productRequest.imgURL())
                .build();
    }


    public static ProductResponse toProduct(Product product) {
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .imgURL(product.getImgURL())
                .build();
    }

}


