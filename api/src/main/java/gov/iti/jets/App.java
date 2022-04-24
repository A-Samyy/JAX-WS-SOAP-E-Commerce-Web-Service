package gov.iti.jets;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import gov.iti.jets.controller.impl.ProductImpl;
import gov.iti.jets.controller.impl.ShoppingCartImpl;
import gov.iti.jets.controller.impl.UserImpl;
import gov.iti.jets.controller.interfaces.ProductInt;
import gov.iti.jets.controller.interfaces.ShoppingCartInt;
import gov.iti.jets.controller.interfaces.UserInt;
import gov.iti.jets.domain.dtos.User.UserPostDto;
import gov.iti.jets.domain.dtos.util.UserMapper;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.service.impl.ProductServiceImpl;
import gov.iti.jets.service.impl.ShoppingCartServiceImpl;
import gov.iti.jets.service.impl.UserServiceImpl;
import gov.iti.jets.service.interfaces.ProductServiceInt;
import gov.iti.jets.service.interfaces.ShoppingCartServiceInt;
import gov.iti.jets.service.interfaces.UserServiceInt;
import jakarta.persistence.*;

public class App {
    public static void main( String[] args ) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("api");
         EntityManager em = emf.createEntityManager();
//        UUID uuid = UUID.randomUUID();
//        System.out.println(em.find( User.class , 15 )  ) ;
        // List<String> cats = new ArrayList<>();
        // for (Category cat : Category.values()) {
        //         cats.add(cat.name());
        // }

        //   ProductServiceInt int1 = new ProductServiceImpl();
        // System.out.println(int1.getCategories());
        // System.out.println(int1.getCategoryProducts(Category.WHITE_CHOCOLATE));
        // System.out.println(int1.getProduct(2));
        // System.out.println(int1.getProducts());


        // System.out.println(int1.createProduct(new Product("test", "this is a test", 10, 100, Category.DRINKS)));
        //        System.out.println(int1.updateProduct(new Product(94,"update test", "this is a test", 10, 110, Category.DRINKS)));
        //     System.out.println(int1.deleteProduct(95));

//        UserServiceImpl usi = new UserServiceImpl();
////            System.out.println( usi.addProductToCart(15 , new CartLineItem( int1.getProduct(2), 5 )  ) );
//     //  User user= usi.getUser( 18 );
////       user.setEmail( "Aya@hotmail.com" );
////            System.out.println( user);
//            System.out.println(usi.getUser( 15 ));
//          // System.out.println(usi.getUsers());
//        User us = usi.getUser( 97 );
//        us.setPhoneNumber( "01111111111" );
////        System.out.println( usi.updateUser( us ) );
//        System.out.println( usi.getUserOrders( us.getId() ) );
//        UserPostDto postDto = new UserPostDto("Samy","samy@gmail.com","111111","1111","admin");
//        System.out.println(UserMapper.postToEntity( postDto ));


//        UserInt userInt = new UserImpl();
//        userInt.createUser( new UserPostDto("Abdalla Samy", "abdalla@gmail.com", "011155544772" , "1234" , "clerk") );

//        UserServiceInt serviceInt = new UserServiceImpl();
//        serviceInt.createUser( UserMapper.postToEntity(  new UserPostDto("Islam Samy", "islam@gmail.com", "011155544772" , "1234" , "clerk") )  );
    //    User u = new User( "Islam Samy", "islam@gmail.com", "011155544772", "1234", Role.CLERK );
      //  serviceInt.createUser(u);

//        ShoppingCartInt cartInt =new ShoppingCartImpl();
//        System.out.println(cartInt.getUserCartitems( 13 ));

//        ShoppingCartServiceInt serviceInt = new ShoppingCartServiceImpl();
//        System.out.println(serviceInt.getUserCartitems( 13 ));

        Query query= em.createQuery( "select c.cartLineItems from ShoppingCart c where c.id = :shoppingCardId" );
        query.setParameter( "shoppingCardId",102);
        List<CartLineItem> items =query.getResultList();
        System.out.println( items );

         em.close();
         emf.close();
    }
}
