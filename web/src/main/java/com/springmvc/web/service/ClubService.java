package com.springmvc.web.service;

import java.util.List;

import com.springmvc.web.dto.ClubDto;

public interface ClubService {
    List<ClubDto> findAllClubs();

}