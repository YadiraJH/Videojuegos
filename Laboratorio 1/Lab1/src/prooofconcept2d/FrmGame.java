/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame implements KeyListener {
    //private Thread t;
    private CanvasDib c;
    public FrmGame(CanvasDib c){
    	addKeyListener( this );  // permitir al marco procesar eventos de teclas
        this.c = c;
        add(c);
        
        //Iniciar hilo
        /*t = new Thread(){
              public void run(){
                  updating();
              }
        };
        t.start();*/
        c.repaint();
     
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    public void updating(){
        while (true){
            try {
                Thread.sleep(100);
                c.repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }
    
 // manejar evento de pulsación de cualquier tecla
    public void keyPressed(KeyEvent evento)
    {
    	boolean repaint=true;
    	switch (evento.getKeyCode()){
    		case KeyEvent.VK_UP:
    			c.setY(c.getY()-3);
    			break;
    		case KeyEvent.VK_DOWN:
    			c.setY(c.getY()+3);
    			break;
    		case KeyEvent.VK_LEFT:
    			c.setX(c.getX()-3);
    			break;
    		case KeyEvent.VK_RIGHT:
    			c.setX(c.getX()+3);
    			break;
    		default:
    			repaint=false;
    	}	
	    if (repaint) c.repaint();
    }

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
