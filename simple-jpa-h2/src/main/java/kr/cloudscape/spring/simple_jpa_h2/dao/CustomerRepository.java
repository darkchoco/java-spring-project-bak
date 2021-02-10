package kr.cloudscape.spring.simple_jpa_h2.dao;

import kr.cloudscape.spring.simple_jpa_h2.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByName(String name);

    List<Customer> findByNameLike(String name);

    List<Customer> findByNameLikeOrderByAddressDesc(String name);  // 정렬.

    List<Customer> findByNameAndAddress(String name, String address);  // AND

    List<Customer> findByNameOrAddress(String name, String address);  // OR

    // JPQL과는 틀리게 Customer.primaryContact 를 대상으로 할 때는 아래와 같이 primary_contact로 해야한다.
    @Query(value = "SELECT * FROM customer WHERE name = ?1 AND primary_contact = ?2", nativeQuery = true)
//    @Query("FROM Customer WHERE name = ?1 AND primaryContact = ?2")  // JPQL.
                                                                     // @Query 내에서는 테이블 명을 대문자로 시작하기.
    List<Customer> findVipList(String str1, String str2);
}
