package me.gabu.gabazar.livros.core.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import me.gabu.gabazar.livros.adapters.http.out.AutorClient;
import me.gabu.gabazar.livros.adapters.http.out.dto.AutorDTO;
import me.gabu.gabazar.livros.adapters.http.out.dto.mapper.AutorDTOMapper;
import me.gabu.gabazar.livros.core.exceptions.BadRequestException;
import me.gabu.gabazar.livros.core.model.Autor;
import me.gabu.gabazar.livros.core.usecases.ConsultarAutorUseCase;

@Service
public class ConsultarAutorUseCaseImpl implements ConsultarAutorUseCase {

    private static final String AUTOR_404 = "Autor informado não cadastrado: {%s}";

    private @Autowired AutorClient autorClient;

    @Override
    public Autor run(String autorId) {
        AutorDTO autorDTO = autorClient.getAutor(autorId);

        if (ObjectUtils.isEmpty(autorDTO))
            throw new BadRequestException(String.format(AUTOR_404, autorId));

        return getMapper().dtoToModel(autorDTO);
    }

    protected AutorDTOMapper getMapper() {
        return AutorDTOMapper.INSTANCE;
    }
}
