package teste.unimed.api.medico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarMedico(Long id, String nome, LocalDate dataNascimento, Boolean ativo, Especialidade especialidade) {
    @NotNull
    Long id,
    String nome,
    LocalDate dataNascimento,
    Boolean ativo,
    Especialidade especialidade,
}
