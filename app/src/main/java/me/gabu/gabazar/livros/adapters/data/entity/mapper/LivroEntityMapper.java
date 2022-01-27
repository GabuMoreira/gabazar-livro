package me.gabu.gabazar.livros.adapters.data.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.gabazar.livros.adapters.data.entity.LivroEntity;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.util.EntityMapper;

@Mapper
public interface LivroEntityMapper extends EntityMapper<LivroEntity, Livro> {

    LivroEntityMapper INSTANCE = Mappers.getMapper(LivroEntityMapper.class);

}
