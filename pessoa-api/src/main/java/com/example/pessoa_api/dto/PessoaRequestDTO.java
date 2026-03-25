package com.example.pessoa_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

public record PessoaRequestDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        String email,

        LocalDate dataNascimento,

        List<String> telefones
) {}
