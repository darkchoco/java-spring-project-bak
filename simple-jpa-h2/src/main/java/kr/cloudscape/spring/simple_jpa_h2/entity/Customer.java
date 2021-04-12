package kr.cloudscape.spring.simple_jpa_h2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // GenerationType.IDENTITY 지정을 해야 data.sql에서 id 값이 없어도
                                                         // 오류 없이 진행된다.
    private int id;
    private String name;
    @Column(length = 1024)  // 디폴트인 255 대신 1024로 길이 지정.
    private String address;
    private String primaryContact;  // 테이블에는 primary_contact 칼럼으로 지정되게 된다.
}
