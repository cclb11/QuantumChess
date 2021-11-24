package Fichas;

import java.util.LinkedList;

/**
 *
 * @author Cristian Camilo López Bernal
 */
public class Fichas {
    
    int x;
    int y;
    LinkedList<Fichas> listaFichas;
    String nombre;

    public Fichas(LinkedList<Fichas> listaFichas,String nombre,int x, int y){
        this.nombre=nombre;
        this.x = x;
        this.y = y;
        listaFichas.add(this);
    } 

    public String getNombre() {
        return nombre;
    }
    
    
    public void posicion(int x, int y){
        
    }
    
    
    
    
}
