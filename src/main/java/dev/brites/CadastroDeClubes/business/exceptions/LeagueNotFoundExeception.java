package dev.brites.CadastroDeClubes.business.exceptions;

public class LeagueNotFoundExeception extends RuntimeException{

    public LeagueNotFoundExeception(String message){
        super(message);
    }
}
