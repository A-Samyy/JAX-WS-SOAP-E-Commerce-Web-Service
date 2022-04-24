package gov.iti.jets.controller.impl;

import gov.iti.jets.controller.interfaces.ShoppingCartInt;
import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemGetDto;
import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemPostDto;
import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemRemoveDto;
import gov.iti.jets.domain.dtos.util.CartLineItemMapper;
import gov.iti.jets.service.impl.ShoppingCartServiceImpl;
import gov.iti.jets.service.interfaces.ShoppingCartServiceInt;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService( endpointInterface = "gov.iti.jets.controller.interfaces.ShoppingCartInt" )
public class ShoppingCartImpl implements ShoppingCartInt {
    ShoppingCartServiceInt serviceInt = new ShoppingCartServiceImpl();


    @Override
    public String addProductToCart( CartLineItemPostDto postDto ) {
        return serviceInt.addProductToCart( postDto.getUserId(), CartLineItemMapper.postToEntity( postDto ) );
    }


    @Override
    public String removeProductfromCart( CartLineItemRemoveDto removeDto ) {
        return serviceInt.removeProductfromCart( removeDto.getUserId(), removeDto.getProductId() );
    }


    @Override
    public List<CartLineItemGetDto> getUserCartitems( int id ) {
        List<CartLineItemGetDto>getDtos = new ArrayList<>();
        serviceInt.getUserCartitems( id ).forEach( cartLineItem -> getDtos.add( CartLineItemMapper.entityToGet( cartLineItem ) ) );
        return getDtos;
    }

    @Override
    public String orderItemsinShoppingCart( int userId ) {
        return serviceInt.orderItemsinShoppingCart( userId );
    }

}
