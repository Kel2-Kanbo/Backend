package com.example.officebookingsystem.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.officebookingsystem.domain.entity.RoomSpecification;

@Repository
public interface SpecificationRepository extends JpaRepository<RoomSpecification, Long> {

    @Query("SELECT roomSpecification FROM RoomSpecification roomSpecification WHERE roomSpecification.room.id = :id")
    RoomSpecification roomSpecification(@Param("id") Long id);
}
