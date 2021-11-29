package Tablero;

import java.util.LinkedList;



/**
 *
 * @author Cristian Camilo López Bernal
 */
public class Fichas {

    int xp;
    int yp;
    boolean isWhite;
    String nombreFicha;
    LinkedList<Fichas> ps;

    public Fichas(int xp, int yp,String nombreFicha, boolean isWhite,LinkedList<Fichas> ps) {
        this.xp = xp*64;
        this.yp = yp*64;
        
        this.isWhite = isWhite;
        this.nombreFicha=nombreFicha;
        ps.add(this);
    }
    
    public void moverFicha(int xp,int yp){
        ps.stream().filter(p -> (p.xp==xp&&p.yp==yp)).forEachOrdered(p -> {
            p.kill();
        });
        this.xp=xp;
        this.yp=yp;
    }
    public void kill(){
        ps.remove();
    }
    
    
}
