package com.techprimers.db.repository;

import com.techprimers.db.model.Kartice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KarticeRepository extends JpaRepository<Kartice, Long> {

    Kartice findById(long id);

    void deleteById(int id);
}
