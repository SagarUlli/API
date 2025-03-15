package com.example.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.dto.API;

public interface APIRepository extends JpaRepository<API, Integer> {

}
