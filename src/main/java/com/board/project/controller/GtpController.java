package com.board.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.project.service.GtpApiService;
import com.board.project.dto.GtpDTO;
import com.board.project.dto.GtpDTO2;
import com.board.project.dto.MemberAdapter;
import com.board.project.entity.Member;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/whitelabel")
@RequiredArgsConstructor
public class GtpController {
		
	@Autowired
	GtpApiService gtpS;
		
	
	@PostMapping("/register2")
	public String qu(@AuthenticationPrincipal MemberAdapter memberAdapter,GtpDTO2 question ,Model model) {
		
		Member member = memberAdapter.getMember();
		
		model.addAttribute("texts",gtpS.callblog(question));
		System.out.println("@@@@@@@@@@"+model);
		model.addAttribute("member",member);
		
		return "/whitelabel/register2";
	}
	
	
	@GetMapping("/keyword2")
	public void keyword() {
		
	}

}
