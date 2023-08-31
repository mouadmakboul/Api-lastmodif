package com.example.demo3.Service;

import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Repositories.CommentaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    private final CommentaireRepo commentaireRepo;

    @Autowired
    public CommentaireServiceImpl(CommentaireRepo commentaireRepo) {
        this.commentaireRepo = commentaireRepo;
    }

    @Override
    public List<CommentaireEntity> findAll() {
        return commentaireRepo.findAll();
    }

    @Override
    public void deleteById(long id) {
        commentaireRepo.deleteById(id);
    }

    @Override
    public List<CommentaireEntity> findAllByReservation(ReservationEntity reservation) {
        return commentaireRepo.findAllByReservation(reservation);
    }

    @Override
    public List<CommentaireEntity> findAllByUser(UserEntity user) {
        return commentaireRepo.findAllByUser(user);
    }

    @Override
    public CommentaireEntity save(CommentaireEntity com) {

        return commentaireRepo.save(com);
    }

    @Override
    public Optional<CommentaireEntity> findById(long id) {
        return commentaireRepo.findById(id);
    }

}
