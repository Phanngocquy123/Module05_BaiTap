package com.example.bai4.controller;

import com.example.bai4.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@CrossOrigin
public class FileController {
    private FileService fileService;
    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file")MultipartFile file){
        fileService.save(file);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/load/{filename:.+}")
    public ResponseEntity load(@PathVariable String filename){
        Resource resource = fileService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +resource.getFilename() + "\"")
                .body(resource);
    }



}
