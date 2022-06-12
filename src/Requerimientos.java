//Requerimiento 1

import java.util.ArrayList;
import java.util.List;

 class Usuario{
    private List<Guardarropas> guardarropas;

    public void agregarGuardarropas(Guardarropas guardarropas){
        this.guardarropas.add(guardarropas);
    }
    public void quitarGuardarropas(Guardarropas guardarropas){
        this.guardarropas.remove(guardarropas);
    }
}
 class Guardarropas{
    private List<Prenda> prendas = new ArrayList<Prenda>();
}
 class Prenda
{
    //....
}

//Requerimiento 3

 class Guardarropas{
    private List<Atuendo> prendas = new ArrayList<Atuendo>();

    public void aceptar(Propuestas propuesta){
        propuesta.ropaParaAgregar(this.prendas);
    }
    public void agregarPrenda(Atuendo atuendo){
        prendas.add(atuendo);
    }
    public void quitarPrenda(Atuendo atuendo){
        prendas.remove(atuendo);
    }
}

 class Propuestas{
    private List<Atuendo> prendas = new ArrayList<>();

    public void ropaParaAgregar(List<Atuendo> atuendos){
        prendas.stream().map(atuendo-> prendas.add(atuendo));
    }
    public void ropaParaQuitar(List<Atuendo> atuendos){
        prendas.stream().map(atuendo-> prendas.remove(atuendo));
    }
}
 class Atuendo
{
    List<Prenda> atuendos = new ArrayList<Prenda>();

    public void agregarAtuendo(Prenda prenda) {
        atuendos.add(prenda);
    }
}

//Requerimiento 4

 class Usuario{
    public Propuestas propuestas;
    //El usuario conoce las propuestas hechas
}

//Requerimiento 5


 abstract class PropuestaModificacion{
    Prenda prenda;
    Estado estado;
    public void deshacerEn(Guardarropas guardarropas){

    }
    public enum Estado{
        APROBADA,RECHAZADA,PENDIENTE;
    }
}
class PropuestaAceptada extends PropuestaModificacion {
     @Override
    public void deshacerEn(Guardarropas guardarropas) {
        guardarropas.quitarPrenda(this.prenda);
    }
}
class PropuestaRechazada extends PropuestaModificacion {

    @Override
    public void deshacerEn(Guardarropas guardarropas) {
        guardarropas.agregarPrenda(this.prenda);
    }
}
