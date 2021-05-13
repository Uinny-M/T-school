package clinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


//    @Override
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, enabled "
//                        + " FROM employee WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT username, role "
//                        + " FROM employee WHERE username = ?")
//                .passwordEncoder(passwordEncoder());

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("user")
                .password(passwordEncoder().encode("password")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login**", "/logout**", "/assets/**", "/employee/*").anonymous()
                .antMatchers("/cases/*",  "/event/*", "/patient/*", "/prescription/*")
                .hasAnyRole("ADMIN", "DOCTOR", "NURSE")
                .antMatchers("/login**", "/logout**").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin().permitAll()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)

                .and()
                .logout()
                .logoutUrl("/")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
