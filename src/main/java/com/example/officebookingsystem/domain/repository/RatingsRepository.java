package com.example.officebookingsystem.domain.repository;

import com.example.officebookingsystem.domain.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Long> {

    @Query("SELECT AVG(ratings.ratings) FROM Ratings ratings WHERE ratings.room.id = :id")
    Integer ratingRoom(@Param("id") Long id);
}
