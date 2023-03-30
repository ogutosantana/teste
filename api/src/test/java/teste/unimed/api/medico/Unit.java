package teste.unimed.api.medico;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceTest {

    @Autowired
    private DoctorService doctorService;

    @MockBean
    private DoctorRepository doctorRepository;

    @Test
    public void testFindAllDoctors() {
        Medico doctor1 = new Medico("Carlos Santana", LocalDate.of(1980, 1, 1), true);
        Medico doctor2 = new Medico("Augusto Paiva", LocalDate.of(1985, 2, 1), true);

        List<Medico> doctors = Arrays.asList(doctor1, doctor2);
        Mockito.when(doctorRepository.findAll()).thenReturn(doctors);

        assertEquals(2, result.size());
        assertEquals("Carlos Santana", result.get(0).getNome());
        assertEquals("Augusto Paiva", result.get(1).getNome());
    }

    @Test
    public void testSaveDoctor() {
        // Criação do objeto Doctor para o teste
        Medico doctor = new Medico("Carlos Augusto", LocalDate.of(1980, 1, 1), true);

        // Configuração do mock do DoctorRepository para salvar o médico criado acima
        Mockito.when(doctorRepository.save(doctor)).thenReturn(doctor);

        // Execução do método que estamos testando
        Medico result = doctorService.atualizarMedico(doctor);

        // Verificação dos resultados
        assertEquals("Carlos Augusto", result.getNome());
    }
}
