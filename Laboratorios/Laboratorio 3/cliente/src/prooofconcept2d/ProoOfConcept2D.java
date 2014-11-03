package prooofconcept2d;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author servkey
 */
public class ProoOfConcept2D {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {    	
		CanvasDib canvas = new CanvasDib();
		FrmGame fr = new FrmGame(canvas);
		fr.setSize(1370, 700);
		fr.setVisible(true);
		//fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		fr.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				JFrame frame = (JFrame)e.getSource();

				int result = JOptionPane.showConfirmDialog(
						frame,
						"Quieres Salir?",
								"Salir",
								JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION){
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					RestCaller.callRestMethod(RestCaller.methodbyeFrame);
				}
			}
		});
		canvas.setX(8);
		canvas.setY(490);
		canvas.repaint();
	}
}
