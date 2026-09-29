package com.projetospring.cadastrousuario.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.cadastrousuario.business.service.UsuarioService;
import com.projetospring.cadastrousuario.infrastructure.dto.UsuarioDto;
import com.projetospring.cadastrousuario.infrastructure.entitys.Usuario;

@RestController 
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController( UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();

    }
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @DeleteMapping 
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email); 
        return ResponseEntity.ok().build();
    }
    @PutMapping 
    public ResponseEntity<Void> atualizarUsuario(@RequestParam Integer id, @RequestBody  Usuario usuario){
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}
