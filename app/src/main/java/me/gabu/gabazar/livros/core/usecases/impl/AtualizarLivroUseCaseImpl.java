package me.gabu.gabazar.livros.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.livros.adapters.data.dao.LivroDAO;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.core.usecases.AtualizarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.ConsultarAutorUseCase;
import me.gabu.gabazar.livros.core.usecases.ConsultarEditoraUseCase;
import me.gabu.gabazar.livros.core.usecases.ConsultarLivroUseCase;
import me.gabu.gabazar.livros.service.ValidationService;
import me.gabu.gabazar.livros.service.validations.ValidationEnum;

@Slf4j
@Service
public class AtualizarLivroUseCaseImpl implements AtualizarLivroUseCase {

    private static final String LOG_NOVO_AUTOR = "[USECASE] [UPDATE] [{}] [NOVO AUTOR]: {}";
    private static final String LOG_NOVA_EDITORA = "[USECASE] [UPDATE] [{}] [NOVA EDITORA]: {}";
    private static final String LOG_DE_PARA = "[USECASE] [UPDATE] [{}] -> [{}]";

    private @Autowired LivroDAO dao;
    private @Autowired ValidationService validator;
    private @Autowired ConsultarLivroUseCase consultarLivroUC;
    private @Autowired ConsultarEditoraUseCase consultarEditoraUC;
    private @Autowired ConsultarAutorUseCase consultarAutorUC;

    @Override
    public Livro run(Livro livro, String usuario) {
        Livro registroAtual = consultarLivroUC.run(livro.getId());
        log.info(LOG_DE_PARA, registroAtual, livro);

        validator.validate(livro, ValidationEnum.UPDATE);

        logNovaEditora(livro, registroAtual);
        logNovoAutor(livro, registroAtual);

        livro.setUsuarioAlteracao(usuario);
        livro.setUsuarioCriacao(registroAtual.getUsuarioCriacao());
        livro.setDataCriacao(registroAtual.getDataCriacao());

        return dao.update(livro);
    }

    protected void logNovaEditora(Livro livro, Livro registroAtual) {
        if (!registroAtual.getEditoraID().equals(livro.getEditoraID()))
            log.info(LOG_NOVA_EDITORA, livro.getId(), consultarEditoraUC.run(livro.getEditoraID()));
    }

    protected void logNovoAutor(Livro livro, Livro registroAtual) {
        if (!registroAtual.getAutorID().equals(livro.getAutorID()))
            log.info(LOG_NOVO_AUTOR, livro.getId(), consultarAutorUC.run(livro.getAutorID()));
    }
}
