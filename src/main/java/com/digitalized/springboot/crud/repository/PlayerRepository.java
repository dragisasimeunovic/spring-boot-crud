package com.digitalized.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalized.springboot.crud.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
