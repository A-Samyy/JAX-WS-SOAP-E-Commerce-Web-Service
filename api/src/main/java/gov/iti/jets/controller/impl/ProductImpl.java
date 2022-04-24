package gov.iti.jets.controller.impl;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.controller.interfaces.ProductInt;
import gov.iti.jets.domain.dtos.Product.ProductGetDto;
import gov.iti.jets.domain.dtos.Product.ProductPostDto;
import gov.iti.jets.domain.dtos.Product.ProductPutDto;
import gov.iti.jets.domain.dtos.util.ProductMapper;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.service.impl.ProductServiceImpl;
import gov.iti.jets.service.interfaces.ProductServiceInt;
import jakarta.jws.WebService;

@WebService(endpointInterface = "gov.iti.jets.controller.interfaces.ProductInt")
public class ProductImpl implements ProductInt {
    ProductServiceInt si = new ProductServiceImpl();

    @Override
    public List<ProductGetDto> getProducts() {
        List<ProductGetDto> getDtos = new ArrayList<>();
        si.getProducts().forEach( product -> getDtos.add( ProductMapper.entityToGet( product ) ) );
        return  getDtos;
    }

    @Override
    public ProductGetDto getProduct(int id) {
        return ProductMapper.entityToGet( si.getProduct(id) );
    }

    @Override
    public List<String> getCategories() {
        return si.getCategories();
    }

    @Override
    public List<ProductGetDto> getCategoryProducts(Category category) {
        List<ProductGetDto> getDtos = new ArrayList<>();
        si.getCategoryProducts(category).forEach( product -> getDtos.add( ProductMapper.entityToGet( product ) ) );
        return getDtos;
    }

    @Override
    public String createProduct( ProductPostDto product) {
        return si.createProduct(ProductMapper.postToEntity( product ) );
    }

    @Override
    public String updateProduct( ProductPutDto product) {
        return si.updateProduct(ProductMapper.putToEntity( product ) );
    }

    @Override
    public String deleteProduct(int id) {
        return si.deleteProduct(id);
    }
}
