package test.herokut.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Builder
    public Member(String name) {
        this.name = name;
    }

    public Member() {

    }
}
