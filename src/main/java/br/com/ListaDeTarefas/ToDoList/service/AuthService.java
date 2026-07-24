package br.com.ListaDeTarefas.ToDoList.service;

import br.com.ListaDeTarefas.ToDoList.dto.AcessDTO;
import br.com.ListaDeTarefas.ToDoList.dto.AuthenticationDTO;
import br.com.ListaDeTarefas.ToDoList.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDTO) {

        try {
            // Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());

            // Preapara mecanismo para autenticacao
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // Buscar usuario logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO acessDTO = new AcessDTO(token);

            return acessDTO;

        } catch (BadCredentialsException e) {
            //TODO LOGIN OU SENHA INVALIDO
        }

        return null;

    }
}
