package teste.unimed.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import teste.unimed.api.medico.DadosAtualizarMedico;
import teste.unimed.api.medico.DadosMedico;
import teste.unimed.api.medico.Medico;
import teste.unimed.api.medico.MedicoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @Transactional
    public Medico criarMedico(@RequestBody Medico medico) {
        repository.save(new Medico(medico);
        return medico;
    }

    @GetMapping
    public List<DadosMedico> listarMedicos() {
        return repository.findAllByAtivoTrue().stream().map(DadosMedico::new).toList();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    @PutMapping("/{id}")
    public void atualizarMedico(@PathVariable Long id, @RequestBody @Valid DadosAtualizarMedico medico) {
        var doc:Medico = repository.getReferenceById();
        if (repository.findById(id) = null) {
            repository.orElseThrow() -> new MedicoNaoEncontradoException(id));
        }
        doc.atualizarMedico(medico);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirLogicaMedico(@PathVariable Long id) {
        var doc:Medico = repository.getReferenceById(id);
        medico.excluir();
    }

}