package com.yazici.huaweitask.service.park;

import com.yazici.huaweitask.entity.Park;
import com.yazici.huaweitask.repository.ParkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkWriteService {

    private final ParkRepository parkRepository;

    @Transactional
    public Park save(Park park) {
        log.info("Park entity created {}", park);
        return parkRepository.save(park);
    }
}
