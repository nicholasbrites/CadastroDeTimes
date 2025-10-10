package dev.brites.CadastroDeClubes.business.exceptions;

public class MissingFieldException extends RuntimeException{

    public MissingFieldException(String message) {
        super(message);
    }
}
