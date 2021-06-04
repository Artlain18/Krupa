package com.example.Krupa.repo;

import com.example.Krupa.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<users, Long> {
    public users findByuserID (Long USER_ID);
    users findByNAME(String username);
}
