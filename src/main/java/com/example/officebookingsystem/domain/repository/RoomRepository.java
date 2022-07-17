package com.example.officebookingsystem.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.officebookingsystem.domain.entity.Building;
import com.example.officebookingsystem.domain.entity.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // count by building
    Integer countByBuilding(Building building);

    boolean existByName(String name);
}
