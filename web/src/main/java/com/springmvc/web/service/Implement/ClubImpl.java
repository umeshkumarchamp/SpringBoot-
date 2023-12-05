package com.springmvc.web.service.Implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.model.Club;
import com.springmvc.web.repository.ClubRepository;
import com.springmvc.web.service.ClubService;

@Service
public class ClubImpl implements ClubService{

    @Autowired
    private ClubRepository clubRepo;
    
    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepo.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
            .id(club.getId())
            .title(club.getTitle())
            .photoUrl(club.getPhotoUrl())
            .content(club.getContent())
            .createdOn(club.getCreatedOn())
            .updatedOn(club.getUpdatedOn())
            .build();

        return clubDto;
    }
    
}
