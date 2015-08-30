package detectionParking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import obj.Parking;
import obj.Place;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Util {
	public static Parking chargerParking(String key) throws MalformedURLException,
	IOException {
		Gson gson = new GsonBuilder().create();
		URL url = new URL("http://1-dot-robocorp-1008.appspot.com/api/parking/get/"+key);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		Parking parking = gson.fromJson(reader, Parking.class);
		return parking;
	}


	public static Parking chargerParkingLocal(String key, String adresseParkingLocal) throws MalformedURLException,
	IOException {
		Gson gson = new GsonBuilder().create();
		Path path = Paths.get(adresseParkingLocal);
		byte[] texte = Files.readAllBytes(path);
		Parking parking = gson.fromJson(new String(texte), Parking.class);
		return parking;
	}

	public static boolean mettreAJourPlace(String idParking, String idEtage, Place place) {
		HttpResponse response = null;
		if(idParking.equals("0")){
			System.out.println("Est place occupée : "+place.isFree());
			return false;
		}else{
			Gson gson = new GsonBuilder().create();
			try{
			URI url = new URI("http://1-dot-robocorp-1008.appspot.com/api/places/update/"+idParking+"/"+idEtage);
			HttpPost post = new HttpPost(url);
			HttpClient httpClient = HttpClientBuilder.create().build();
			gson.toJson(place);
			StringEntity postingString =new StringEntity(gson.toJson(place));//convert your pojo to   json
			post.setEntity(postingString);
			post.setHeader("Content-type", "application/json");
			response = httpClient.execute(post);
			
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response.getStatusLine().getStatusCode()==204;
		}
	}
}
