package dev.brites.CadastroDeClubes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasVindas")
    public String boasVindar(){
        return "Essa é a minha primeira mensagem nessa rota!";
    }

}
