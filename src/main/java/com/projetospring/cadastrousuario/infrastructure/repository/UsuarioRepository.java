package com.projetospring.cadastrousuario.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.cadastrousuario.infrastructure.entitys.Usuario;

import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    @Transactional 
    void deleteByEmail(String email);
    

}
