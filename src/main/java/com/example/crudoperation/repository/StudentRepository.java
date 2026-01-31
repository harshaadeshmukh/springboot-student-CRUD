package com.example.crudoperation.repository;
import com.example.crudoperation.entity.StudentData;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//Spring, please give me all database operations for the User table, whose primary key type is Long
public interface StudentRepository extends JpaRepository<@NotNull StudentData, @NotNull Integer> {
}
