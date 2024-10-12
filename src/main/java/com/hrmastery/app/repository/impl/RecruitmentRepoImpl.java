package com.hrmastery.app.repository.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Recruitment;
import com.hrmastery.app.repository.inerfaces.RecruitmentRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RecruitmentRepoImpl extends RepoImpl<Recruitment> implements RecruitmentRepo {

    public RecruitmentRepoImpl() {
        super(Recruitment.class);
    }

    @Override
    public Boolean create(Recruitment employee) throws RepoException {
        return super.create(employee);
    }

    @Override
    public Boolean update(Recruitment employee) throws RepoException {
        return super.update(employee);
    }

    @Override
    public List<Recruitment> findAll() throws RepoException {
        return super.findAll();
    }

    @Override
    public Optional<Recruitment> findById(UUID id) throws RepoException {
        return super.findById(id);
    }

    @Override
    public Boolean delete(UUID id) throws RepoException {
        return super.delete(id);
    }
}
