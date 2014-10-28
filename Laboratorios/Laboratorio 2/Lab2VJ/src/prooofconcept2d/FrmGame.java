/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame implements KeyListener {
    //private Thread t;
    private CanvasDib c;
    private BasicPlayer player;
    
    public FrmGame(CanvasDib c){
    	addKeyListener( this );  // permitir al marco procesar eventos de teclas
        this.c = c;
        add(c);
        c.repaint();
        player = new BasicPlayer();
        try {
        	 AbrirFichero("C://Users//YadJh//Documents//Kepler//Lab1VJ//src//prooofconcept2d//sound//vive.mp3");
        	 Play();
        } catch (Exception ex) {
        	  System.out.println("Error: " + ex.getMessage());
        }
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
    	//Reglas
    	switch (evento.getKeyCode()){
    		
    		//case KeyEvent.VK_UP:
    			//c.setY(c.getY()-3);
    			//break;
    		//case KeyEvent.VK_DOWN:
    			//c.setY(c.getY()+3);
    			//break;
    		//Avanzar izquierda
    		case KeyEvent.VK_LEFT:
    			if (validaCoord(0,c.getX())) c.setX(c.getX()-2);
    			break;
    		//Avanzar derecha
    		case KeyEvent.VK_RIGHT:
    			if (validaCoord(1,c.getX())) c.setX(c.getX()+2);
    			break;
    		//Saltar 
    		case KeyEvent.VK_Y:
    			System.out.println("Saltar "+c.getX());
    			switch (c.getX()){
    				case 240: 
    					c.setX(508);
    					break;
    				case 810: 
    					c.setX(1104);
    					break;
    				case 508: 
    					c.setX(240);
    					break;
    				case 1104: 
    					c.setX(810);
    					break;
    			}
    			
    			break;
    		default:
    			repaint=false;
    	}	
	    if (repaint) c.repaint();
    }
    
    public boolean validaCoord(int l, int x){
    	boolean sig=true;
    	System.out.println("X: "+x);
    	switch(l){
    		case 0:
    			if (x<0) sig=false;
    			if (x== 508) sig=false;
    			if (x== 1104) sig=false;
    			break;
    		case 1: 
    			if (x>1216) sig=false;
    			if (x== 240) sig=false;
    			if (x== 810) sig=false;
    			break;
    	}
    	
    	System.out.println("Sig: "+sig);
    	return sig;
    }

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	public void Play() throws Exception {
		  player.play();
	}
		 
	public void AbrirFichero(String ruta) throws Exception {
		  player.open(new File(ruta));
	}
		 
}
