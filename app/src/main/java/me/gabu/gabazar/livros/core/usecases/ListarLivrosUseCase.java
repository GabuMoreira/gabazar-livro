package me.gabu.gabazar.livros.core.usecases;

import java.util.Collection;

import me.gabu.gabazar.livros.core.model.Livro;

public interface ListarLivrosUseCase {
    Collection<Livro> run(String nome);
}
