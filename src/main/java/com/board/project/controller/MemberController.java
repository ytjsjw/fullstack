package com.board.project.controller;

import com.board.project.dto.MemberDTO;
import com.board.project.entity.Member;
import com.board.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/login/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {
    	return "/login/join";
    }
    
    @PostMapping("/login/join")
    public String joinProc(@ModelAttribute MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
    	log.info("회원가입 요청");
    	Member number = memberService.dtoToEntity(memberDTO);
    	
    	redirectAttributes.addFlashAttribute("msg",number);
    	return "redirect:/login/loginPage";
    	
    }  

}
