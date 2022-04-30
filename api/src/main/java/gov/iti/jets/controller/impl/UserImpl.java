package gov.iti.jets.controller.impl;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.controller.interfaces.UserInt;
import gov.iti.jets.domain.dtos.User.UserGetDto;
import gov.iti.jets.domain.dtos.User.UserPostDto;
import gov.iti.jets.domain.dtos.User.UserPutDto;
import gov.iti.jets.domain.dtos.order.OrderGetDto;
import gov.iti.jets.domain.dtos.util.OrderMapper;
import gov.iti.jets.domain.dtos.util.UserMapper;
import gov.iti.jets.service.impl.UserServiceImpl;
import gov.iti.jets.service.interfaces.UserServiceInt;
import jakarta.jws.WebService;

@WebService( endpointInterface = "gov.iti.jets.controller.interfaces.UserInt" )
public class UserImpl implements UserInt {
    UserServiceInt serviceInt = new UserServiceImpl();

    @Override
    public List<UserGetDto> getUsers() { 
        return  serviceInt.getUsers();
    }

    @Override
    public UserGetDto getUser( int id ) {
        return UserMapper.entityToGet(serviceInt.getUser( id ));
    }

    @Override
    public List<OrderGetDto> getUserOrders( int id ) {
        List<OrderGetDto> getDtos = new ArrayList<>();
        serviceInt.getUserOrders( id ).forEach( order -> {
            getDtos.add( OrderMapper.entityToGetDto( order ) );
        } );
        return getDtos;
    }

    @Override
    public String createUser( UserPostDto postDto ) {
        return serviceInt.createUser( UserMapper.postToEntity(  postDto ));
    }

    @Override
    public String updateUser( UserPutDto putDto ) {
        return  serviceInt.updateUser( UserMapper.putToEntity( putDto ) );
    }

    @Override
    public String deleteUser( int id ) {
        return serviceInt.deleteUser( id );
    }


}