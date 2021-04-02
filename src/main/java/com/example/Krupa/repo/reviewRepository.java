package com.example.Krupa.repo;

import com.example.Krupa.models.review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reviewRepository extends JpaRepository<review, Integer> {
    //void getreviewBy(int id);

}
