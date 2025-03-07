import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    private int id;
    private String descripcion;
    private Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void addExit(String direccion, int idUbicacion) {
        exits.put(direccion, idUbicacion);
    }

    public void printExits() {
        for (Map.Entry<String, Integer> entry : exits.entrySet()) {
            System.out.print(entry.getKey() + ", ");
        }
    }
}
