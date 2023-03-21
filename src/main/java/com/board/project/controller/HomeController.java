package com.board.project.controller;

import com.board.project.entity.Member;
import com.board.project.role.SessionConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConstants.NORM_MEM, required = false)
                       Member loginMember, Model model, HttpServletRequest request) {
        if(loginMember == null) {
            return "main/index";
        }
        //세션이 유지되면 다시 홈으로 보낸다.
        model.addAttribute("member",loginMember);

        //어노테이션 없는 일반 세션 코드 적용..
        HttpSession session = request.getSession(false);
        if(session!= null) {
            return "main/index";
        }
        Member loginMember2 = (Member) session.getAttribute(SessionConstants.NORM_MEM);
        //세션 정보가 없으면 다시 홈으로..
        if(loginMember2!= null) {
            return "main/index";
        }

        model.addAttribute("member",loginMember2);

        return "main/index";
    }
}
