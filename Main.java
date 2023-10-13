import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase que representa un vuelo
class Vuelo {
    private String origen;
    private String destino;
    private String horaSalida;
    private String horaLlegada;
    private boolean esInternacional;

    public Vuelo(String origen, String destino, String horaSalida, String horaLlegada, boolean esInternacional) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.esInternacional = esInternacional;
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

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public boolean esInternacional() {
        return esInternacional;
    }
}

class Pasajero {
    private String nombre;
    private String apellido;

    public Pasajero(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

class Reservacion {
    private Pasajero pasajero;
    private Vuelo vuelo;

    public Reservacion(Pasajero pasajero, Vuelo vuelo) {
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
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
        gestionVuelos.agregarVuelo(new Vuelo("Nueva York", "Los Ángeles", "08:00 AM", "10:00 AM", true));
        gestionVuelos.agregarVuelo(new Vuelo("Chicago", "Miami", "10:30 AM", "12:30 PM", false));

        System.out.print("Ingrese origen del vuelo: ");
        String origen = scanner.nextLine();
        System.out.print("Ingrese destino del vuelo: ");
        String destino = scanner.nextLine();
        scanner.close();
        
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

