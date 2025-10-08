package dev.brites.CadastroDeClubes.controllers;

import dev.brites.CadastroDeClubes.business.services.LeagueService;
import dev.brites.CadastroDeClubes.infrastructure.entities.LeagueModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/league")
@RequiredArgsConstructor
public class LeagueController {

    private final LeagueService leagueService;

    @PostMapping("/single")
    public ResponseEntity<Void> saveLeague(@RequestBody LeagueModel leagueModel){
        leagueService.saveLeague(leagueModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/multiple")
    public ResponseEntity<Void> saveAllLeagues(@RequestBody List<LeagueModel> leagueModelList){
        leagueService.saveAllLeagues(leagueModelList);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id")
    public ResponseEntity<LeagueModel> findLeagueById(@RequestParam Long id){
        return ResponseEntity.ok(leagueService.findLeagueById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<LeagueModel> findLeagueByName(@RequestParam String name){
        return ResponseEntity.ok(leagueService.findLeagueByName(name));
    }

    @PutMapping
    public ResponseEntity<Void> updateLeagueById(@RequestParam Long id, @RequestBody LeagueModel leagueModel){
        leagueService.updateLeagueById(leagueModel, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLeagueByName(@RequestParam String name){
        leagueService.deleteLeagueByName(name);
        return ResponseEntity.ok().build();
    }
}
