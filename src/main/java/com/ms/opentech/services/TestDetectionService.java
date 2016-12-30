package com.ms.opentech.services;

import com.ms.opentech.beans.Position;
import com.ms.opentech.services.interfaces.DetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestDetectionService implements DetectionService {
    private final static Logger logger = LoggerFactory.getLogger(TestDetectionService.class.getSimpleName());

    @Override
    public List<Position> detect(Path imagePath) {
        try {
            logger.info("Detecting: {}", imagePath.toFile().toString());
            Thread.sleep((long) (5000 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Position> list = new ArrayList<>(10);
        for (int i = 0; i < 10; ++i) {
            list.add(new Position(2, 3, 100, 200));
        }
        return list;
    }

    /*@Override
    public void detect(Path imagePath, ResultCallback callback) {
        try {
            logger.info("Detecting: {}", imagePath.toFile().toString());
            Thread.sleep((long) (5000 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Position> list = new ArrayList<>(10);
        for (int i = 0; i < 10; ++i) {
            list.add(new Position(2, 3, 100, 200));
        }
        callback.onCompleted(list);
    }*/
}
