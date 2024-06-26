public class BloqueMemoria {

    // Atributos
    private Proceso procesoAsignado;
    private double tamanio_bloque;

    // Constructor
    public BloqueMemoria(double tamano) {
        this.tamanio_bloque = tamano;
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
    public double getTamano() {
        return tamanio_bloque;
    }

    public void setTamano(double tamano) {
        this.tamanio_bloque = tamano;
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
                ", tamano=" + tamanio_bloque +
                '}';
    }
}
