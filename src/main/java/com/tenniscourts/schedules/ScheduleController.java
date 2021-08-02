package com.tenniscourts.schedules;

import com.tenniscourts.config.BaseRestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
public class ScheduleController extends BaseRestController {

    private final ScheduleService scheduleService;

    //TODO: implement rest and swagger

    @ApiOperation(value = "schedule a tennis court", notes="add tennis court schedule",nickname = "schedule tennis court")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = ScheduleController.class) })
            @ApiResponse(code = 201, message = "Created")
    @PostMapping(value = "/schedule/tennis-courts")
    public ResponseEntity<Void> addScheduleTennisCourt(@RequestBody CreateScheduleRequestDTO createScheduleRequestDTO) {

        return ResponseEntity.created(locationByEntity(scheduleService.addSchedule(createScheduleRequestDTO.getTennisCourtId(), createScheduleRequestDTO).getId())).build();
    }

    //TODO: implement rest and swagger

    @ApiOperation(value = "tennis court schedules by dates", notes="find tennis court schedules by start date and end date",nickname = "find tennis court schedule by dates")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = ScheduleController.class) })
    @GetMapping(value = "/schedule/tennis-court-by-dates")
    public ResponseEntity<List<ScheduleDTO>> findSchedulesByDates(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                  @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return ResponseEntity.ok(scheduleService.findSchedulesByDates(LocalDateTime.of(startDate, LocalTime.of(0, 0)), LocalDateTime.of(endDate, LocalTime.of(23, 59))));
    }

    //TODO: implement rest and swagger

    @ApiOperation(value = "tennis court schedule ", notes="find tennis court schedule by schedule id",nickname = "find tennis court by schedule id")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = ScheduleController.class) })
    @GetMapping(value = "/schedule/tennis-court-by-id")
    public ResponseEntity<ScheduleDTO> findByScheduleId(@QueryParam("scheduleId") Long scheduleId) {

        return ResponseEntity.ok(scheduleService.findSchedule(scheduleId));
    }
}
