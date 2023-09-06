package com.example.demo3.Service;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.ReservationException;
import com.example.demo3.Repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepo reservationRepo;

    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public List<ReservationEntity> findAllByLogement(Optional<LogementEntity> logement) {
        return reservationRepo.findAllByLogement(logement);
    }

    @Override
    public List<ReservationEntity> findAllByUserAndLogement(UserEntity user, LogementEntity logement) {
        return reservationRepo.findAllByUserAndLogement(user, logement);
    }

    @Override
    public ReservationEntity save(ReservationEntity reservation) {
        if (reservation.getDatereservation() == null || reservation.getDatereservation().before(new Date())) {
            throw new ReservationException("La date de réservation est invalide.");
        }
        return reservationRepo.save(reservation);
    }




    @Override
    public void deleteById(Long id) {
        reservationRepo.deleteById(id);

    }

    @Override
    public List<ReservationEntity> findAllByStartDateBetween(Date startDate, Date endDate) {
        return reservationRepo.findAllByStartDateBetween(startDate, endDate);
    }
    @Override
    public boolean isReservationValid(ReservationEntity reservation) {
        if (reservation.getDatereservation() == null || reservation.getDatereservation().before(new Date())) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Object> findById(long reservationId) {
        return Optional.of(reservationRepo.findById(reservationId));
    }


}
