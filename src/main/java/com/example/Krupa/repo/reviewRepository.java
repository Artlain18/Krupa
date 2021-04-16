package com.example.Krupa.repo;

import com.example.Krupa.models.game;
import com.example.Krupa.models.review;
import com.example.Krupa.models.status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reviewRepository extends JpaRepository<review, Integer> {
    //void getreviewBy(int id);
    List<review> findAllBystatusID(status statusID);
}
