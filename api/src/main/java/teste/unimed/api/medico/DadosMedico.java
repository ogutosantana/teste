package teste.unimed.api.medico;

public record DadosMedico(Long id, String nome, Especialidade especialidade) {

    public DadosMedico (Medico medico){
        this(medico.getId(), medico.getNome(), (Especialidade) medico.getEspecialidades());
    }
}
