package com.example.lombok.repository;

import com.example.lombok.models.Car;
import com.example.lombok.models.Plane;
import com.example.lombok.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u")
    List<User> getAll();
}
