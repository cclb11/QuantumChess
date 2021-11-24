package Tablero;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class Tablero {

    JFrame frame=new JFrame();
    
    public Tablero()throws IOException{      
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

            }

        };
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

   
    }
     
}
