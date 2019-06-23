package com.quixada.ufc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.quixada.ufc.security.UserDetailsImplements;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsImplements userDetailsImplements;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/cliente/").permitAll()
		.antMatchers("/cliente/formulario").permitAll()
		.antMatchers("/cliente/cadastrar").permitAll()
//		//gerente
		.antMatchers("/cliente/listarClientes").permitAll()
		.antMatchers("/cliente/excluir/{codigo}").permitAll()
		.antMatchers("/cliente/atualizar/{codigo}").permitAll()

//		
//		//gerente GERAL
		.antMatchers("/gerente/formularioGerente").hasRole("GERENTE_GERAL")
		.antMatchers("/gerente/cadastrar").hasRole("GERENTE_GERAL")
//		.antMatchers("/gerente/listarGerente").permitAll()
//		.antMatchers("/gerente/atualizar/{codigo}").permitAll()
//		
//		//gerente/gerente GERAL
//		.antMatchers("/prato/formPrato").hasRole("GERENTE");
//		.antMatchers("/prato/cadastrarPrato").permitAll()
//		.antMatchers("/prato/listarPratos").permitAll()
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/logar")//.defaultSuccessUrl("/gerente/formularioGerente").permitAll()
		.permitAll()
		
		
		.and()
		.logout()
		.logoutSuccessUrl("/usuario/logar?logout")
		.permitAll();
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(userDetailsImplements).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**","/js/**","/img/**");
		
	}
	
}	
