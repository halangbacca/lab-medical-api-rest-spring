package br.senai.LABMedical.models;

import br.senai.LABMedical.dtos.ExameDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exames")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    private String tipo;
    private String laboratorio;
    private String pdf;
    private String resultados;
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.EAGER)
    private Paciente paciente;

    public Exame(ExameDTO exameDTO) {
        this.nome = exameDTO.getNome();
        this.dataHora = exameDTO.getDataHora();
        this.tipo = exameDTO.getTipo();
        this.laboratorio = exameDTO.getLaboratorio();
        this.pdf = exameDTO.getPdf();
        this.resultados = exameDTO.getResultados();
        this.usuario = new Usuario(exameDTO.getUsuario_id());
        this.paciente = new Paciente(exameDTO.getPaciente_id());
    }

}
