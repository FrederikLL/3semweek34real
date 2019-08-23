package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bruger
 */
public class CustomerFacade {
    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {}

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }
    
    public Customer addCustomer(String firstname, String lastname){
        Customer customer = new Customer(firstname, lastname);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin(); //Opens DB transaction
            em.persist(customer); //manages(synchronizes) the code(entity) with the db.
            em.getTransaction().commit();
            return customer;
        }finally {
            em.close();//closes db connection
        }
    }
    
    public Customer findCustomer(long id){
         EntityManager em = emf.createEntityManager();
        try{
            Customer customer = em.find(Customer.class,id);
            return customer;
        }finally {
            em.close();
        }
    }
    public List<Customer> getAllCustomers(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = 
                       em.createQuery("Select customer from Customer customer",Customer.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }

    
}
