package com.hrmastery.app.service.interfaces;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Recruitment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecruitmentService {

    String createRecruitment(Recruitment recruitment) throws RepoException;
    String deleteRecruitment(UUID id) throws RepoException;
    String updateRecruitment(Recruitment recruitment) throws RepoException;
    List<Recruitment> getAllRecruitments() throws RepoException;
    Recruitment getRecruitment(UUID id) throws RepoException;
}
