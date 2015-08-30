package obj;

public class Blob {
	private Point pointHautGauche;
	private Point pointBasDroite;

	public Blob(){
	}
	
	public Blob(int pointHautGaucheX, int pointHautGaucheY, int pointBasDroiteX, int pointBasDroiteY){
		pointHautGauche=new Point(pointHautGaucheX, pointHautGaucheY);
		pointBasDroite=new Point(pointBasDroiteX, pointBasDroiteY);
	}

	public Point getBaricentre() {
		return null;
	}
	public Point getPointHautGauche() {
		return pointHautGauche;
	}
	public void setPointHautGauche(Point pointHautGauche) {
		this.pointHautGauche = pointHautGauche;
	}
	public Point getPointBasDroite() {
		return pointBasDroite;
	}
	public void setPointBasDroite(Point pointBasDroite) {
		this.pointBasDroite = pointBasDroite;
	}
	public String toString(){
		return "X1:"+pointHautGauche.getX()+" Y1:"+pointHautGauche.getY() + " " +"X2:"+pointBasDroite.getX()+" Y2:"+pointBasDroite.getY();	
	}
}
