
package me.gabu.gabazar.livros.service;

public interface TokenService {

    public void validaToken(String token);
    public String recuperarUsuario(String token);
}
