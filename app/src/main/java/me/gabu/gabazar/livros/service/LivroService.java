
package me.gabu.gabazar.livros.service;

import java.util.Collection;

import me.gabu.gabazar.livros.core.model.Livro;

public interface LivroService {

    public Livro criarLivro(Livro livro, String usuario);

    public Livro consultarLivro(String livroId);

    public Livro atualizarLivro(Livro livro, String usuario);

    public Collection<Livro> listarLivros(String nome);

    public void apagarLivro(String livroId, String usuario);

}
