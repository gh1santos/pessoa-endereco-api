package com.example.pessoa_api.controller;

import com.example.pessoa_api.dto.PessoaRequestDTO;
import com.example.pessoa_api.dto.PessoaResponseDTO;
import com.example.pessoa_api.entity.Pessoa;
import com.example.pessoa_api.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> criar(
            @Valid @RequestBody PessoaRequestDTO dto){

        return ResponseEntity.ok(pessoaService.criar(dto));
    }

    @GetMapping
    public Page<Pessoa> listar(Pageable pageable){
        return pessoaService.listar(pageable);
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id){
        return pessoaService.buscar(id);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(
            @PathVariable Long id,
            @RequestBody PessoaRequestDTO dto){

        return pessoaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        pessoaService.deletar(id);
    }
}