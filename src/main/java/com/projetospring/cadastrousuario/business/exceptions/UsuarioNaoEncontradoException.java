package com.projetospring.cadastrousuario.business.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException(String msg) {
        super(msg);
    }
}
