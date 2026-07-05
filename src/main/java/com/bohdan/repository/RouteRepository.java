package com.bohdan.repository;

import com.bohdan.entity.Route;
import com.bohdan.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Integer> {

    @Query("""
        SELECT DISTINCT r FROM Route r
        JOIN r.segments dep
        JOIN r.segments arr
        WHERE dep.station.name = :from
          AND arr.station.name = :to
          AND dep.sequenceOrder < arr.sequenceOrder
        """)
    List<Route> findRoutesBetweenStations(
            @Param("from") String from,
            @Param("to") String to
    );




}
