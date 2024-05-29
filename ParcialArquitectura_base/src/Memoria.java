public class Memoria {
    private administradorMemoria administradorMemoria;
    private int espacioLibre;
    private int tamanio;
    public Memoria(){
    }
    public Memoria(adminitradorMemoria administradorMemoria,int espacioLibre, int tamanio){
        this.administradorMemoria = administradorMemoria;
        this.espacioLibre = espacioLibre;
        this.tamanio = tamanio;
    }

    public administradorMemoria getAdministradorMemoria() {
        return administradorMemoria;
    }

    public void setAdministradorMemoria(administradorMemoria administradorMemoria) {
        this.administradorMemoria = administradorMemoria;
    }

    public int getEspacioLibre() {
        return espacioLibre;
    }

    public void setEspacioLibre(int espacioLibre) {
        this.espacioLibre = espacioLibre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void liberarEspacio(int espacio){
        if (espacio > tamanio){
            System.out.println("No se puede liberar esa cantidad de espacio");
        }else {
            espacioLibre = espacioLibre-espacio;
        }
    }

    public int obtenerEspacio(){
        return espacioLibre;
    }

    public boolean reservarEspacio(int espacio){
        if (espacio > espacioLibre){
            return false;
        }else {
            espacioLibre = espacioLibre-espacio;
            return true;
        }
    }
}

