package com.bohdan.service;

import com.bohdan.entity.Train;
import com.bohdan.repository.TrainRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }


}
