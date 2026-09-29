package com.projetospring.cadastrousuario.infrastructure.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.projetospring.cadastrousuario.infrastructure.dto.UsuarioDto;
import com.projetospring.cadastrousuario.infrastructure.entitys.Usuario;

@Service 
public class UsuarioMapper implements Function<Usuario, UsuarioDto>{
    @Override 
    public UsuarioDto apply(Usuario usuario) {
        return new UsuarioDto(usuario.getName(), usuario.getEmail());
    }
}
