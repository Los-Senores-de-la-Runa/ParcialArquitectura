import java.util.ArrayList;
import java.util.Random;

public class Proceso {

    private static int contadorId = 0;
    private String nombre;
    private int id;
    private double tamanio;
    private Random r = new Random();

    public Proceso() {
    }

    public Proceso(int tamanio, String nombre) {
        this.id = ++contadorId;
        this.tamanio = tamanio;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return id + " " + tamanio;
    }

    public static Proceso crearProceso(int tamanio, String nombre) {
        Proceso proceso = new Proceso(tamanio, nombre);
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

    public String getNombre() {
        return nombre;
    }
    public boolean esNull(){
        return nombre==null;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean duracion(){
        int validacion1 = r.nextInt(10)+1;
        int validacion2 = r.nextInt(10)+1;
        if (validacion1 == validacion2){
            return true;
        } else {
            return false;
        }
    }
}
