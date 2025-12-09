import java.util.Arrays;
import java.util.List;

public class Paciente implements IPaciente {

    private Integer id;
    private String nome;
    private Integer idade;
    private String diagnostico; // Dado sensível

    public Paciente(Integer id) {
        this.id = id;
        Paciente objeto = BaseDadosHospital.getPaciente(id);
        this.nome = objeto.nome;
        this.idade = objeto.idade;
        this.diagnostico = objeto.diagnostico;
    }

    public Paciente(Integer id, String nome, Integer idade, String diagnostico) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.diagnostico = diagnostico;
    }

    @Override
    public List<String> obterDadosGerais() {
        return Arrays.asList(this.nome, String.valueOf(this.idade));
    }

    @Override
    public String obterDiagnostico(ProfissionalSaude profissional) {
        return this.diagnostico;
    }

    public Integer getId() {
        return id;
    }
}