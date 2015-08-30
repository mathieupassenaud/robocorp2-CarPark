package detectionParking;

import java.io.IOException;
import java.net.MalformedURLException;

import obj.Camera;
import obj.Etage;
import obj.Parking;

public class Main {
	static String keyParking="ag9zfnJvYm9jb3JwLTEwMDhyGQsSB1BhcmtpbmciDFBhcmtpbmcgQ05BTQw";
	public static void main (String args[]) throws MalformedURLException, IOException{
		Parking parking = null;
		String repertoireDebug = "";
		if(args!=null){
			if(args[0]!=null && args[1]!=null && args[2]!=null && Boolean.parseBoolean(args[0]) && args[1]!=null && args[2]!=null){
				parking = Util.chargerParkingLocal(keyParking, args[1]);
				repertoireDebug=args[2];
			}else{
				System.out.println("Paramêtres du mode debug : true \"Chemin du fichier JSON\" \"Chemin de stockage des images\"");
			}
		}else{
			parking = Util.chargerParking(keyParking);
		}
		for(Etage etage:parking.getEtages()){
			for(Camera camera:etage.getCameras()){
				Traitement thread = new Traitement(camera, parking.getKey(), etage, repertoireDebug);
				thread.start();
			}
		}
	}

}