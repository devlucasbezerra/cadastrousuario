package com.projetospring.cadastrousuario.infrastructure.dto;

import lombok.Builder;

@Builder 
public record UsuarioDto(String name, String email) {
}
