package com.example.demo.Controller;

import com.example.demo.DTO.BoltResponseDTO;
import com.example.demo.Service.MultiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bolt")
public class BoltController {
    private final MultiService multiService;

    @GetMapping
    public ResponseEntity<?> BoltGet(@RequestHeader("floor") Long floor) {
        List<BoltResponseDTO> boltResponseDTOList = multiService.getBolt (floor);
        return ResponseEntity.status (HttpStatus.OK).body (boltResponseDTOList);
    }
}
