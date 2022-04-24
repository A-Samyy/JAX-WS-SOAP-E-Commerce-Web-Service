package gov.iti.jets.controller.interfaces;

import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemGetDto;
import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemPostDto;
import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemRemoveDto;
import gov.iti.jets.domain.models.CartLineItem;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
@WebService(
        name = "UserManagement",
        portName = "ShoppingCartManagementPort",
        serviceName = "ShoppingCartManagementService" )
public interface ShoppingCartInt {
    @WebMethod( operationName = "addProductToCart" )
    public String addProductToCart(@WebParam( name = "cartLineItemPost" ) CartLineItemPostDto postDto );

    @WebMethod( operationName = "removeProductfromCart" )
    public String removeProductfromCart( @WebParam( name = "cartLineItemRemove" ) CartLineItemRemoveDto removeDto );

    @WebMethod( operationName = "getUserCartitems" )
    public List<CartLineItemGetDto> getUserCartitems(@WebParam( name = "userId" ) int id );

    @WebMethod( operationName = "orderItemsinShoppingCart" )
    public String orderItemsinShoppingCart(@WebParam( name = "userId" )int userId);
}
