package com.example.officebookingsystem.domain.repository;

import com.example.officebookingsystem.domain.dto.response.UserPageResponse;
import com.example.officebookingsystem.domain.entity.Complex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPageRepository extends JpaRepository<Complex, Long> {

    @Query(
            value = "SELECT new com.example.officebookingsystem.domain.dto.response.UserPageResponse(co.complexName, co.address, ci.id)"+ "FROM Complex co" + "INNER JOIN City ci ON ci.id = co.city"
    )
    List<UserPageResponse> getComplexByCity();

}
