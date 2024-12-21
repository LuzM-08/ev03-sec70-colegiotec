package cl.ipss.api.eva03.apieva03.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request ->
        request.requestMatchers("api/estudiante/practica/crear")
        .permitAll()
        .requestMatchers("api/estudiante/practica/listar")
        .permitAll()
        .requestMatchers("api/docente/practica/crear")
        .authenticated()
        .requestMatchers("api/docente/practica/listar")
        .authenticated()
        .requestMatchers("api/docente/practica/buscar/{id}")
        .authenticated()
        .requestMatchers("api/docente/practica/actualizar/{id}")
        .authenticated()
        .requestMatchers("api/docente/practica/eliminar/{id}")
        .authenticated()
        .requestMatchers("api/docente/docente/crear")
        .authenticated()
        .requestMatchers("api/docente/docente/listar")
        .authenticated()
        .requestMatchers("api/docente/docente/buscar/{id}")
        .authenticated()
        .requestMatchers("api/docente/docente/actualizar/{id}")
        .authenticated()
        .requestMatchers("api/docente/docente/eliminar/{id}")
        .authenticated()
        .requestMatchers("api/docente/estudiante/crear")
        .authenticated()
        .requestMatchers("api/docente/estudiante/listar")
        .authenticated()
        .requestMatchers("api/docente/estudiante/buscar/{id}")
        .authenticated()
        .requestMatchers("api/docente/estudiante/actualizar/{id}")
        .authenticated()
        .requestMatchers("api/docente/estudiante/eliminar/{id}")
        .authenticated()
        .requestMatchers("api/docente/registro/crear")
        .authenticated()
        .requestMatchers("api/docente/registro/listar")
        .authenticated()
        .requestMatchers("api/docente/registro/buscar/{id}")
        .authenticated()
        .requestMatchers("api/docente/registro/actualizar/{id}")
        .authenticated()
        .requestMatchers("api/docente/registro/eliminar/{id}")
        .authenticated()
        .requestMatchers("api/docente/empresa/crear")
        .authenticated()
        .requestMatchers("api/docente/empresa/listar")
        .authenticated()
        .requestMatchers("api/docente/empresa/buscar/{id}")
        .authenticated()
        .requestMatchers("api/docente/empresa/actualizar/{id}")
        .authenticated()
        .requestMatchers("api/docente/empresa/eliminar/{id}")
        .authenticated()
        .requestMatchers("api/docente/jefe/crear")
        .authenticated()
        .requestMatchers("api/docente/jefe/listar")
        .authenticated()
        .requestMatchers("api/docente/jefe/buscar/{id}")
        .authenticated()
        .requestMatchers("api/docente/jefe/actualizar/{id}")
        .authenticated()
        .requestMatchers("api/docente/jefe/eliminar/{id}")
        .authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService testUser(PasswordEncoder PasswordEncoder){
        User.UserBuilder user = User.builder();
        UserDetails user1 = user.username("docente")
        .password(passwordEncoder().encode("ipsssec70"))
        .roles()
        .build();
        return new InMemoryUserDetailsManager(user1);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

