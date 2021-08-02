package com.tenniscourts.schedules;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.tenniscourts.TennisCourt;
import com.tenniscourts.tenniscourts.TennisCourtMapper;
import com.tenniscourts.tenniscourts.TennisCourtRepository;
import com.tenniscourts.tenniscourts.TennisCourtService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper;

    private final TennisCourtRepository tennisCourtRepository;
    private final TennisCourtMapper tennisCourtMapper;

    public ScheduleDTO addSchedule(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) {
        //TODO: implement addSchedule
        createScheduleRequestDTO.setTennisCourtId(tennisCourtId);

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setTennisCourtId(tennisCourtId);
        scheduleDTO.setStartDateTime(createScheduleRequestDTO.getStartDateTime());
        scheduleDTO.setEndDateTime(createScheduleRequestDTO.getStartDateTime().plusHours(1));
        scheduleDTO.setTennisCourt(tennisCourtMapper.map(tennisCourtRepository.findById(tennisCourtId).get()));
       return  scheduleMapper.map((scheduleRepository.saveAndFlush(scheduleMapper.map(scheduleDTO))));


    public List<ScheduleDTO> findSchedulesByDates(LocalDateTime startDate, LocalDateTime endDate) {

        List<Schedule> schedules = scheduleRepository.findByStartDateTimeAndEndDateTime(startDate, endDate);
        return scheduleMapper.map(schedules);

    }

    public ScheduleDTO findSchedule(Long scheduleId) {
        //TODO: implement

        return scheduleRepository.findById(scheduleId).map(scheduleMapper::map).<EntityNotFoundException>orElseThrow(() -> {
            throw new EntityNotFoundException("Schedule not found.");
        });
    }

    public List<ScheduleDTO> findSchedulesByTennisCourtId(Long tennisCourtId) {
        return scheduleMapper.map(scheduleRepository.findByTennisCourt_IdOrderByStartDateTime(tennisCourtId));
    }
}
