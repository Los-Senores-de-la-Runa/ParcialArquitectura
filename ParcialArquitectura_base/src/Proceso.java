import java.util.ArrayList;

public class Proceso {
    private static int contadorId = 0;
    private int id;
    private int tamanio;

    public Proceso() {
    }

    public Proceso(int tamanio) {
        this.id = ++contadorId;
        this.tamanio = tamanio;
    }

    public int getId() {
        return id;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return id + " " + tamanio;
    }

    public static Proceso crearProceso(int tamanio) {
        Proceso proceso = new Proceso(tamanio);
        return proceso;
    }

    public static void eliminarProcesoPorId(int id, ArrayList<Proceso> procesos) {
        Proceso procesoEliminado = null;
        for (Proceso proceso : procesos) {
            if (proceso.getId() == id) {
                procesoEliminado = proceso;
                break;
            }
        }

        if (procesoEliminado != null) {
            procesos.remove(procesoEliminado);
            System.out.println("Se elimino el proceso " + procesoEliminado.getId());
        }else {
            System.out.println("Proceso no encontrado.");
        }
    }

    public static void listarProcesos(ArrayList<Proceso> procesos) {
        for (Proceso proceso : procesos) {
            System.out.println(proceso.toString());
        }
    }

}
