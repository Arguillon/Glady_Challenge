package com.glady.challenge.data.repository;

import com.glady.challenge.data.entity.GiftDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftDepositRepository extends JpaRepository<GiftDeposit, Integer> {

}
