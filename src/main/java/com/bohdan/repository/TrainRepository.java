package com.bohdan.repository;

import com.bohdan.entity.Route;
import com.bohdan.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Integer> {
}
