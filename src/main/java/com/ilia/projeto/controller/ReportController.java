package com.ilia.projeto.controller;


import com.ilia.projeto.models.Report;
import com.ilia.projeto.service.PointService;
import com.ilia.projeto.service.ReportService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor_ =  {@Autowired})
public class ReportController {

    private final ReportService reportService;

    @ApiOperation(value = "reports")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna se a solicitação foi confirmada ou não"),
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/by-month/{month}")
    public ResponseEntity<?> callReportByMonth(@PathVariable("month") String month) {
        try{
            return new ResponseEntity(this.reportService.reportByMonth(month), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

}
