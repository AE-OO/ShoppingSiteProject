package com.example.boardproject.dto;

import com.example.boardproject.entity.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private int pId;
    private String pName;


    //entity -> dto
    public static ProductDTO entityToDto(Product product) {
        ProductDTO dto = ProductDTO.builder()
                .pId(product.getPId())
                .pName(product.getPName())
                .build();

        return dto;
    }

    //dto -> entity
    public static Product DtoToEntity(ProductDTO dto){
        Product entity = Product.builder()
                .pId(dto.getPId())
                .pName(dto.getPName())
                .build();

        return entity;
    }
}
