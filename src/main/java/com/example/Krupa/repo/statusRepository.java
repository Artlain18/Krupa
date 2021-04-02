package com.example.Krupa.repo;

import com.example.Krupa.models.status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface statusRepository extends JpaRepository<status, Integer> {
}
