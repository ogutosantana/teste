import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MedicoNaoEncontradoException extends RuntimeException {

    public MedicoNaoEncontradoException(Long id) {
        super("Médico não encontrado com o ID " + id);
    }
}
