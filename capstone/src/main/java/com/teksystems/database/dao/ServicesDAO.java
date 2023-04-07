package com.teksystems.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.teksystems.database.entity.Services;

import java.util.List;


public interface ServicesDAO extends JpaRepository<Services, Long>  {

    @Query("FROM Services s")
    List<Services> getAllServices();

    List<Services> findByArtistNameContainingIgnoreCase(String artistName);

    Services findById(Integer id);

}
