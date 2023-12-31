
package com.project.hospital.ApiEspecialidad.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponseDto {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private  Date timestamp;
    private  int code;
    private  String status;
    private  Object message;
    private  String stackTrace;
    
    public ErrorResponseDto(HttpStatus httpStatus,Object message, String stackTrace){
        this.timestamp = new Date();
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
        this.stackTrace = stackTrace;  
    }
    
}
