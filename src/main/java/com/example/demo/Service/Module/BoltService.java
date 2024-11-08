package com.example.demo.Service.Module;

import com.example.demo.Entity.Bolt;
import com.example.demo.Entity.Diff;
import com.example.demo.Repository.BoltRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoltService {
    private final BoltRepository boltRepository;

    public List<Bolt> getList(Long floor) {
        Sort sort = Sort.by(Sort.Order.asc("date"), Sort.Order.asc("num"));
        return boltRepository.findByFloor(floor, sort);
    }
}
