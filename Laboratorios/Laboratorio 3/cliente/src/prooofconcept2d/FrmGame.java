/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
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
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Thread t;
    private CanvasDib c;
    private BasicPlayer player;
    private int idimg;
    private String idFrame = "";
    
    public FrmGame(CanvasDib c){
    	addKeyListener( this );  // permitir al marco procesar eventos de teclas
        this.c = c;
        add(c);
        c.repaint();
        player = new BasicPlayer();
        idFrame = RestCaller.callRestMethod(RestCaller.methodRegistrarse);
        iniciaTimer(c, idFrame);
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
    
 // manejar evento de pulsaci�n de cualquier tecla
    public void keyPressed(KeyEvent evento)
    {
    	if(c.isShowavatar()){
    		boolean repaint=true;
    		idimg=c.getIdimg();
    		//Reglas
    		switch (evento.getKeyCode()){
    		case KeyEvent.VK_LEFT:
    			if (validaCoord(0,c.getX())){ 
    				c.setX(c.getX()-2);
    				c.setIdimg(idimg+1);
    			}
    			break;
    			//Avanzar derecha
    		case KeyEvent.VK_RIGHT:
    			//System.out.println("X:"+c.getX());
    			if (validaCoord(1,c.getX())){
    				c.setX(c.getX()+2);
    				c.setIdimg(idimg+1);
    			}
    			break;
    			//Saltar 
    		case KeyEvent.VK_SPACE:
    			/*int segs = 0;
    			while(true){
    				Coordenadas coord= TiroParabolico.moverAvatar(c.getX(), c.getY(), segs, 10, 45);
    				c.setX(coord.getX());
    				c.setY(coord.getY());
    				segs++;
    				c.repaint();
    				if(segs==10)
    					break;
    				
    			}*/
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
    }
    
    public boolean validaCoord(int l, int x){
    	boolean sig=true;
    	switch(l){
    		case 0:
    			if (x<0){ 
    				RestCaller.callRestMethod(RestCaller.methodSaliendoStageIzq);
    				c.setShowavatar(false);
    				c.repaint();
    				//idFrame = RestCaller.callRestMethod(RestCaller.methodRegistrarse);
    			}
    			if (x== 508)  sig=false;
    			if (x== 1104) sig=false;
    			break;
    		case 1: 
    			if (x>1216){
    				RestCaller.callRestMethod(RestCaller.methodSaliendoStageDer);
    				c.setShowavatar(false);
    				c.repaint();
    				//idFrame = RestCaller.callRestMethod(RestCaller.methodRegistrarse);
    			}
    			if (x== 240) sig=false;
    			if (x== 810) sig=false;
    			break;
    	}
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
	
	public static void iniciaTimer(final CanvasDib c, String idFr){
		// Clase en la que est? el c?digo a ejecutar 
		final String IdFrameAux = idFr;
		TimerTask timerTask = new TimerTask() 
		{ 
			public void run()  
			{ 
				if(!c.isShowavatar()){
				String cad=RestCaller.callRestMethod(RestCaller.methodWhoHasAvatar);
				if(cad!=null && !cad.equals("")){
					String[] cadArr = cad.split(",");
					String idRes = cadArr[0];
					String dir = cadArr[1];
					System.out.println("id's:"+IdFrameAux+", "+idRes);
					if(idRes.equals(IdFrameAux)){
						boolean b= true;
						if(dir.contains("dere")){
							c.setX(1218);
							c.setY(490);
							dir="";
						}else if(dir.contains("izq")){
							c.setX(8);
							c.setY(490);
							dir="";
						}
						c.setShowavatar(true);
					}
					else{
						c.setShowavatar(false);
					}
					c.repaint();
				}			
				}
			} 
		}; 
		Timer timer = new Timer(); 
		timer.scheduleAtFixedRate(timerTask, 0, 10000);
	}
		 
}
