package com.board.project.service;

import com.board.project.dto.MemberDTO;
import com.board.project.entity.Member;
import com.board.project.entity.MemberRole;
import com.board.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private static long seq = 0;

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public Member dtoToEntity(MemberDTO memberDTO){

        Member member = Member.builder()
                .loginId(memberDTO.getLoginId())
                .password(passwordEncoder.encode(memberDTO.getPassword()))
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .phone(memberDTO.getPhone())
                .addr(memberDTO.getAddr())
                .detailaddr(memberDTO.getDetailaddr())
                .path(memberDTO.getPath())
                .recomm(memberDTO.getRecomm())
                .regDate(memberDTO.getRegDate())
                .modDate(memberDTO.getModDate())
                .build();

        member.addMemberRole(MemberRole.ADMIN);

        member.setId(++seq);

        memberRepository.save(member);


        return member;

    }
}
