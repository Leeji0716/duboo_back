package com.example.demo.Service;

import com.example.demo.DTO.BoltResponseDTO;
import com.example.demo.DTO.DiffResponseDTO;
import com.example.demo.Entity.Bolt;
import com.example.demo.Entity.Diff;
import com.example.demo.Service.Module.BoltService;
import com.example.demo.Service.Module.DiffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystem;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MultiService {
    private final BoltService boltService;
    private final DiffService diffService;

    /* dateTime */
    private Long dateTimeTransfer(LocalDateTime dateTime) {
        return dateTime == null ? 0 : dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /* diff */
    private List<DiffResponseDTO> getDiffResponseDTOList(List<Diff> diffList) {
        List<DiffResponseDTO> diffResponseDTOS = new ArrayList<>();
        for (Diff diff : diffList){
            diffResponseDTOS.add(
                    DiffResponseDTO.builder()
                            .num(diff.getNum())
                            .ref(diff.getRef())
                            .las(diff.getLas())
                            .diff(diff.getDiff())
                            .build()
                    );
        }
        return diffResponseDTOS;
    }

    public List<DiffResponseDTO> getDiffByFloor(Long floor) {
        List<Diff> diffList = diffService.getList(floor);
        return getDiffResponseDTOList(diffList);
    }

    /* bolt */
    public List<BoltResponseDTO> getBolt(Long floor) {
        List<Bolt> boltList = boltService.getList(floor);
        return getBoltResponseDTOList(boltList);
    }
    private List<BoltResponseDTO> getBoltResponseDTOList(List<Bolt> boltList) {
        List<BoltResponseDTO> boltResponseDTOS = new ArrayList<>();
        for (Bolt bolt : boltList){
            boltResponseDTOS.add(
                    BoltResponseDTO.builder()
                            .num(bolt.getNum())
                            .date(dateTimeTransfer(bolt.getDate()))
                            .distance(bolt.getDistance())
                            .temperature(bolt.getTemperature())
                            .build()
            );
        }
        return boltResponseDTOS;
    }

}
