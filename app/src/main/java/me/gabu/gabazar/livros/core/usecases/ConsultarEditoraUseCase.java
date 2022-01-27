package me.gabu.gabazar.livros.core.usecases;

import me.gabu.gabazar.livros.core.model.Editora;

public interface ConsultarEditoraUseCase {
    Editora run(String editoraId);
}
