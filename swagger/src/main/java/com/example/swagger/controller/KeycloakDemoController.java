package com.example.swagger.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@SpringBootApplication
public class KeycloakDemoController {
	//	
	//    @Autowired
	//    private SecurityAuthenticationProvider securityAuthenticationProvider;
	//	
	//	@Autowired
	//	private KeycloakClient KeycloakClient;
	//
	//
	//	@GetMapping(path = "/")
	//	public String index() {
	//		return "external";
	//	}

	@PostMapping(path = "/customers")
	public String customers(@RequestBody Map<String, Object> requestBody) {

		Authentication authToken = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> attributes = new HashMap<>();
		//		if (authToken instanceof OAuth2AuthenticationToken) {
		try {
			attributes = ((OAuth2AuthenticationToken) authToken).getPrincipal().getAttributes();
		} catch (Exception e) {

			e.getMessage();
		}

		String a = attributes.get("preferred_username").toString();

		System.out.println(a);

		//		} else if (authToken instanceof JwtAuthenticationToken) {
		//			attributes = ((JwtAuthenticationToken) authToken).getTokenAttributes();
		//		}

		//		 String response = getAccessToken();
		//		 System.out.println(response);

		//		String userId = (String) requestBody.get("userId");
		//		
		//		System.out.println(userId);

		//		KeycloakClient.excute();
		return "customers";
	}

	//	@Autowired
	//	private RestTemplate restTemplate;

	//	@GetMapping("/tologinpage")
	//	public String toprocessLogin(Model model) {
	//		model.addAttribute("userSearchRequest", new UserSearchRequest());
	//		return "login";
	//	}

	//	@GetMapping("/testGetApi")
	//	public String getJson() {
	//		String url = "http://localhost:8080/realms/SpringBootKeycloak/protocol/openid-connect/token";

	//		HttpHeaders headers = new HttpHeaders();
	//        headers.set("Authorization", "Bearer {token}");
	//		ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, map, String.class);
	//		String json = results.getBody();

	//		 String response = getAccessToken();

	//		
	//
	//		return response;

}
//
//	@PostMapping("/loginfunction")
//	public String processLogin(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
//
//		model.addAttribute(user);
//		return "home";
//
//	}

//}
