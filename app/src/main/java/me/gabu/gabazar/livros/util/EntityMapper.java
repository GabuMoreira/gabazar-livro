package me.gabu.gabazar.livros.util;

import java.util.Collection;

public interface EntityMapper<E, M> {

    E modelToEntity(M model);

    M entityToModel(E entity);

    Collection<E> modelToEntity(Collection<M> model);

    Collection<M> entityToModel(Collection<E> entity);

}
