package me.gabu.gabazar.livros.core.usecases;

import me.gabu.gabazar.livros.core.model.Livro;

public interface AtualizarLivroUseCase {
    Livro run(Livro livro, String usuario);
}
