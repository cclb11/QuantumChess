package Tablero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.LinkedList;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 *
 * @author
 */
public class Tablero {

    JFrame frame = new JFrame();
    public static LinkedList<Fichas> ps= new LinkedList<>();//Creamos una lista para almacenar las fichas
    public static Fichas piezaSeleccionada = null;
    
    
    public Tablero()throws IOException{

        BufferedImage fAzul=ImageIO.read(new File("fAzul.png"));//Importamos la imagen de la ficha.
        BufferedImage fRoja=ImageIO.read(new File("fRoja.png"));
        
        Image img[]=new Image[2];//Metemos los dos colores de  fichas en un arreglo
        img[0]=fRoja;
        img[1]=fAzul;
        
        Fichas negra1=new Fichas(1,0,"azul",false,ps);
        Fichas negra2=new Fichas(3,0,"azul",false,ps);
        Fichas negra3=new Fichas(5,0,"azul",false,ps);
        Fichas negra4=new Fichas(7,0,"azul",false,ps);
        Fichas negra5=new Fichas(0,1,"azul",false,ps);
        Fichas negra6=new Fichas(2,1,"azul",false,ps);
        Fichas negra7=new Fichas(4,1,"azul",false,ps);
        Fichas negra8=new Fichas(6,1,"azul",false,ps);
        
        Fichas roja1=new Fichas(1,6,"roja",true,ps);
        Fichas roja2=new Fichas(3,6,"roja",true,ps);
        Fichas roja3=new Fichas(5,6,"roja",true,ps);
        Fichas roja4=new Fichas(7,6,"roja",true,ps);
        Fichas roja5=new Fichas(0,7,"roja",true,ps);
        Fichas roja6=new Fichas(2,7,"roja",true,ps);
        Fichas roja7=new Fichas(4,7,"roja",true,ps);
        Fichas roja8=new Fichas(6,7,"roja",true,ps);
        
        
        
        frame.setTitle("Quantum Chess");
        frame.setSize(512, 512);//Dimenciones del tablero
        frame.setLocation(200, 200);
        frame.setUndecorated(true);//Se eliman los bordes de la ventana (_,❒,X)
        frame.setBackground(Color.BLACK);//Color de fondo
        JPanel panel = new JPanel() {//Dibuja el tablero
            @Override
            public void paint(Graphics g) {
                //Creamos la cuadricula
                int contadorVertical = 0;
                int contadorHorizontal = 0;
                boolean colorBlanco = true;
                for (int j = 0; j < 8; j++) {//Cuadricula Vertical
                    for (int i = 0; i < 8; i++) {//Cuadricula horizontal
                        if (colorBlanco) {
                            g.setColor(Color.WHITE);
                            colorBlanco = false; //El color blanco y negro va cambiando
                        } else {
                            g.setColor(new Color(41,128,185));//Colores en Codigo RGB
                            colorBlanco = true;
                        }
                        g.fillRect(contadorVertical, contadorHorizontal, 64, 64);//Tamaño de cada cuadrito 50*50
                        contadorVertical = contadorVertical + 64;
                    }
                    if (colorBlanco) {//Se cambia el color cada vez que baja de fila.
                        colorBlanco = false;
                    } else {
                        colorBlanco = true;
                    }
                    contadorVertical = 0;//Se reinicia el contador para que vueva a poner colores desde la izquierda.
                    contadorHorizontal = contadorHorizontal + 64;//64 es el tamaño de las cuadro,
                    //asi que debe dejar espacio para cada cuadro.
                }
                
                for (Fichas p:ps) {
                    int indiceImagen=0;
                    if (p.nombreFicha.equalsIgnoreCase("roja")) {
                        indiceImagen=0;
                    }
                    if (p.nombreFicha.equalsIgnoreCase("azul")) {
                        indiceImagen=1;
                    }
                    g.drawImage(img[indiceImagen], p.xp, p.yp, 64, 64, this);
                }
            }

        };

        frame.add(panel);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {//Lugar donde se preciona en el tablero
                System.out.println("Se oprimio la ficha "+getPiece(e.getX(), e.getY()).nombreFicha);
                piezaSeleccionada=getPiece(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {//Cuando se suelta el mouse
                piezaSeleccionada.moverFicha(e.getX()*64,e.getY()*64);
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (piezaSeleccionada!=null) { //Se mueve la ficha al mantener precionado el mouse
                    piezaSeleccionada.xp=e.getX();
                    piezaSeleccionada.yp=e.getY();
                    frame.repaint();
                    System.out.println(e.getX()+" "+e.getY()+" Esta es la nueva posicion");
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

    }
    public static Fichas getPiece(int x, int y){
        
        int xp1=x/64;
        int yp1=y/64;
        for (Fichas p:ps) {
            if ((p.xp)/64==xp1&&((p.yp)/64==yp1)) {
                return p;
            }

            }
        
        return null;
    }
}
