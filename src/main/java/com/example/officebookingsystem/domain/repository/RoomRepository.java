package com.example.officebookingsystem.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.officebookingsystem.domain.entity.Building;
import com.example.officebookingsystem.domain.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // count by building
    Integer countByBuilding(Building building);

    @Query("SELECT room FROM Room room WHERE room.building.id = :id")
    List<Room> existRoomByBuilding(@Param("id") Long id);

}
