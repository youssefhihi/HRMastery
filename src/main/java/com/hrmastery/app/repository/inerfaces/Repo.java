package com.hrmastery.app.repository.inerfaces;

import com.hrmastery.app.Exceptions.RepoException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Repo<T> {
    Boolean create(T entity) throws RepoException;     // Takes an entity, not Class<T>
    Boolean update(T entity) throws RepoException;     // Same here
    List<T> findAll() throws RepoException;
    Optional<T> findById(UUID id) throws RepoException;
    Boolean delete(UUID id) throws RepoException;
}
