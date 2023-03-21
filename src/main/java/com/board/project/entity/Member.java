package com.board.project.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "MEMBER")
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String addr;
    private String detailaddr;
    private String path;
    private String recomm;
    private LocalDateTime regDate, modDate;


    private boolean fromSocial;

    @ElementCollection(fetch = FetchType.LAZY)
    //위에서처럼 Collection 으로 생성시엔 반드시 Builder.default() @ 을 사용해야 합니다.
    @Builder.Default
    //사용자 권한 값을 담는 Set 객체 생성
    private Set<MemberRole> roleset = new HashSet<>();

    //멤버에 권한부여 메서드 정의
    public void addMemberRole(MemberRole memberRole){
        roleset.add(memberRole);
    }

}
