package gov.iti.jets.domain.dtos.util;

import gov.iti.jets.domain.dtos.Product.ProductGetDto;
import gov.iti.jets.domain.dtos.Product.ProductPostDto;
import gov.iti.jets.domain.dtos.Product.ProductPutDto;
import gov.iti.jets.domain.models.Product;

public class ProductMapper {
    public static ProductGetDto entityToGet( Product entity){
        return new ProductGetDto( entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantity(), entity.getCategory());
    }

    public static Product postToEntity( ProductPostDto postDto){
        return new Product( postDto.getName(), postDto.getDescription(), postDto.getPrice(), postDto.getQuantity(),  postDto.getCategory());
    }
    public static Product putToEntity( ProductPutDto putDto){
        return new Product( putDto.getId(), putDto.getName(), putDto.getDescription(), putDto.getPrice(), putDto.getQuantity(), putDto.getCategory());
    }

}
