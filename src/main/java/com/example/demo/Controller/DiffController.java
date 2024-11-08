package com.example.demo.Controller;

import com.example.demo.DTO.BoltResponseDTO;
import com.example.demo.DTO.DiffResponseDTO;
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
@RequestMapping("/api/diff")
public class DiffController {
    private final MultiService multiService;

    @GetMapping // diff 가져오기
    public ResponseEntity<?> BoltGet(@RequestHeader("floor") Long floor) {
        List<DiffResponseDTO> diffResponseDTOList = multiService.getDiffByFloor (floor);
        return ResponseEntity.status (HttpStatus.OK).body (diffResponseDTOList);
    }
}
