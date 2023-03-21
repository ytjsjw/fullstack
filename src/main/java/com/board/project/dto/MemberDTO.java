package com.board.project.dto;

import java.time.LocalDateTime;

import com.board.project.entity.SNSMemberRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
@ToString
public class MemberDTO {
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String addr;
    private String detailaddr;
    private String path;
    private String recomm;
    private SNSMemberRole role;
    private LocalDateTime regDate, modDate;


}
