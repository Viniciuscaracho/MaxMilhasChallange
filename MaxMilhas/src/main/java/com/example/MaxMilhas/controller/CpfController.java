package com.example.MaxMilhas.controller;

import com.example.MaxMilhas.domain.CpfDTO;
import com.example.MaxMilhas.services.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cpf")
public class CpfController {

    @Autowired
    private CpfService cpfService;

    public CpfController(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @PostMapping("/new")
    public ResponseEntity<CpfDTO> createCpf(@RequestBody CpfDTO cpf) {
        CpfDTO savedCpf = cpfService.add(cpf);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCpf);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CpfDTO> findCpf(@PathVariable("cpf") String cpfId) {
        CpfDTO cpf = cpfService.findByCpf(cpfId);
        return ResponseEntity.ok(cpf);
    }

    @GetMapping()
    public ResponseEntity<List<CpfDTO>> findAllCpf() {
        return ResponseEntity.ok(cpfService.findAllCPFs());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deleteCpf(@PathVariable("cpf") String cpfId) {
        CpfDTO cpfEntity = cpfService.findByCpf(cpfId);
        cpfService.deleteCpf(cpfEntity);
        return ResponseEntity.ok("CPF successfully deleted.");
    }
}
