package br.com.ListaDeTarefas.ToDoList.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import br.com.ListaDeTarefas.ToDoList.entity.UsuarioVerificadorEntity;
import br.com.ListaDeTarefas.ToDoList.entity.enums.TipoSituacaoUsuario;
import br.com.ListaDeTarefas.ToDoList.repository.UsuarioVerificadorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ListaDeTarefas.ToDoList.dto.UsuarioDTO;
import br.com.ListaDeTarefas.ToDoList.entity.UsuarioEntity;
import br.com.ListaDeTarefas.ToDoList.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
public class UsuarioService {
 // CRUD
	
	private final UsuarioRepository usuarioRepository;

	private final PasswordEncoder encoder;

	private final EmailService emailService;

	private final UsuarioVerificadorRepository usuarioVerificadorRepository;

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder, EmailService emailService, UsuarioVerificadorRepository usuarioVerificadorRepository) {
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
		this.emailService = emailService;
		this.usuarioVerificadorRepository = usuarioVerificadorRepository;
	}
	
	
	public String salvar(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
		usuarioEntity.setSenha(encoder.encode(usuarioDTO.getSenha()));
		usuarioRepository.save(usuarioEntity);
		return "Usuario Salvo Com Sucesso";
	}

	public void inserirNovoUsuario(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
		usuarioEntity.setSenha(encoder.encode(usuarioDTO.getSenha()));
		usuarioEntity.setSituacao(TipoSituacaoUsuario.PENDENTE);
		usuarioEntity.setId(null);
		usuarioRepository.save(usuarioEntity);

		UsuarioVerificadorEntity usuarioVerificadorEntity = new UsuarioVerificadorEntity();
		usuarioVerificadorEntity.setUsuarioEntity(usuarioEntity);
		usuarioVerificadorEntity.setUuid(UUID.randomUUID());
		usuarioVerificadorEntity.setDataExpiracao(Instant.now().plusMillis(900000));
		usuarioVerificadorRepository.save(usuarioVerificadorEntity);

		// TODO: ENVIAR UM EMAIL PARA VERIFICAR A CONTA

		emailService.enviarEmailTexto(usuarioDTO.getEmail(),
							"Novo usuario cadastrado",
						"Voce esta recebendo um email de cadastrado o numero para validacao é " + usuarioVerificadorEntity.getUuid());

	}
	
	public List<UsuarioDTO> listarTodos() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
		
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
		usuarioEntity.setSenha(encoder.encode(usuarioDTO.getSenha()));
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
		
	}
	
	public String deletar(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
		
		return "Usuario Deletado Com Sucesso";
	}
	
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}
	
	
	
}
