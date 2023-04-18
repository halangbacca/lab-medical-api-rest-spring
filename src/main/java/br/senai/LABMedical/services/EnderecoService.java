package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.ListagemEnderecos;
import br.senai.LABMedical.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<ListagemEnderecos> busca() {
        return repository.findAll().stream().map(ListagemEnderecos::new).toList();
    }

}
