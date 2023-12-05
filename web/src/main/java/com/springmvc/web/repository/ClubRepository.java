package com.springmvc.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.web.model.Club;


public interface ClubRepository extends JpaRepository<Club, Long>{
    Optional<Club> findByPhotoUrl(String photoUrl);
}
