package com.alterra.demofullapp.controller;

import com.alterra.demofullapp.entity.Kota;
import com.alterra.demofullapp.repository.KotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KotaController {

    @Autowired
    private KotaRepository kotaRepository;

    @GetMapping("/kota")
    public List<Kota> getAll() {
        List<Kota> kotas = kotaRepository.findAll();
        return kotas;
    }

    @PostMapping("/kota")
    public Kota save(@RequestBody Kota kota) {
        kotaRepository.save(kota);
        return kota;
    }

    @GetMapping("/kota/{id}")
    public Kota getById(@PathVariable("id") Long id) {
        try {
            Kota kota = kotaRepository.findById(id).get();
            return kota;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/kota/{id}")
    public Kota update(@RequestBody Kota kota, @PathVariable("id") Long id) {
        kota.setId(id);
        kotaRepository.save(kota);
        return kota;
    }

    @DeleteMapping("/kota/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            kotaRepository.deleteById(id);
            return String.format("{\"message\":\"success deleted\",\"status\":\"200\"}");
        } catch (Exception e) {
            return String.format("{\"message\":\"Kota not Found\",\"status\":\"404\"}");
        }
    }

}
