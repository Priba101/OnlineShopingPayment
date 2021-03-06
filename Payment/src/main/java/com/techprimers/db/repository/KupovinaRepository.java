package com.techprimers.db.repository;

import com.techprimers.db.model.Kupovina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KupovinaRepository extends JpaRepository<Kupovina, Integer> {
    Kupovina findById(int id);
}
