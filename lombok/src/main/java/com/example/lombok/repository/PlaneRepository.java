package com.example.lombok.repository;

import com.example.lombok.models.Car;
import com.example.lombok.models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
    @Query("SELECT p FROM Plane p")
    List<Plane> getAll();

}
