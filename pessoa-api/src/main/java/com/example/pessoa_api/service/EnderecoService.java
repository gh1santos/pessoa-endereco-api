package com.example.pessoa_api.service;

import com.example.pessoa_api.dto.EnderecoDTO;
import com.example.pessoa_api.entity.Endereco;
import com.example.pessoa_api.entity.Pessoa;
import com.example.pessoa_api.exception.ResourceNotFoundException;
import com.example.pessoa_api.repository.EnderecoRepository;
import com.example.pessoa_api.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    public Endereco criar(Long pessoaId, EnderecoDTO dto){

        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));

        if(Boolean.TRUE.equals(dto.principal())){

            pessoa.getEnderecos()
                    .forEach(e -> e.setPrincipal(false));
        }

        Endereco endereco = new Endereco();

        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setCep(dto.cep());
        endereco.setPrincipal(dto.principal());

        endereco.setPessoa(pessoa);

        return enderecoRepository.save(endereco);
    }

    public void deletar(Long enderecoId){
        enderecoRepository.deleteById(enderecoId);
    }
}