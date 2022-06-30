package pe.edu.upc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.demo.ServiceImplements.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/img/**").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and()
				.exceptionHandling().accessDeniedPage("/error");
	}

	// http
	// .authorizeRequests()
	// .antMatchers(resources).permitAll()
	// .antMatchers("/","/index").permitAll()
	// .antMatchers("/admin*").access("hasRole('ADMIN')")
	// .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
	// .anyRequest().authenticated()
	// .and()
	// .formLogin()
	// .loginPage("/login")
	// .permitAll()
	// .defaultSuccessUrl("/menu")
	// .failureUrl("/login?error=true")
	// .usernameParameter("username")
	// .passwordParameter("password")
	// .and()
	// .logout()
	// .permitAll()
	// .logoutSuccessUrl("/login?logout");

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {

		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		//build.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("123")).roles("user").and()
				//.withUser("admin").password("admin").roles("USER", "ADMIN");

	}

	// build
	// .inMemoryAuthentication()
	// .withUser("123")
	// .password("password")
	// .roles("USER")
	// .and()
	// .withUser("admin")
	// .password("admin")
	// .roles("USER", "ADMIN");
}
