package me.gabu.gabazar.livros.adapters.http.out.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.livros.adapters.http.out.dto.AutorDTO;
import me.gabu.gabazar.livros.core.model.Autor;
import me.gabu.gabazar.livros.util.DTOMapper;

@Mapper
public interface AutorDTOMapper extends DTOMapper<AutorDTO, Autor> {

    AutorDTOMapper INSTANCE = Mappers.getMapper(AutorDTOMapper.class);

}
