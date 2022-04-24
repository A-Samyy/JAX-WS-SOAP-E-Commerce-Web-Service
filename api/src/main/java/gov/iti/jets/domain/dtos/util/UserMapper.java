package gov.iti.jets.domain.dtos.util;

import gov.iti.jets.domain.dtos.User.UserGetDto;
import gov.iti.jets.domain.dtos.User.UserPostDto;
import gov.iti.jets.domain.dtos.User.UserPutDto;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.service.impl.UserServiceImpl;
import gov.iti.jets.service.interfaces.UserServiceInt;

public class UserMapper {
    public static UserGetDto entityToGet( User entity ) {
        UserGetDto getDto = new UserGetDto( entity.getId(), entity.getName(), entity.getEmail(), entity.getPhoneNumber(), entity.getPassword(), entity.getRole(), entity.getShoppingCart().get() );
        return getDto;
    }

    public static User postToEntity( UserPostDto postDto ) {
        User entity = new User( postDto.getName(), postDto.getEmail(), postDto.getPhoneNumber(), postDto.getPassword() );
        String role = postDto.getRole().toUpperCase();
        switch ( role ) {
            case "ADMIN":
                entity.setRole( Role.ADMIN );
                break;
            case "CLERK":
                entity.setRole( Role.CLERK );
                break;
            case "CUSTOMER":
                entity.setRole( Role.CUSTOMER );
                break;
            default:
                entity.setRole( Role.CUSTOMER );
                break;
        }


        return entity;
    }
    public static User putToEntity( UserPutDto putDto ) {
        UserServiceInt serviceInt = new UserServiceImpl();
        User entity = serviceInt.getUser( putDto.getId() ) ;
        entity.setName( putDto.getName() );
        entity.setEmail( putDto.getEmail() );
        entity.setPhoneNumber( putDto.getPhoneNumber() );
        entity.setPassword( putDto.getPassword() );
        return entity;
    }
}
