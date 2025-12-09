import java.util.List;

public class PacienteProxy implements IPaciente {

    private Paciente paciente;
    private Integer id;

    public PacienteProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosGerais() {
        if (this.paciente == null) {
            this.paciente = new Paciente(this.id);
        }
        return this.paciente.obterDadosGerais();
    }

    @Override
    public String obterDiagnostico(ProfissionalSaude profissional) {
        if (!profissional.isMedico()) {
            throw new IllegalArgumentException("Acesso negado: Apenas médicos podem consultar diagnósticos.");
        }
        if (this.paciente == null) {
            this.paciente = new Paciente(this.id);
        }
        return this.paciente.obterDiagnostico(profissional);
    }
}