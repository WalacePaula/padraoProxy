public class ProfissionalSaude {
    private String nome;
    private boolean medico;

    public ProfissionalSaude(String nome, boolean medico) {
        this.nome = nome;
        this.medico = medico;
    }

    public String getNome() {
        return nome;
    }

    public boolean isMedico() {
        return medico;
    }
}