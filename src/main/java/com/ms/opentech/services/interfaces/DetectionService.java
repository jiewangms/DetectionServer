package com.ms.opentech.services.interfaces;


import com.ms.opentech.beans.Position;

import java.nio.file.Path;
import java.util.List;

public interface DetectionService {
    /*void detect(Path imagePath, ResultCallback callback);

    interface ResultCallback {
        void onCompleted(List<Position> results);
    }*/
    List<Position> detect(Path imagePath);
}

