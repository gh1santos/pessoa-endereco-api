package com.example.pessoa_api.service;

import com.example.pessoa_api.dto.PessoaRequestDTO;
import com.example.pessoa_api.dto.PessoaResponseDTO;
import com.example.pessoa_api.entity.Pessoa;
import com.example.pessoa_api.exception.ResourceNotFoundException;
import com.example.pessoa_api.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaResponseDTO criar(PessoaRequestDTO dto){

        if(pessoaRepository.findByCpf(dto.cpf()).isPresent()){
            throw new RuntimeException("CPF já cadastrado");
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setNome(dto.nome());
        pessoa.setCpf(dto.cpf());
        pessoa.setEmail(dto.email());
        pessoa.setDataNascimento(dto.dataNascimento());
        pessoa.setTelefones(dto.telefones());

        Pessoa salva = pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(
                salva.getId(),
                salva.getNome(),
                salva.getCpf(),
                salva.getEmail(),
                salva.getDataNascimento(),
                salva.getTelefones()
        );
    }

    public Page<Pessoa> listar(Pageable pageable){
        return pessoaRepository.findAll(pageable);
    }

    public Pessoa buscar(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));
    }

    public Pessoa atualizar(Long id, PessoaRequestDTO dto){

        Pessoa pessoa = buscar(id);

        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setDataNascimento(dto.dataNascimento());
        pessoa.setTelefones(dto.telefones());

        return pessoaRepository.save(pessoa);
    }

    public void deletar(Long id){
        pessoaRepository.deleteById(id);
    }

}
