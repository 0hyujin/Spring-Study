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

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeaddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("햄버거");

            member.setHomeaddress(new Address("old1", "street", "10000"));
            member.setHomeaddress(new Address("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("==========START==========");
            Member findMember = em.find(Member.class, member.getId());
//
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory){
//                System.out.println("address.getCity() = " + address.getCity());
//            }
            
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            // homeCity -> newCity
            Address a = findMember.getHomeaddress();
            findMember.setHomeaddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            // 치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));

            tx.commit();
        } catch (Exception e) {
            // tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}
