package com.ilia.projeto.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ilia.projeto.service.ProjectService;

import java.util.UUID;

@RestController
@RequestMapping("/projetoIlia")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor_ =  {@Autowired})
public class ProjectController {

    private final ProjectService projectService;

    @ApiOperation(value = "Atribuir horas ao projeto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Horas alocadas ao projeto"),
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/alocar-horas/{id}/{hours}")
    public ResponseEntity<?> allocateTimeInProject(@PathVariable("id") Long id, @PathVariable("hours") Long hours) {
        return new ResponseEntity(this.projectService.allocateTimeInProject(id, hours), HttpStatus.OK);
    }


}
