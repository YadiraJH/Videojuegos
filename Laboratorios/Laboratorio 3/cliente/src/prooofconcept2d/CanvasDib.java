/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author servkey
 */
public class CanvasDib extends Canvas{
    
    private int x;
    private int y;
    private BufferedImage fondo;
    private BufferedImage subject;
    private boolean showavatar;
    private int idimg;

	public CanvasDib(){
    	fondo = cargarImagen("./images/sabana-africana.png");
    	showavatar=false;
    	idimg=0;
    }
    
    private BufferedImage cargarImagen(String file){
        BufferedImage img = null;
        try{
            URL image = getClass().getResource(file);
            img = ImageIO.read(image);
        }catch(Exception e){
        }
         return img;
    }
    
    @Override
    public void paint(Graphics g)
    {       
    	g.drawImage(fondo, 0, 0, this);
    	if (showavatar){
    		subject = cargarImagen("./lion/walk/"+idimg+".png");    		
    		g.drawImage(subject, x, y, this);
    	}
    }   
    

    @Override
    public void update(Graphics g)
    {
        super.update(g);
        paint(g);
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean isShowavatar() {
		return showavatar;
	}

	public void setShowavatar(boolean showavatar) {
		this.showavatar = showavatar;
	}
        
	public int getIdimg() {
		return idimg;
	}

	public void setIdimg(int idimg) {
		if (idimg>4) 
			this.idimg = 0;
		else 
			this.idimg = idimg;
	}
}
