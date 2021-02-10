package kr.cloudscape.spring.simple_jpa_h2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(length = 1024)
    private String address;
    private String primaryContact;  // 테이블에는 primary_contact 칼럼으로 지정되게된다.
}
