package dev.brites.CadastroDeClubes.business.exceptions;

public class ClubNotFoundException extends RuntimeException{

    public ClubNotFoundException(String message){
        super(message);
    }
}
