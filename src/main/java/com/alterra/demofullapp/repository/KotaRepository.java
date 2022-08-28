package com.alterra.demofullapp.repository;

import com.alterra.demofullapp.entity.Kota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KotaRepository extends JpaRepository<Kota, Long> {

}
