package com.example.demo3.Service;

import com.example.demo3.Entities.PayementEntity.PayementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.PaymentException;
import com.example.demo3.Repositories.PayementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayementServiceImpl implements PayementService {
    private final PayementRepo payementRepo;

    @Autowired
    public PayementServiceImpl(PayementRepo payementRepo) {
        this.payementRepo = payementRepo;
    }

    @Override
    public List<PayementEntity> findAllByUser(UserEntity user) {
        return payementRepo.findAllByUser(user);
    }

    @Override
    public List<PayementEntity> findAllByMethodepayement(String methodepayement) {
        return payementRepo.findAllByMethodepayement(methodepayement);
    }
    @Override
    public Optional<PayementEntity> findById(Long id) {
        return payementRepo.findById(id);
    }

    @Override
    public PayementEntity save(PayementEntity payment) {
        if (payment.getAmount() <= 0) {
            throw new PaymentException("Le montant du paiement doit être supérieur à zéro.");
        }
        return payementRepo.save(payment);
    }


    @Override
    public void deleteById(Long id) {
        payementRepo.deleteById(id);
    }
}
