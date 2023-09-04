package com.example.demo3.Service;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.LogementException;
import com.example.demo3.Repositories.LogementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogementServiceImpl implements LogementService {
    private final LogementRepo logementRepo;

    @Autowired
    public LogementServiceImpl(LogementRepo logementRepo) {
        this.logementRepo = logementRepo;
    }

    @Override
    public LogementEntity findByTitle(String title) {
        return logementRepo.findByTitle(title);
    }

    @Override
    public Optional<LogementEntity> findById(Long id) {
        return logementRepo.findById(id);
    }

    @Override
    public List<LogementEntity> findAllByUser(UserEntity user) {
        return logementRepo.findAllByUser(user);
    }

    @Override
    public List<LogementEntity> findAllAvailableBetweenDates(Date startDate, Date endDate) {
        return logementRepo.findAllByStartdateBeforeAndEnddateAfter(startDate, endDate);
    }

    @Override
    public void deleteById(Long id) {
        logementRepo.deleteById(id);
    }

    @Override
    public LogementEntity update(LogementEntity logement) {
        return logementRepo.save(logement);
    }

    @Override
    public LogementEntity save(LogementEntity logement) {
        if (logement.getStartdate().after(logement.getEnddate())) {
            throw new LogementException("La date de début ne peut pas être après la date de fin.");
        }
        return logementRepo.save(logement);
    }

}
