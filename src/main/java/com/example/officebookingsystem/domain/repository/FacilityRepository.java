package com.example.officebookingsystem.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.officebookingsystem.domain.entity.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    @Query("SELECT facility FROM Facility f WHERE f.building.id = :id")
    List<Facility> findFacilityByBuidling(Long id);
}
