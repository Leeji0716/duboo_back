package com.example.demo.Repository;

import com.example.demo.Entity.Bolt;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoltRepository extends JpaRepository<Bolt, Long> {
    List<Bolt> findByFloor(Long floor, Sort sort);
}
