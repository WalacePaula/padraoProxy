import java.util.List;

public interface IPaciente {
    List<String> obterDadosGerais();
    String obterDiagnostico(ProfissionalSaude profissional);
}