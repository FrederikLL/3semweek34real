/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruger
 */
public class FacadeRunner {
    public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
    CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
    Customer c1 = facade.addCustomer("Knud","den store");
    Customer c2 = facade.addCustomer("Alex","the great");//begge kan ses i DB
    //Find book by ID
    System.out.println("Customer1: " + facade.findCustomer(c1.getId()));//toString virker pt. ikke i mit netbeans
    System.out.println("Customer2: "+facade.findCustomer(c2.getId()));// så vi modtager kun referencer for disse to
    //Find all books
    System.out.println("Number of Customer: "+facade.getAllCustomers().size());

    }
    
}
