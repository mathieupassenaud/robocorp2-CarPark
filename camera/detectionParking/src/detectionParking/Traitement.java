package detectionParking;

import java.util.ArrayList;

import obj.Blob;
import obj.Camera;
import obj.Etage;
import obj.Place;
import obj.Point;
import jni.TraitementJNI;

public class Traitement extends Thread {
	private String idParking;
	private String repertoireImages;
	private Etage etage;
	private Camera camera;
	ArrayList<Place> bufferPlaces=new ArrayList<Place>();
	public Traitement(Camera camera, String idParking, Etage etage, String repertoireImages){
		this.etage = etage;
		this.idParking = idParking;
		this.repertoireImages = repertoireImages;
		this.camera = camera;
	}


	@Override
	public void run() {
		try {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					TraitementJNI.getInstance().lancerCapture(camera.getAdresse(),repertoireImages, true);
				}
			});
			thread.start();
			while(true){
				//Vider le buffer si y'a qque chose
				if(!bufferPlaces.isEmpty()){
					for(Place place:bufferPlaces){
						boolean retour = Util.mettreAJourPlace(idParking, etage.getKey(), place);
						if(!retour){
							break;
						}else{
							bufferPlaces.remove(place);
						}
					}
				}
				Blob[] listeBlobs=TraitementJNI.getInstance().getBlobs(camera.getAdresse());
				if(listeBlobs!=null){
					for(Blob pointBlob:listeBlobs){
						//On vérifie si le point correspond à une place visible
						//et on calcule si elle est occupée
						if(pointBlob!=null){
							System.out.println(pointBlob.toString());
							gererOccupation(pointBlob);
						}
					}
				}
				Thread.sleep(40);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void gererOccupation(Blob pointBlob) {
		if(!idParking.equals("0")){
			Camera cam = camera;
			//Pour chaque place on calcule ses coordonnées sur l'image
			//On regarde si elle est dans le champ de vision de la caméra
			//On regarde si un des blobs occupe le repère de la place
			for(Place place:etage.getPlaces()){
				if(isPlaceVisibleParCam(cam, place)){
					if(isPlaceChangeEtat(place, pointBlob)){
						//Si on a perdu la liaision avec le serveur on bufferise
						if(!Util.mettreAJourPlace(idParking, etage.getKey(), place)){
							bufferPlaces.add(place);
						}
					}
				}
			}
		}
	}

	private boolean isPlaceChangeEtat(Place place, Blob pointBlob) {
		boolean placeChangeEtat=false;
		if(place.isFree()){
			if(repereContenuDansBlob(place.getPoint().getX(),place.getPoint().getY(), pointBlob)){
				place.setFree(false);
				placeChangeEtat=true;
			}
		}else{
			//"Loin" est à determiner mais on calcule d'abord si le blob est loin
			//de la place. Si il est loin on n'a rien de plus à calculer
			if(repereContenuDansBlob(place.getPoint().getX(),place.getPoint().getY(), pointBlob)){
				if(place.getBlob()==null){
					//Un blob viens de s'activer sur la place
					//Je le stocke pour pouvoir le comparer au suivant
					place.setBlob(pointBlob);
				}
			}else if(place.getBlob()!=null && distanceEntre2Points(place.getPoint().getX(), pointBlob.getBaricentre().getX(),
					place.getPoint().getY(), pointBlob.getBaricentre().getY())<10){
				//J'avais detecté un blob et il est sorti
				//Du repère de la place
				place.setBlob(null);
				place.setFree(true);
				placeChangeEtat=true;
			}
		}
		return placeChangeEtat;
	}

	private double distanceEntre2Points(double xA, double xB, double yA, double yB) {
		return Math.sqrt(Math.pow(xA-xB, 2)+Math.pow(yA-yB, 2));
	}

	private boolean isPlaceVisibleParCam(Camera cam, Place place) {
		if(idParking.equals("0")){
			// Mode debug avec fichier chargé depuis le disque
			int x, y; //Coordonnées du centre de la place sur l'image
			int ax = 3600;
			int ay = 10500;
			int bz = 12;
			int az = 12000;
			x=ax*(bz/az);
			y=ay*(bz/az);
			System.out.println("x:"+x+" y:"+y);
			return true;
		}else{
			int x, y; //Coordonnées du centre de la place sur l'image
			int ax = Math.abs((int) (cam.getPoint().getX()-place.getPoint().getX()));
			int ay = Math.abs((int) (cam.getPoint().getY()-place.getPoint().getY()));
			int bz = cam.getFocal();
			int az = (int) (Math.sqrt((Math.pow(cam.getHauteur(),2)+Math.pow(ay,2))));
			x=ax*(bz/az);
			y=ay*(bz/az);

			//Place visible sur 28 cm de large et à partir de 15 cm de haut par rapport
			//à l'image sur une feuille
			//A calibrer par caméra
			if((x<1 || x>280)||(y<1 || y>15)){
				return false;
			}else{
				place.setPointLocal(new Point(x, y));
				return true;
			}
		}
	}
	public boolean repereContenuDansBlob(double x, double y, Blob blob){
		//Le blob est contenu dans un rectangle toujours horizontal
		//Du coup la règle est simple pour savoir si un point est inclus dans
		//le périmètre d'un Rectangle

		//X compris entre le X du point haut gauche et le X du point bas droite
		//Y compris entre le Y du point haut gauche et le Y du point bas droite
		return (x>=blob.getPointHautGauche().getX() && x<=blob.getPointBasDroite().getX()) &&
				(y>=blob.getPointBasDroite().getY() && y<=blob.getPointHautGauche().getY());
	}
}
