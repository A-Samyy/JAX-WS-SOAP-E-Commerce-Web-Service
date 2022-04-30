package gov.iti.jets.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import gov.iti.jets.domain.dtos.User.UserGetDto;
import gov.iti.jets.domain.dtos.util.UserMapper;
import gov.iti.jets.domain.models.*;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.ShoppingCartRepository;
import gov.iti.jets.repository.UserRepository;
import gov.iti.jets.service.interfaces.UserServiceInt;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@WebService( endpointInterface = "gov.iti.jets.service.interfaces.EmployeeServiceInt" )
public class UserServiceImpl implements UserServiceInt {
    EntityManagerFactory emf;
    EntityManager em;
    UserRepository ur;
    OrderRepository or;
    ShoppingCartRepository shoCartRepo;

    @Override
    public List<UserGetDto> getUsers() {
        ur = createUserRepo();
        List<UserGetDto> getDtos = new ArrayList<>();
        List<User> findAll = ur.findAll();
        if(findAll.size() != 0){
            findAll.forEach( user -> {
                getDtos.add(  UserMapper.entityToGet( user ));
                System.out.println("Controlllerrrr  ******"+user);
            } );
            cleaningup();
            return getDtos;
        }
        else{
            return null;
        }
    }

    @Override
    public User getUser( int id ) {
        ur = createUserRepo();
        Optional<User> findOne = ur.findOne( id );
        cleaningup();
        return findOne.get();
    }

    @Override
    public List<Order> getUserOrders( int userId ) {
        or = createOrdersRepo();
        List<Order> findAllByUserId = or.findAllByUserId( userId );
        cleaningup();
        return findAllByUserId;
    }

    @Override
    public String createUser( User user ) {
        try {
            ur = createUserRepo();
            shoCartRepo = new ShoppingCartRepository( em );
            var tr = em.getTransaction();
            tr.begin();
            ur.create( user );
            tr.commit();

            ShoppingCart shoppingCart = new ShoppingCart();
            user.setShoppingCart( shoppingCart );

            tr.begin();
            shoCartRepo.create( shoppingCart );
            tr.commit();

            cleaningup();
            return "User is added";
        } catch ( Exception e ) {
            return "Error! User can not be added";
        }
    }

    @Override
    public String updateUser( User user ) {
        try {
            ur = createUserRepo();
            var tr = em.getTransaction();
            tr.begin();
            ur.update( user );
            tr.commit();
            cleaningup();
            return "User is updated";
        } catch ( Exception e ) {
            return "Error! User can not be added";
        }
    }

    @Override
    public String deleteUser( int id ) {
        try {
            ur = createUserRepo();
            shoCartRepo = new ShoppingCartRepository( em );
            or = new OrderRepository( em );
            var tr = em.getTransaction();
            try {
                List<Order> orders = or.findAllByUserId( id );
                tr.begin();
                orders.forEach( order -> or.delete( order ) );
                tr.commit();

            } catch ( Exception e ) {
                System.out.println( "no orders for user" );
            }
            try {
                ShoppingCart shoppingCart = ur.findShoppingCartbyUserId( id );
                tr.begin();
                shoCartRepo.delete( shoppingCart );
                tr.commit();
            } catch ( Exception e ) {
                System.out.println( "no shopping cart for user" );
            }
            tr.begin();
            ur.deleteById( id );
            tr.commit();
            cleaningup();
            return "User is deleted";
        } catch ( Exception e ) {
            e.printStackTrace();
            return "Error! In deleting User";
        }

    }


    private UserRepository createUserRepo() {
        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new UserRepository( em );
    }

    private ShoppingCartRepository createShoppingRepo() {
        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new ShoppingCartRepository( em );
    }

    private OrderRepository createOrdersRepo() {

        emf = Persistence.createEntityManagerFactory( "api" );
        em = emf.createEntityManager();
        return new OrderRepository( em );
    }

        private void cleaningup() {
            emf.close();
            em.close();
        }

}