package teste.unimed.api.medico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Embedded
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Especialidade {

    @Id
    @NotBlank
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @Column(nullable = false)
    private Boolean ativo;

    public Especialidade(List<Especialidade> especialidade) {
        this.nome = especialidade.nome;
        this.descricao = especialidade.descricao;
        this.ativo = especialidade.ativo;
    }

    public void atualizarEspecialidades(Especialidade esp) {
        if(esp.nome() != null) {
            this.nome = esp.getNome();
        }
        if(esp.descricao() != null) {
            this.descricao = esp.getDescricao();
        }
        if(esp.ativo() != null) {
            this.ativo = esp.getAtivo();
        }

// Getters e Setters

}
