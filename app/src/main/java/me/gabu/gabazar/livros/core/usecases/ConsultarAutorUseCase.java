package me.gabu.gabazar.livros.core.usecases;

import me.gabu.gabazar.livros.core.model.Autor;

public interface ConsultarAutorUseCase {
    Autor run(String autorId);
}
