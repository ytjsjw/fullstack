package com.board.project.service;

import com.board.project.entity.Member;
import com.board.project.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

	private final LoginRepository loginRepository;

	public Member login(String loginId, String password) {

		return loginRepository.findByLoginId(loginId)
				.filter(m->m.getPassword().equals(password)).orElse(null);
	}
}