package me.gabu.gabazar.livros.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import me.gabu.gabazar.livros.adapters.http.out.EditoraClient;
import me.gabu.gabazar.livros.adapters.http.out.dto.EditoraDTO;
import me.gabu.gabazar.livros.adapters.http.out.dto.mapper.EditoraDTOMapper;
import me.gabu.gabazar.livros.core.exceptions.BadRequestException;
import me.gabu.gabazar.livros.core.model.Editora;
import me.gabu.gabazar.livros.core.usecases.ConsultarEditoraUseCase;

@Service
public class ConsultarEditoraUseCaseImpl implements ConsultarEditoraUseCase {

    private static final String EDITORA_404 = "Editora informada não cadastrada: {%s}";

    private @Autowired EditoraClient editoraClient;

    @Override
    public Editora run(String editoraId) {
        EditoraDTO editoraDTO = editoraClient.getEditora(editoraId);

        if (ObjectUtils.isEmpty(editoraDTO))
            throw new BadRequestException(String.format(EDITORA_404, editoraId));

        return getMapper().dtoToModel(editoraDTO);
    }

    protected EditoraDTOMapper getMapper() {
        return EditoraDTOMapper.INSTANCE;
    }
}
