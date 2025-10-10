package dev.brites.CadastroDeClubes.business.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {

    private LocalDateTime time;
    private int status;
    private String error;
    private String message;

}
