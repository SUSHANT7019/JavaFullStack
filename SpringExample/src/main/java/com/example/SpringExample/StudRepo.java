package com.example.SpringExample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudRepo extends JpaRepository<StudentEntity, Long> {

}
