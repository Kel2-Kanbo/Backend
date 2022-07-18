package com.example.officebookingsystem.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.officebookingsystem.domain.entity.RoomItem;

@Repository
public interface RoomItemRepository extends JpaRepository<RoomItem, Long> {
    @Query("SELECT roomItem.itemName FROM RoomItem roomItem WHERE roomItem.room.id = :id")
    List<String> roomItemNames(@Param("id") Long id);

    @Query("SELECT roomItem FROM RoomItem roomItem WHERE roomItem.room.id = :id")
    List<RoomItem> roomItems(@Param("id") Long id);
}
