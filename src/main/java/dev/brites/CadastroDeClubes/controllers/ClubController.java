package dev.brites.CadastroDeClubes.controllers;

import dev.brites.CadastroDeClubes.business.services.ClubService;
import dev.brites.CadastroDeClubes.infrastructure.entities.ClubModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @PostMapping
    public ResponseEntity<Void> saveClub(@RequestBody ClubModel clubModel){
        clubService.saveClub(clubModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClubModel> findClubByName(@RequestParam String name){
        return ResponseEntity.ok(clubService.findClubByName(name));
    }

    @PutMapping
    public ResponseEntity<Void> updateClubById(@RequestParam Long id, @RequestBody ClubModel clubModel){
        clubService.updateClubById(id, clubModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteClubByName(@RequestParam String name){
        clubService.deleteClubByName(name);
        return ResponseEntity.ok().build();
    }


}
