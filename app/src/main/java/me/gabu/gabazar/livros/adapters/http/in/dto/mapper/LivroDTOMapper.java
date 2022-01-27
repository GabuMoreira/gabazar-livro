package me.gabu.gabazar.livros.adapters.http.in.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.livros.adapters.http.in.dto.LivroDTO;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.util.DTOMapper;

@Mapper
public interface LivroDTOMapper extends DTOMapper<LivroDTO, Livro> {

    LivroDTOMapper INSTANCE = Mappers.getMapper(LivroDTOMapper.class);

}
