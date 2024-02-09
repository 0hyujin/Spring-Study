package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address address = new Address("city", "street", "dd");

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeaddress(address);
            em.persist(member);

            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setHomeaddress(member.getHomeaddress());
            em.persist(member2);

            member.getHomeaddress().setCity("newCity");

            tx.commit();
        } catch (Exception e) {
            // tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}
