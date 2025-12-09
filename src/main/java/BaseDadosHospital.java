import java.util.HashMap;
import java.util.Map;

public class BaseDadosHospital {
    private static Map<Integer, Paciente> pacientes = new HashMap<>();

    public static Paciente getPaciente(Integer id) {
        return pacientes.get(id);
    }

    public static void addPaciente(Paciente paciente) {
        pacientes.put(paciente.getId(), paciente);
    }

    static {
        addPaciente(new Paciente(1, "João Silva", 30, "Gripe Severa"));
        addPaciente(new Paciente(2, "Maria Oliveira", 45, "Fratura no Braço"));
    }
}