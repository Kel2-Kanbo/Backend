package com.example.officebookingsystem.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.officebookingsystem.domain.entity.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Query("SELECT f FROM Facility f WHERE f.building.id = :id")
    List<Facility> findFacilityByBuidling(@Param("id") Long id);
}
