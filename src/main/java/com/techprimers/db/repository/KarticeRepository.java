package com.techprimers.db.repository;

import com.techprimers.db.model.Kartice;
import com.techprimers.db.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KarticeRepository extends JpaRepository<Kartice, Long> {

    Kartice findById(long id);
}
