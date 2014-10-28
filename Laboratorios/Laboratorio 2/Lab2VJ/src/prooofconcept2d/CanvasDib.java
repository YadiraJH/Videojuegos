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

//Poner toda la pantalla automaticamente
//disminuir el tamaño del lion y aumentar la del paisaje
//agregar animales staticos (coordenadas estaticas)
//si el lion llega a esas coordenadas no dejarlo pasar 

public class CanvasDib extends Canvas{
    
    private int x = 8;
    private int y = 557;
    private BufferedImage fondo;
    private BufferedImage subject;
    
    public CanvasDib(){
    	fondo = cargarImagen("./images/sabana-africana.png");
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
        subject = cargarImagen("./images/gatito.png");
        g.drawImage(subject, x, y, this);
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
    
        
}
