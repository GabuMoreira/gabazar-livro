package me.gabu.gabazar.livros.core.usecases;

import me.gabu.gabazar.livros.core.model.Livro;

public interface ConsultarLivroUseCase {
    Livro run(String livroId);
}
