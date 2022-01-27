package me.gabu.gabazar.livros.adapters.http.out;

import me.gabu.gabazar.livros.adapters.http.out.dto.AutorDTO;

public interface AutorClient {

    AutorDTO getAutor(String editoraID);
}
