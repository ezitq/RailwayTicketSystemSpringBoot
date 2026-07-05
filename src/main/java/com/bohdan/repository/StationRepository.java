package com.bohdan.repository;

import com.bohdan.entity.Route;
import com.bohdan.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Integer> {
}
