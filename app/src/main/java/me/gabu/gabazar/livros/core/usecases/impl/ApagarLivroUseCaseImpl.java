package me.gabu.gabazar.livros.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.livros.adapters.data.dao.LivroDAO;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.core.usecases.ApagarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.ConsultarLivroUseCase;

@Slf4j
@Service
public class ApagarLivroUseCaseImpl implements ApagarLivroUseCase {

    private @Autowired LivroDAO dao;
    private @Autowired ConsultarLivroUseCase consultarUC;

    @Override
    public void run(String livroId, String usuario) {
        log.info("[USECASE] [DELETE] {}", livroId);

        Livro livro = consultarUC.run(livroId);

        dao.delete(livro);
    }

}
