package me.gabu.gabazar.livros.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.livros.adapters.data.dao.LivroDAO;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.core.usecases.ConsultarAutorUseCase;
import me.gabu.gabazar.livros.core.usecases.ConsultarEditoraUseCase;
import me.gabu.gabazar.livros.core.usecases.CriarLivroUseCase;
import me.gabu.gabazar.livros.service.ValidationService;
import me.gabu.gabazar.livros.service.validations.ValidationEnum;

@Slf4j
@Service
public class CriarLivroUseCaseImpl implements CriarLivroUseCase {

    private static final String LOG_AUTOR = "[USECASE] [CREATE] [AUTOR]: {}";
    private static final String LOG_EDITORA = "[USECASE] [CREATE] [EDITORA]: {}";
    private static final String LOG_NOVO_LIVRO = "[USECASE] [CREATE] {}";

    private @Autowired LivroDAO dao;
    private @Autowired ValidationService validator;
    private @Autowired ConsultarEditoraUseCase consultarEditoraUC;
    private @Autowired ConsultarAutorUseCase consultarAutorUC;

    @Override
    public Livro run(Livro livro, String usuario) {
        log.info(LOG_NOVO_LIVRO, livro);
        validator.validate(livro, ValidationEnum.CREATE);

        log.info(LOG_EDITORA, consultarEditoraUC.run(livro.getEditoraID()));
        log.info(LOG_AUTOR, consultarAutorUC.run(livro.getAutorID()));

        livro.setUsuarioCriacao(usuario);
        return dao.save(livro);
    }

}
