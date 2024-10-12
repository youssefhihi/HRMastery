package com.hrmastery.app.repository.inerfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Recruitment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecruitmentRepo {
    Boolean create(Recruitment recruitment) throws RepoException;
    Boolean delete(UUID id) throws RepoException;
    Boolean update(Recruitment recruitment) throws RepoException;
    List<Recruitment> findAll() throws RepoException;
    Optional<Recruitment> findById(UUID id) throws RepoException;

}
