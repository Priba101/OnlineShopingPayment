package com.techprimers.db.repository;

import com.techprimers.db.model.Korpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorpaRepository extends JpaRepository<Korpa,Integer> {

    Korpa findById(int id);
}
