package gov.iti.jets.controller.interfaces;

import java.util.List;

import gov.iti.jets.domain.dtos.User.UserGetDto;
import gov.iti.jets.domain.dtos.User.UserPostDto;
import gov.iti.jets.domain.dtos.User.UserPutDto;
import gov.iti.jets.domain.dtos.order.OrderGetDto;
import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(
        name = "UserManagement",
        portName = "UserManagementPort",
        serviceName = "UserManagementService" )
public interface UserInt {
    @WebMethod(operationName = "getUsers")
    public List<UserGetDto> getUsers();

    @WebMethod(operationName = "getUserbyId")
    public UserGetDto getUser(@WebParam( name = "userId" )int id);

    @WebMethod(operationName = "getUserOders")
    public List<OrderGetDto> getUserOrders(@WebParam( name = "userId" ) int id);

    @WebMethod(operationName = "createUser")
    public String createUser(@WebParam( name = "user" ) UserPostDto postDto);

    @WebMethod(operationName = "updateUser")
    public String updateUser(@WebParam( name = "userPut" ) UserPutDto putDto);

    @WebMethod(operationName = "deleteUser")
    public String deleteUser(@WebParam( name = "userId" ) int id);
}
