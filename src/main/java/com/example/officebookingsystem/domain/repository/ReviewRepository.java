package com.example.officebookingsystem.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.officebookingsystem.domain.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT review FROM Review review WHERE review.room.id = :id")
    List<Review> roomReviews(@Param("id") Long id);
}
