package com.digitalized.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalized.springboot.crud.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
