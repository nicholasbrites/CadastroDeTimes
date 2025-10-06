package dev.brites.CadastroDeClubes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClubController {

    @GetMapping("/teste")
    public String boasVindar(){
        return "Caso essa mensagem apareça, parabéns!";
    }

}
