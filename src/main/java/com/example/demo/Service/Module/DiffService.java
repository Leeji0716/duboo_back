package com.example.demo.Service.Module;

import com.example.demo.Entity.Diff;
import com.example.demo.Repository.DiffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiffService {
    private final DiffRepository diffRepository;
    public Diff get(Long floor, Long num) {
        return diffRepository.findByFloorAndNum(floor, num);
    }

    public List<Diff> getList(Long floor) {
        Sort sort = Sort.by(Sort.Order.asc("num")); // num 컬럼 기준 오름차순 정렬
        return diffRepository.findByFloor(floor, sort);
    }
}
