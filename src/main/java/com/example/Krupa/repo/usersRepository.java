package com.example.Krupa.repo;

import com.example.Krupa.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<users, Integer> {
}
