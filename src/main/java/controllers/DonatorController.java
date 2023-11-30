package controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import models.DonatoretChangeStatusDto;
import models.DonatoretDto;
import services.DonatoretService;

@RestController
@RequestMapping("api/donatoret")
@CrossOrigin(origins = "*")
public class DonatorController {
    private final DonatoretService donatorService;

    public DonatorController(DonatoretService service) {
        this.donatorService = service;
    }

    @GetMapping
    public List<DonatoretDto> getAllDonatores() {
        return donatorService.getAll();
    }

    @GetMapping("/{id}")
    public DonatoretDto getDonatorById(@PathVariable long id) {
        return donatorService.getById(id);
    }

    @PostMapping
    public void addDonator(@RequestBody DonatoretDto donatorDto) {
        donatorService.add(donatorDto);
    }

    @PutMapping("/{id}")
    public void updateDonator(@PathVariable long id, @RequestBody DonatoretDto donatorDto) {
        donatorService.update(id, donatorDto);
    }

    @PatchMapping("/{id}")
    public void updateDonatorStatus(@PathVariable long id, @RequestBody DonatoretChangeStatusDto donatorDto) {
        donatorService.changeStatus(id, donatorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDonatorById(@PathVariable long id) {
        donatorService.deleteById(id);
    }
}