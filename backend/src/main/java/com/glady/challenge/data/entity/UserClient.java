package com.glady.challenge.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_client")
public class UserClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "userClient")
    private List<GiftDeposit> giftDeposits;

    @OneToMany(mappedBy = "userClient")
    private List<MealDeposit> mealDeposits;
}
