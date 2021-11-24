package Tablero;

import Fichas.Fichas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class Tablero {

    JFrame frame=new JFrame();
    LinkedList<Fichas> lista=new LinkedList<Fichas>();
   
    
    public Tablero()throws IOException{
        
        for (int i = 1; i < 6; i++) {//Se añaden las fichas a un LinkedList
            switch(i){
                case 1:
                    Fichas f1=new Fichas(lista,"fichas\\black\\alfil-negro.png",50,50);
                case 2:
                    Fichas f2=new Fichas(lista,"fichas\\black\\caballo-negro.png",50,50);
                case 3:
                    Fichas f3=new Fichas(lista,"fichas\\black\\peon-negro.png",50,50);
                case 4:
                    Fichas f4=new Fichas(lista,"fichas\\black\\reina-negro.png",50,50);   
                case 5:
                    Fichas f5=new Fichas(lista,"fichas\\black\\rey-negro.png",50,50);
                case 6:
                    Fichas f6=new Fichas(lista,"fichas\\black\\torre-negro.png",50,50);   
            }
 
        }
        
        frame.setTitle("Quantum Chess");
        frame.setSize(400, 400);//Dimenciones del tablero
        frame.setLocationRelativeTo(null);//El tablero aparece en el centro
        frame.setUndecorated(true);//Se eliman los bordes de la ventana (_,❒,X)
        frame.setBackground(Color.BLACK);//Color de fondo
        JPanel panel=new JPanel(){//Dibuja el tablero
            @Override
            public void paint(Graphics g){//Creamos la cuadricula
                int contadorVertical=0;
                int contadorHorizontal=0;
                boolean colorBlanco=true;
                for (int j = 0; j < 8; j++) {//Cuadricula Vertical
                    for (int i = 0; i < 8;i++) {//Cuadricula horizontal
                        if (colorBlanco) {
                            g.setColor(Color.WHITE);
                            colorBlanco=false; //El color blanco y negro va cambiando
                        }else{
                            g.setColor(Color.black);
                            colorBlanco=true;
                        }
                        g.fillRect(contadorVertical, contadorHorizontal, 50, 50);//Tamaño de cada cuadrito 50*50
                        contadorVertical=contadorVertical+50;
                    }
                    if (colorBlanco) {//Se cambia el color cada vez que baja de fila.
                        colorBlanco=false;
                    }else{
                        colorBlanco=true;
                    }
                    contadorVertical=0;//Se reinicia el contador para que vueva a poner colores desde la izquierda.
                    contadorHorizontal=contadorHorizontal+50;//50 es el tamaño de las cuadro,
                                                             //asi que debe dejar espacio para cada cuadro.
                }
                try {
                    BufferedImage negro1=ImageIO.read(new File(lista.get(0).getNombre()));
                    g.drawImage(negro1, 50, 50,50,50 ,this);
                } catch (Exception e) {
                    System.err.println("hola");//TODO
                }
            }

        };
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

   
    }
     
}
