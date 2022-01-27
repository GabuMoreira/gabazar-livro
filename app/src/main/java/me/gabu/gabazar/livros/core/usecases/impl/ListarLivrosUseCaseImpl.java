package me.gabu.gabazar.livros.core.usecases.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import me.gabu.gabazar.livros.adapters.data.dao.LivroDAO;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.core.usecases.ListarLivrosUseCase;

@Service
public class ListarLivrosUseCaseImpl implements ListarLivrosUseCase {

    private @Autowired LivroDAO dao;

    @Override
    public Collection<Livro> run(String nome) {

        if (StringUtils.hasLength(nome))
            return dao.findByNome(nome);

        return dao.listAll();
    }

}
