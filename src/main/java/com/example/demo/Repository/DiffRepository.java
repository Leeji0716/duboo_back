package com.example.demo.Repository;

import com.example.demo.Entity.Diff;
import com.example.demo.Service.Module.DiffService;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiffRepository extends JpaRepository<Diff, Long> {
    Diff findByFloorAndNum(Long floor, Long num);

    List<Diff> findByFloor(Long floor, Sort sort);
}
