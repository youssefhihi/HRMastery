package com.hrmastery.app.service.impl;

import com.hrmastery.app.Exceptions.RepoException;
import com.hrmastery.app.entity.Recruitment;
import com.hrmastery.app.repository.impl.RecruitmentRepoImpl;
import com.hrmastery.app.repository.inerfaces.RecruitmentRepo;
import com.hrmastery.app.service.interfaces.RecruitmentService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RecruitmentServiceImpl implements RecruitmentService {

    private final RecruitmentRepo recruitmentRepo = new RecruitmentRepoImpl();

    @Override
    public String createRecruitment(Recruitment recruitment) throws RepoException {
        try {
            Boolean isAdded = recruitmentRepo.create(recruitment);
            if (isAdded) {
                return "Recruitment added successfully";
            }
        } catch (RepoException e) {
            throw new RepoException(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateRecruitment(Recruitment recruitment) throws RepoException {
        try {
            Boolean isUpdated = recruitmentRepo.update(recruitment);
            if (isUpdated) {
                return "Recruitment updated successfully";
            }
        } catch (RepoException e) {
            throw new RepoException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Recruitment> getAllRecruitments() throws RepoException {
        return recruitmentRepo.findAll();
    }

    @Override
    public Recruitment getRecruitment(UUID recruitmentId) throws RepoException {
        Optional<Recruitment> recruitment = recruitmentRepo.findById(recruitmentId);
        if (recruitment.isPresent()) {
            return recruitment.get();
        }else {
            throw new RepoException("Recruitment not found");
        }
    }


    @Override
    public String deleteRecruitment(UUID recruitmentId) throws RepoException {
        try{
            Boolean isAdded =  recruitmentRepo.delete(recruitmentId);
            if(isAdded) {
                return "Recruitment deleted successfully";
            }
        }catch (RepoException e) {
            throw new RepoException(e.getMessage());
        }
        return null;
    }
}
