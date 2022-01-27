package me.gabu.gabazar.livros.adapters.http.out;

import me.gabu.gabazar.livros.adapters.http.out.dto.EditoraDTO;

public interface EditoraClient {

    EditoraDTO getEditora(String editoraID);

}
