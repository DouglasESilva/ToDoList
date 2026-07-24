package br.com.ListaDeTarefas.ToDoList.service;

import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;
import br.com.ListaDeTarefas.ToDoList.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailServiceImpl  implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UsuarioEntity usuario = usuarioRepository.findByLogin(username).get();
        UsuarioEntity usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuairo nao encontrado" + username));
        return UserDetailsImpl.build(usuario);
    }
}
