package me.gabu.gabazar.livros.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabu.gabazar.livros.adapters.data.dao.LivroDAO;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.core.usecases.ConsultarLivroUseCase;

@Service
public class ConsultarLivroUseCaseImpl implements ConsultarLivroUseCase {

    private @Autowired LivroDAO dao;

    @Override
    public Livro run(String livroId) {
        return dao.findById(livroId);
    }

}
