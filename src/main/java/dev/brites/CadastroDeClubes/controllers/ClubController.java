package dev.brites.CadastroDeClubes.controllers;

import dev.brites.CadastroDeClubes.business.services.ClubService;
import dev.brites.CadastroDeClubes.infrastructure.models.ClubModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @PostMapping("/single")
    public ResponseEntity<Void> saveClub(@Valid @RequestBody ClubModel clubModel){
        clubService.saveClub(clubModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/multiple")
    public ResponseEntity<Void> saveAllClubs(@Valid @RequestBody List<ClubModel> clubModelList){
        clubService.saveAllClubs(clubModelList);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ClubModel>> findAllClubs(){
        return ResponseEntity.ok(clubService.findAllClubs());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClubModel> findClubById(@PathVariable Long id){
        return ResponseEntity.ok(clubService.findClubById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ClubModel> findClubByName(@PathVariable String name){
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
