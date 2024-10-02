package com.group.capstone.controller.Reader;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class FileController {

    @GetMapping("/read-file")
    public ResponseEntity<String> readFile(@RequestParam String fileName) {
        String desktopPath = System.getProperty("user.home") + "/Desktop/";

        try {
            // 경로에 있는 파일을 읽어서 문자열로 반환
            // 바탕화면 경로에 있는 파일 읽기
            String fullPath = desktopPath + fileName;
            String content = new String(Files.readAllBytes(Paths.get(fullPath)));
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            // 파일을 읽는 중 오류가 발생하면 404 오류를 반환
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found or unable to read");
        }
    }
}



