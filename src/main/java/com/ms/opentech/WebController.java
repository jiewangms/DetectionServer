package com.ms.opentech;


import com.ms.opentech.storage.StorageFileNotFoundException;
import com.ms.opentech.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class WebController {

    private final StorageService storageService;

    @Autowired
    public WebController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

/*        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(WebController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));*/

        return "uploadForm";
    }

    @PostMapping("/")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file")MultipartFile file) {
        storageService.store(file);
        return ResponseEntity.ok().body("Successfully");
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
