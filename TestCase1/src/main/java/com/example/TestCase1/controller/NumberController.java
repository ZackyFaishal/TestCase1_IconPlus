package com.example.TestCase1.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestCase1.service.NumberService;

@RestController
@RequestMapping("/number")
public class NumberController {
    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping
    public ResponseEntity<?> postNumber(@RequestBody Map<String, Object> numberRequest) {
        if (!numberRequest.containsKey("value") || !(numberRequest.get("value") instanceof Number)) {
            return ResponseEntity.badRequest().body(Map.of("error", "Input tidak valid. Harus berupa angka."));
        }

        int value = ((Number) numberRequest.get("value")).intValue();
        numberService.addNumber(value);
        return ResponseEntity.ok(Map.of("message", "Data berhasil disimpan."));
    }


    @GetMapping
    public ResponseEntity<?> getNumbers() {
        var list = numberService.getAllNumbers();
        if (list.isEmpty()) {
            return ResponseEntity.ok(Map.of("error", "Belum ada data yang diinput."));
        }
        return ResponseEntity.ok(list);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllNumbers() {
        numberService.clearAll();
        return ResponseEntity.ok(Map.of("message", "Semua data berhasil dihapus."));
    }


}
