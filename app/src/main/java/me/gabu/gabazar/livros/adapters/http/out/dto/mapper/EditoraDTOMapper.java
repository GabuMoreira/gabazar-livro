package me.gabu.gabazar.livros.adapters.http.out.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.livros.adapters.http.out.dto.EditoraDTO;
import me.gabu.gabazar.livros.core.model.Editora;
import me.gabu.gabazar.livros.util.DTOMapper;

@Mapper
public interface EditoraDTOMapper extends DTOMapper<EditoraDTO, Editora> {

    EditoraDTOMapper INSTANCE = Mappers.getMapper(EditoraDTOMapper.class);

}
