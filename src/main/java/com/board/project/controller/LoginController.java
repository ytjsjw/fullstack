package com.board.project.controller;

import com.board.project.dto.LoginDTO;
import com.board.project.dto.MemberDTO;
import com.board.project.entity.Member;
import com.board.project.role.SessionConstants;
import com.board.project.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequiredArgsConstructor
public class LoginController {

    //Service
    private final LoginService loginService;

    //아래의 모든 매핑에서는 여러분이 응요할 수 잇도록 요청 패턴과 이에 대응하는
    //Viewer 를 지금까지 했던것과는 틀리게 처리 하였으니, 필요시 응용하세요.
    @GetMapping("/login/loginPage")
    public String loginForm(@ModelAttribute MemberDTO memberDTO) {
        //Viewer 매핑

        return "login/loginPage";
    }
    //아래에서는 못보던 @ 이 좀 나옵니다.
    //일단 Validate(필드 검증), 서비스 수행후 결과 바인딩되는 BindingResult(보통은 결과가
//    비정상적인 경우 오류 메세지 출력용으로 사용됨) 등입니다.
    @PostMapping("/login/loginPage")
    public String login(@ModelAttribute MemberDTO memberDTO
            , BindingResult bindingResult
            , @RequestParam(defaultValue = "/") String redirectURL
            , HttpServletRequest request) {

        //해당 사용자가 없거나, 인증 오류등이 발생한 경우
        //BindingResult 이 해당 오류에 대한 내용을 바인딩함..따라서 이를 이용해서
        //분기 시킴..
//        if (bindingResult.hasErrors()) {
//            return "login/loginForm";//로그인폼 바인딩시킴.
//        }

        //로그인한 Member 객체 얻어내기.
        Member loginMember = loginService.login(memberDTO.getLoginId(), memberDTO.getPassword());

        //멤버객체가 NULL 인경우. BindingResult 에 에러 메세지 추가
        if(loginMember == null) {

            System.out.println("++++++++++++++++"+loginMember+"++++++++++++++");
//            bindingResult.reject("Failed Login","ID 또는 비번이 틀립니다.");
            return "login/loginPage";
        }

        //이 영역은 테스트 후 등록된 사용자라면 세션을 적용할 예정입니다.
        //세션객체를 얻어냅니다. session 객체는 HttpServletRequest 객체를 통해 얻어냅니다.
        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.NORM_MEM, loginMember);

        return "redirect:" + redirectURL;

    }

    @PostMapping("/session/logout")
    public String logout(HttpServletRequest httpServletRequest) {
        //HTTP 세션을 아예 만들지 못하도록 getSession(false) 로 준다.
        //만약 true 로 주면 세션이 없을 경우 새로운 세션을 생성한다.
        //만약 세션이 없을 경우엔 null 리턴함..
        HttpSession session = httpServletRequest.getSession(false);

        //세션에 물린 모든 정보들을 무효화 하는 메서드는 invalidate() 임.
        //이것만 호출 하면 모두 무효화 처리됩니다.
        if(session!= null) {
            session.invalidate();
        }

        return "redirect:/";
    }


}