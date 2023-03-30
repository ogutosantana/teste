package teste.unimed.api.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name= "medicos")
@Entity(name = "Médico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico() {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false)
        @NotBlank
        private String nome;

        @Column(nullable = false)
        @DateTimeFormat
        private LocalDate dataNascimento;

        @Column(nullable = false)
        private Boolean ativo;

        @ManyToMany
        @JoinTable(name = "medico_especialidade",
                joinColumns = @JoinColumn(name = "medico_id"),
                inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
        @NotNull
        @Valid
        private List<Especialidade> especialidades = new ArrayList<>();

        public Medico(Medico medico) {
                this.nome = medico.nome;
                this.dataNascimento = medico.nome;
                this.ativo = medico.ativo;
                this.especialidades = new Especialidade(medico.especialidades);
        }

        public void atualizarMedico(DadosAtualizarMedicoMedico med) {
                if (med.nome() != null) {
                        this.nome = med.nome;
                }
                if (med.dataNascimento() != null) {
                        this.dataNascimento = med.nome;
                }
                if (med.ativo() != null) {
                        this.ativo = med.ativo;
                }
                if (med.especialidaes() != null) {
                        this.especialidades.atualizarEspecialidades(med.especialidades);
                }
        }

        public void excluir() {
                this.ativo = Boolean.FALSE;
        }



        // Getters e Setters
}
