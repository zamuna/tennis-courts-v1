package com.tenniscourts.tenniscourts;

import com.tenniscourts.config.BaseRestController;
<<<<<<< HEAD
import com.tenniscourts.schedules.ScheduleController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.ws.rs.QueryParam;
=======
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
>>>>>>> f6ab42249b6f6db1f62f964344dd357ee150b39c

@AllArgsConstructor
public class TennisCourtController extends BaseRestController {

    private final TennisCourtService tennisCourtService;

    //TODO: implement rest and swagger
<<<<<<< HEAD
    @ApiOperation(value = "add tennis court", notes="add tennis court",nickname = "add tennis court")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = ScheduleController.class) })
    @ApiResponse(code = 201, message = "Created")
    @PostMapping(value = "/tennis-courts/add")
=======
>>>>>>> f6ab42249b6f6db1f62f964344dd357ee150b39c
    public ResponseEntity<Void> addTennisCourt(TennisCourtDTO tennisCourtDTO) {
        return ResponseEntity.created(locationByEntity(tennisCourtService.addTennisCourt(tennisCourtDTO).getId())).build();
    }

    //TODO: implement rest and swagger
<<<<<<< HEAD
    @ApiOperation(value = "find tennis court", notes="find tennis court schedule",nickname = "find tennis court")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = ScheduleController.class) })
    @GetMapping(value = "/tennis-court/{tennisCourtId}")
    public ResponseEntity<TennisCourtDTO> findTennisCourtById(@PathVariable Long tennisCourtId) {
=======
    public ResponseEntity<TennisCourtDTO> findTennisCourtById(Long tennisCourtId) {
>>>>>>> f6ab42249b6f6db1f62f964344dd357ee150b39c
        return ResponseEntity.ok(tennisCourtService.findTennisCourtById(tennisCourtId));
    }

    //TODO: implement rest and swagger
<<<<<<< HEAD
    @ApiOperation(value = "find schedules of this tennis court", notes="find schedule for this tennis court",nickname = "find schedules for this tennis court")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = ScheduleController.class) })
    @GetMapping(value = "/tennis-court/schedule/{tennisCourtId}")
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(@QueryParam("tennisCourtId") Long tennisCourtId) {
=======
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(Long tennisCourtId) {
>>>>>>> f6ab42249b6f6db1f62f964344dd357ee150b39c
        return ResponseEntity.ok(tennisCourtService.findTennisCourtWithSchedulesById(tennisCourtId));
    }
}
