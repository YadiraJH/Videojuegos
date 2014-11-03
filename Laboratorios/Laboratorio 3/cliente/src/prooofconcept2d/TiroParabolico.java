package prooofconcept2d;

public class TiroParabolico {
	
	private static Coordenadas aplicarFuerza (double velocidad,int angulo){
        double radianes=(angulo / 180) * Math.PI;
        int vx = (int) (velocidad*Math.cos(radianes));
        int vy = (int) (-velocidad*Math.sin(radianes));
        Coordenadas coor = new Coordenadas(vx, vy);
        return coor;
    }
	
	public static Coordenadas moverAvatar(int xi, int yi, int tiempoensegundos, double velocidad, int angulo){
		Coordenadas coord = aplicarFuerza(velocidad, angulo);
		int vx = coord.getX();
		int vy = coord.getY();
		int x = (int) xi + (vx*tiempoensegundos);
		int y = (int) (yi + ((vy*tiempoensegundos) + (1/2*(9.8*Math.sqrt(tiempoensegundos)))));
		Coordenadas coor = new Coordenadas(x, y);
        return coor;
	}
}
