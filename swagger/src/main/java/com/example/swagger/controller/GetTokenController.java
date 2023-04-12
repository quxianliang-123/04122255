package com.example.swagger.controller;

import java.security.Principal;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class GetTokenController {

	//	//　パラメタが使用してない
	//	@GetMapping(path = "/customers")
	//	public String customers(Model model) {
	//
	//		// TOKENをKEYCLOAKから取得する
	//		Authentication authToken = SecurityContextHolder.getContext().getAuthentication();
	//		Map<String, Object> attributes = new HashMap<>();
	//
	//		try {
	//			attributes = ((OAuth2AuthenticationToken) authToken).getPrincipal().getAttributes();
	//		} catch (Exception e) {
	//
	//			//エラーを投げる
	//			e.getMessage();
	//		}
	//
	//		// TOKENのpreferred_usernameをSTRINGで見る
	//		String a = attributes.get("preferred_username").toString();
	//
	//		System.out.println(a);
	//		return "customers";
	//	}

	//	@GetMapping("/userinfo")
	//	public String getUserInfo() {
	//			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
	//					.getRequest();
	//			KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) request
	//					.getUserPrincipal();
	//			KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal) keycloakAuthenticationToken
	//					.getPrincipal();
	//			String token = principal.getKeycloakSecurityContext().getIdTokenString();

	//		KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication()
	//				.getPrincipal();
	//		String userId = keycloakPrincipal.getKeycloakSecurityContext().getToken().getSubject();

	//		return "customers";
	//	}

	@GetMapping(value = "/")
	public String getHome(Object object) {
		return "index";
	}

	@GetMapping(value = "/home")
	public String getBooks(Model model, Principal a) {
		//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
		//				.getRequest();
		//		KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) request
		//				.getUserPrincipal();
		//		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal) keycloakAuthenticationToken
		//				.getPrincipal();
		//		String token = principal.getKeycloakSecurityContext().getIdTokenString();
		//		principala.get

		//		Authentication authToken = SecurityContextHolder.getContext().getAuthentication();
		//		Map<String, Object> attributes = new HashMap<>();
		//		//		if (authToken instanceof OAuth2AuthenticationToken) {
		//		try {
		//			attributes = ((OAuth2AuthenticationToken) authToken).getPrincipal().getAttributes();
		//		} catch (Exception e) {
		//
		//			e.getMessage();
		//		}

		KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();

		Principal principal = (Principal) authentication.getPrincipal();

		String userIdByToken = "";

		if (principal instanceof KeycloakPrincipal) {
			KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
			IDToken token = kPrincipal.getKeycloakSecurityContext().getIdToken();
			userIdByToken = token.getSubject();
		}

		System.out.println(userIdByToken);

		//
		//		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
		//		KeycloakPrincipal principala = (KeycloakPrincipal) token.getPrincipal();
		//		KeycloakSecurityContext session = principala.getKeycloakSecurityContext();
		//		AccessToken accessToken = session.getToken();
		//
		//		System.out.println(accessToken);
		return "home";
	}

	@GetMapping(value = "/test")
	public String getTest(Object object) {
		return "index";
	}

}
