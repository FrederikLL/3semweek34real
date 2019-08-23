package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruger
 */
public class EntityTested {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Customer c1 = new Customer();
        //System.out.println(b1.toString());
            Customer c2 = new Customer("Fred","Turbo");
            Customer c3 = new Customer("Ahmed","O");
            Customer c4 = new Customer("Emil", "H");
        try{
            
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            em.getTransaction().commit();
            
            
        }finally{
            em.close();
        }
    }
    
}
