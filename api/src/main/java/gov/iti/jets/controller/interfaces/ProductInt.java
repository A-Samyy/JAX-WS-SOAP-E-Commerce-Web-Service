package gov.iti.jets.controller.interfaces;

import java.util.List;

import gov.iti.jets.domain.dtos.Product.ProductGetDto;
import gov.iti.jets.domain.dtos.Product.ProductPostDto;
import gov.iti.jets.domain.dtos.Product.ProductPutDto;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(
        name = "ProductManagement",
        portName = "ProductManagementPort",
        serviceName = "ProductManagementService" )
public interface ProductInt {
    @WebMethod(operationName = "getProducts")
    public List<ProductGetDto> getProducts();

    @WebMethod(operationName = "getProductbyId")
    public ProductGetDto getProduct(@WebParam( name = "productId" )int id);

    @WebMethod(operationName = "getCategories")
    public List<String> getCategories();

    @WebMethod(operationName = "getCategoryProducts")
    public List<ProductGetDto> getCategoryProducts(@WebParam( name = "category" )Category category);

    @WebMethod(operationName = "createProduct")
    public String createProduct(@WebParam( name = "productPost" ) ProductPostDto product);

    @WebMethod(operationName = "updateProduct")
    public String updateProduct( @WebParam( name = "productPut" )ProductPutDto product);

    @WebMethod( operationName = "deleteProduct")
    public String deleteProduct(@WebParam( name = "productId" )int id);
}
