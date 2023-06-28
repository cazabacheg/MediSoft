package com.project.hospital.apiclient;

import com.project.hospital.dto.CitaDto;
import com.project.hospital.model.Cita;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
@FeignClient(name = "APICITA")
@RefreshScope

public interface ApiCitaClient {

    @GetMapping("/api/cita/findCitasByDate")
    public List<CitaDto> findCitasByDate(
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-mm-yyyy") Date fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-mm-yyyy") Date fechaFin);

    @GetMapping("/api/cita/findCitasByUserId/{id}")
    List<CitaDto> findCitasByUserId(@PathVariable int id);

    @PostMapping("/api/cita/add")
    public Cita add(@RequestBody Cita cita);
}
