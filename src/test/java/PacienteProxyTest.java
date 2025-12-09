import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PacienteProxyTest {

    @BeforeEach
    void setUp() {
        BaseDadosHospital.addPaciente(new Paciente(1, "João Silva", 30, "Gripe Severa"));
        BaseDadosHospital.addPaciente(new Paciente(2, "Maria Oliveira", 45, "Fratura no Braço"));
    }

    @Test
    void deveRetornarDadosGeraisPaciente() {
        PacienteProxy paciente = new PacienteProxy(1);

        assertEquals(Arrays.asList("João Silva", "30"), paciente.obterDadosGerais());
    }

    @Test
    void deveRetornarDiagnosticoPaciente() {
        ProfissionalSaude medico = new ProfissionalSaude("Dr. Ana", true);
        PacienteProxy paciente = new PacienteProxy(2);

        assertEquals("Fratura no Braço", paciente.obterDiagnostico(medico));
    }

    @Test
    void deveRetornarExcecaoProfissionalNaoAutorizadoConsultarDiagnostico() {
        try {
            ProfissionalSaude enfermeiro = new ProfissionalSaude("Enfermeiro Bob", false);
            PacienteProxy paciente = new PacienteProxy(2);

            paciente.obterDiagnostico(enfermeiro);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Acesso negado: Apenas médicos podem consultar diagnósticos.", e.getMessage());
        }
    }
}