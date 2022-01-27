package me.gabu.gabazar.livros.util;

import java.util.Collection;

public interface DTOMapper<D, M> {

    D modelToDto(M model);

    M dtoToModel(D dto);

    Collection<D> modelToDto(Collection<M> model);

    Collection<M> dtoToModel(Collection<D> dto);

}
