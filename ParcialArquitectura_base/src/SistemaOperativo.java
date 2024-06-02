import java.util.ArrayList;

public class SistemaOperativo {
    private MemoryManagerUnity memoryManagerUnity;
    private Proceso sistemaOperativo = new Proceso(250, "Sistema Operativo");


    public SistemaOperativo() {
        Memoria memoria = new Memoria(1000);
        this.memoryManagerUnity = memoryManagerUnity=new MemoryManagerUnity(memoria,sistemaOperativo);
    }

    public MemoryManagerUnity getMemoryManagerUnity() {
        return memoryManagerUnity;
    }

    public void setMemoryManagerUnity(MemoryManagerUnity memoryManagerUnity) {
        this.memoryManagerUnity = memoryManagerUnity;
    }

    public void enviarListaEspera(Proceso procesoEnviar){

        this.memoryManagerUnity.agregarProcesoListaEspera(procesoEnviar);
    }
    public void iniciar(){
        memoryManagerUnity.a();
    }
    public void crearProceso(){
        Proceso proceso1 = new Proceso(45,"Zoom");
        enviarListaEspera(proceso1);
        Proceso proceso2 = new Proceso(150,"Chrome");
        enviarListaEspera(proceso2);
        Proceso proceso3 = new Proceso(78,"Spotify");
        enviarListaEspera(proceso3);
        Proceso proceso4 = new Proceso(132,"IntelliJ IDEA");
        enviarListaEspera(proceso4);
        Proceso proceso5 = new Proceso(110,"Slack");
        enviarListaEspera(proceso5);
        Proceso proceso6 = new Proceso(53,"Excel");
        enviarListaEspera(proceso6);
        Proceso proceso7 = new Proceso(190,"Firefox");
        enviarListaEspera(proceso7);
        Proceso proceso8 = new Proceso(67,"Microsoft Word");
        enviarListaEspera(proceso8);
        Proceso proceso9 = new Proceso(45,"Steam");
        enviarListaEspera(proceso9);
        Proceso proceso10 = new Proceso(175,"Photoshop");
        enviarListaEspera(proceso10);
        Proceso proceso11 = new Proceso(85,"Teams");
        enviarListaEspera(proceso11);
        Proceso proceso12 = new Proceso(99,"Notion");
        enviarListaEspera(proceso12);
        Proceso proceso13 = new Proceso(200,"Illustrator");
        enviarListaEspera(proceso13);
        Proceso proceso14 = new Proceso(160,"Dropbox");
        enviarListaEspera(proceso14);
        Proceso proceso15 = new Proceso(140,"PowerPoint");
        enviarListaEspera(proceso15);
        Proceso proceso16 = new Proceso(173,"Skype");
        enviarListaEspera(proceso16);
        Proceso proceso17 = new Proceso(31,"OneDrive");
        enviarListaEspera(proceso17);
        Proceso proceso18 = new Proceso(88,"Evernote");
        enviarListaEspera(proceso18);
        Proceso proceso19 = new Proceso(150,"Visual Studio Code");
        enviarListaEspera(proceso19);
        Proceso proceso20 = new Proceso(60,"Discord");
        enviarListaEspera(proceso20);

    }
}
