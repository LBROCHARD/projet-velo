package com.formation.velo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// import com.formation.velo.service.StationService;
import com.formation.velo.service.CompostService;

import lombok.extern.java.Log;

@Log
@Component
public class ScheduledTask {
    private final CompostService compostService;

    public ScheduledTask(CompostService _compostService) {
        this.compostService = _compostService;
    }

    @Scheduled(fixedRate = 60000)
    public void searchNextMatchByCompetition() {
        log.info("update compost");
        compostService.getRecord();
    }
}

// public class ScheduledTask {
//     private final StationService stationService;

//     public ScheduledTask(StationService stationService) {
//         this.stationService = stationService;
//     }

//     @Scheduled(fixedRate = 60000)
//     public void searchNextMatchByCompetition() {
//         log.info("update stations");
//         stationService.getRecord();
//     }
// }