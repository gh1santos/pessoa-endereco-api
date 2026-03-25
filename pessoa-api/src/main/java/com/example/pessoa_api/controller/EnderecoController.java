package com.example.pessoa_api.controller;

import com.example.pessoa_api.dto.EnderecoDTO;
import com.example.pessoa_api.entity.Endereco;
import com.example.pessoa_api.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas/{pessoaId}/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public Endereco criar(
            @PathVariable Long pessoaId,
            @RequestBody EnderecoDTO dto){

        return enderecoService.criar(pessoaId, dto);
    }

    @DeleteMapping("/{enderecoId}")
    public void deletar(@PathVariable Long enderecoId){

        enderecoService.deletar(enderecoId);
    }
}