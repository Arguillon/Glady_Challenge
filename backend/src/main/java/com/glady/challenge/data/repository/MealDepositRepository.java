package com.glady.challenge.data.repository;

import com.glady.challenge.data.entity.MealDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealDepositRepository extends JpaRepository<MealDeposit, Integer> {
}
