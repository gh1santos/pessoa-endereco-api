package com.example.pessoa_api.dto;

public record EnderecoDTO(

        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep,
        Boolean principal

) {}