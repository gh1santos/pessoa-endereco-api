package com.example.pessoa_api.dto;

import java.time.LocalDate;
import java.util.List;

public record PessoaResponseDTO(

        Long id,
        String nome,
        String cpf,
        String email,
        LocalDate dataNascimento,
        List<String> telefones

) {}