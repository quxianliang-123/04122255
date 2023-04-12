//package com.example.swagger.config;
//
//import org.keycloak.adapters.KeycloakConfigResolver;
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//import org.springframework.security.web.session.HttpSessionEventPublisher;
//
////@Configuration
////@EnableWebSecurity
////public class KeycloakConfig {
//
////	@Bean
////	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////		http.authorizeRequests()
////				.antMatchers("/**")
////				.permitAll()
////				.anyRequest()
////				.authenticated();
////
////		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
////		return http.build();
////	}
////
////	@Bean
////	public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
////		return new KeycloakSpringBootConfigResolver();
////	}
//
////}
//
////@KeycloakConfiguration
////public class KeycloakConfig extends KeycloakWebSecurityConfigurerAdapter {
////
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder auth) {
////		SimpleAuthorityMapper grantedAuthorityMapper = new SimpleAuthorityMapper();
////		grantedAuthorityMapper.setPrefix("ROLE_");
////
////		KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
////		keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(grantedAuthorityMapper);
////		auth.authenticationProvider(keycloakAuthenticationProvider);
////	}
////
////	@Bean
////	@Override
////	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
////		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
////	}
////
////	@Bean
////	@Override
////	@ConditionalOnMissingBean(HttpSessionManager.class)
////	protected HttpSessionManager httpSessionManager() {
////		return new HttpSessionManager();
////	}
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		super.configure(http);
////		http
////				.authorizeRequests()
////				.antMatchers("/home").hasRole("aaa")
////				.anyRequest().permitAll();
////
////		//		http.csrf().disable();
////
////		http.httpBasic().disable();
////	}
////}
////
////@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(jsr250Enabled = true)
////public class KeycloakConfig extends KeycloakWebSecurityConfigurerAdapter {
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		super.configure(http);
////		http.authorizeRequests()
////				.anyRequest()
////				.permitAll();
////		http.csrf().disable();
////	}
////
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
////		keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
////		auth.authenticationProvider(keycloakAuthenticationProvider);
////	}
////
////	@Bean
////	@Override
////	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
////		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
////	}
////
////	@Bean
////	public KeycloakConfigResolver KeycloakConfigResolver() {
////		return new KeycloakSpringBootConfigResolver();
////	}
////}
//
//@KeycloakConfiguration
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
//@EnableWebSecurity
//public class KeycloakConfig extends KeycloakWebSecurityConfigurerAdapter {
//
//	/**
//	 * 复用spring boot 的方法
//	 *
//	 * @return the keycloak config resolver
//	 */
//	@Bean
//	public KeycloakConfigResolver keycloakConfigResolver() {
//		return new KeycloakSpringBootConfigResolver();
//	}
//
//	//	/**
//	//	 * 自己写解析
//	//	 *
//	//	 * @return the keycloak config resolver
//	//	 */
//	//	//    @Bean
//	//	public KeycloakConfigResolver fileKeycloakConfigResolver() {
//	//		return request -> {
//	//			// json 文件放到resources 文件夹下
//	//			ClassPathResource classPathResource = new ClassPathResource("./keycloak.json");
//	//			AdapterConfig adapterConfig = null;
//	//			try {
//	//				adapterConfig = new ObjectMapper().readValue(classPathResource.getFile(),
//	//						AdapterConfig.class);
//	//			} catch (IOException e) {
//	//				e.printStackTrace();
//	//			}
//	//
//	//			return KeycloakDeploymentBuilder.build(adapterConfig);
//	//		};
//	//	}
//
//	/**
//	 *  配置{@link AuthenticationManager}
//	 *  这里会引入Keycloak的{@link AuthenticationProvider}实现
//	 *
//	 * @param auth the auth
//	 */
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) {
//		KeycloakAuthenticationProvider authenticationProvider = keycloakAuthenticationProvider();
//		authenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//		auth.authenticationProvider(authenticationProvider);
//	}
//
//	/**
//	 * 会话身份验证策略
//	 */
//	@Bean
//	@Override
//	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//	}
//
//	/**
//	 * 配置 session 监听器 保证单点退出生效
//	 *
//	 * @return the servlet listener registration bean
//	 */
//	@Bean
//	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
//		return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
//		http.authorizeRequests()
//				.antMatchers("/**").hasRole("app-user")
//				.anyRequest().permitAll();
//		http.csrf().disable();
//	}
//}
