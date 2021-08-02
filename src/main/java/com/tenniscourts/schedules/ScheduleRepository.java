package com.tenniscourts.schedules;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> f6ab42249b6f6db1f62f964344dd357ee150b39c
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByTennisCourt_IdOrderByStartDateTime(Long id);
<<<<<<< HEAD
    List<Schedule> findByStartDateTimeAndEndDateTime(LocalDateTime startTime, LocalDateTime endTime);
=======
>>>>>>> f6ab42249b6f6db1f62f964344dd357ee150b39c
}