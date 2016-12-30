package com.ms.opentech;


import com.ms.opentech.beans.Position;
import com.ms.opentech.services.interfaces.DetectionService;
import com.ms.opentech.services.interfaces.StorageService;
import com.ms.opentech.utils.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class WebController {

    private final StorageService storageService;
    private final DetectionService detectionService;

    @Autowired
    public WebController(StorageService storageService, DetectionService detectionService) {
        this.storageService = storageService;
        this.detectionService = detectionService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        return "uploadForm";
    }

    @PostMapping("/")
    public @ResponseBody  Callable<List<Position>> handleFileUpload(@RequestParam("file")MultipartFile file) {
        return ()-> {
            Path imagePath = storageService.store(file);
            return detectionService.detect(imagePath);
        };
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
