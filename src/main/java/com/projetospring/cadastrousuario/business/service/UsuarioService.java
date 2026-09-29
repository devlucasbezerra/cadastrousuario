package com.projetospring.cadastrousuario.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetospring.cadastrousuario.business.exceptions.UsuarioNaoEncontradoException;
import com.projetospring.cadastrousuario.infrastructure.dto.UsuarioDto;
import com.projetospring.cadastrousuario.infrastructure.entitys.Usuario;
import com.projetospring.cadastrousuario.infrastructure.mapper.UsuarioMapper;
import com.projetospring.cadastrousuario.infrastructure.repository.UsuarioRepository;

@Service 
public class UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository repository;
    public UsuarioService( UsuarioRepository repository, UsuarioMapper usuarioMapper){
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
    }
    
    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public List<UsuarioDto> listarUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        if (usuarios.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Nenhum usuário encontrado!");
        }
    
        return usuarios.stream()
            .map(usuarioMapper)
            .toList();
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
            ()-> new UsuarioNaoEncontradoException("Nenhum usuário encontrado!")
        );

    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
        .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
        .name(usuario.getName() != null ? usuario.getName() : usuarioEntity.getName())
        .id(usuarioEntity.getId())
        .build();
        repository.saveAndFlush(usuarioAtualizado);

    }

}
