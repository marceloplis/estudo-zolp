package br.com.zolp.estudozolp.controller;

import br.com.zolp.estudozolp.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

/**
 *  Controller teste de login.
 *
 * @author mamede
 * @version 0.0.1-SNAPSHOT
 */@RestController
public class UserController {

	@RequestMapping("/login")
	public boolean login(@RequestBody User user) {
		return user.getUserName().equals("user") && user.getPassword().equals("pass");
	}

	@RequestMapping("/user")
	public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	}
}
