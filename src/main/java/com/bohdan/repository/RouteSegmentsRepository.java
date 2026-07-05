package com.bohdan.repository;

import com.bohdan.entity.Route;
import com.bohdan.entity.RouteSegment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteSegmentsRepository extends JpaRepository<RouteSegment, Integer> {

    List<RouteSegment> findAllByRouteId(int routeId);

}
