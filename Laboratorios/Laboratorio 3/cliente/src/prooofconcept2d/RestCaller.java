package prooofconcept2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestCaller {
	
	public static String UrlServer="http://192.168.1.74:4567/";
	public static String methodRegistrarse = "registrarse";
	public static String methodWhoHasAvatar = "whoHasAvatar";
	public static String methodSaliendoStageIzq = "saliendoStage?direccion=izquierda";
	public static String methodSaliendoStageDer = "saliendoStage?direccion=derecha";
	public static String methodSaliendoStageNone = "saliendoStage?direccion=ninguna";
	public static String methodbyeFrame = "byeFrame?direccion=izquierda";

	public static String callRestMethod(String metodo) {
		String salida="";
		try {
			System.out.println("Metodo: "+metodo);
			URL url = new URL(UrlServer+metodo);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				salida="-1";
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println("output server: "+output);
				salida+=output;
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
			salida="-1";

		} catch (IOException e) {

			e.printStackTrace();
			salida="-1";

		} catch (Exception e) {

			e.printStackTrace();
			salida="-1";

		}
		return salida;

	}
 
}

