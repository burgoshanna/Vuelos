import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase que representa un vuelo
class Vuelo {
    private String origen;
    private String destino;
    private String horaSalida;

    public Vuelo(String origen, String destino, String horaSalida) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }
}

// Clase que gestiona los vuelos
class GestionVuelos {
    private List<Vuelo> vuelos = new ArrayList<>();

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public List<Vuelo> buscarVuelos(String origen, String destino) {
        List<Vuelo> resultados = new ArrayList<>();
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)) {
                resultados.add(vuelo);
            }
        }
        return resultados;
    }
}

public class Main {
    public static void main(String[] args) {
        GestionVuelos gestionVuelos = new GestionVuelos();
        Scanner scanner = new Scanner(System.in);

        // Agregar algunos vuelos
        gestionVuelos.agregarVuelo(new Vuelo("Nueva York", "Los Ángeles", "08:00 AM"));
        gestionVuelos.agregarVuelo(new Vuelo("Chicago", "Miami", "10:30 AM"));

        System.out.print("Ingrese origen del vuelo: ");
        String origen = scanner.nextLine();
        System.out.print("Ingrese destino del vuelo: ");
        String destino = scanner.nextLine();

        List<Vuelo> resultados = gestionVuelos.buscarVuelos(origen, destino);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron vuelos de " + origen + " a " + destino);
        } else {
            System.out.println("Vuelos de " + origen + " a " + destino + ":");
            for (Vuelo vuelo : resultados) {
                System.out.println("Hora de salida: " + vuelo.getHoraSalida());
            }
        }
    }
}