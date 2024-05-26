public class BloqueMemoria {

    // Atributos
    private Proceso procesoAsignado;
    private int tamano;

    // Constructor
    public BloqueMemoria(int tamano) {
        this.tamano = tamano;
        this.procesoAsignado = null;
    }

    // Método para agregar un proceso
    public void agregarProceso(Proceso proceso) {
        if (this.procesoAsignado == null) {
            this.procesoAsignado = proceso;
        } else {
            System.out.println("El bloque de memoria ya tiene un proceso asignado.");
        }
    }

    // Método para liberar un proceso
    public void liberarProceso() {
        if (this.procesoAsignado != null) {
            this.procesoAsignado = null;
        } else {
            System.out.println("No hay ningún proceso asignado para liberar.");
        }
    }

    // getter y setter para el tamaño y proceso asignado
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public Proceso getProcesoAsignado() {
        return procesoAsignado;
    }

    public void setProcesoAsignado(Proceso procesoAsignado) {
        this.procesoAsignado = procesoAsignado;
    }

    //toString para representar el estado del bloque de memoria
    @Override
    public String toString() {
        return "BloqueMemoria{" +
                "procesoAsignado=" + (procesoAsignado != null ? procesoAsignado.toString() : "null") +
                ", tamano=" + tamano +
                '}';
    }
}
