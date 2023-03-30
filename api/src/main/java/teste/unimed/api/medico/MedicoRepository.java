package teste.unimed.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Object getReferenceById();

    Page<Medico> findAllByAtivoTrue();

    void orElseThrow();
}
