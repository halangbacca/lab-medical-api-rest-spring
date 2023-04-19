package br.senai.LABMedical.services;

import br.senai.LABMedical.dtos.AtualizaExames;
import br.senai.LABMedical.dtos.ExameDTO;
import br.senai.LABMedical.dtos.ListagemExames;
import br.senai.LABMedical.models.Exame;
import br.senai.LABMedical.repositories.ExameRepository;
import org.springframework.stereotype.Service;

@Service
public class ExameService {
    private final ExameRepository repository;

    public ExameService(ExameRepository repository) {
        this.repository = repository;
    }

    public void cadastra(ExameDTO exameDTO) {
        Exame exame = new Exame(exameDTO);
        repository.save(exame);
    }

    public ListagemExames busca(Long id) {
        var exame = repository.getReferenceById(id);
        return new ListagemExames(exame);
    }

    public void deleta(Long id) {
        repository.deleteById(id);
    }

    public void atualiza(AtualizaExames exameAtualizado, Long id) {
        Exame exame = repository.findById(id).orElseThrow(RuntimeException::new);

        if (exameAtualizado.nome() != null && !exameAtualizado.nome().isEmpty()) {
            exame.setNome(exameAtualizado.nome());
        }

        if (exameAtualizado.tipo() != null && !exameAtualizado.tipo().isEmpty()) {
            exame.setTipo(exameAtualizado.tipo());
        }

        if (exameAtualizado.laboratorio() != null && !exameAtualizado.laboratorio().isEmpty()) {
            exame.setLaboratorio(exameAtualizado.laboratorio());
        }

        if (exameAtualizado.pdf() != null && !exameAtualizado.pdf().isEmpty()) {
            exame.setPdf(exameAtualizado.pdf());
        }

        if (exameAtualizado.resultados() != null && !exameAtualizado.resultados().isEmpty()) {
            exame.setResultados(exameAtualizado.resultados());
        }

        repository.save(exame);
    }

}
