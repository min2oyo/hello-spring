package hello.hellospring.domain;

import javax.persistence.*;

@Entity // JPA가 관리함
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성
    private Long id;

//    @Column(name = "username")  // 테이블 컬럼명이 "username"일 경우
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
