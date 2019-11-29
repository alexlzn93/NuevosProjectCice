package cice.master.java.internet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import cice.master.java.Base;

public final class Descarga {

	public static void getWebArchivo(String enlaceWeb, String nombreArchivo) {
		getWebArchivo(enlaceWeb, new File(nombreArchivo));
	}
	
	public static void getWebArchivo(String enlaceWeb, File nombreArchivo) { //
		System.out.println("Descargando: " + enlaceWeb);
		try { //puede haber una excepcion que sea que la url sea incorrecta
			URL url = new URL(enlaceWeb); //creada la url  
			//if (url.getProtocol().equals("https"))
				//activarSocketSSL();
			HttpURLConnection urlConexion = (HttpURLConnection) url.openConnection(); // .openConecction abrir la conexion
			urlConexion.addRequestProperty("User-Agent", Base.USER_AGENT); //addRequestProperty quien solicita el recurso
			urlConexion.setReadTimeout(Base.RETARDO_MILISEGUNDOS);
			urlConexion.connect();
			InputStream documento = urlConexion.getInputStream();
			FileOutputStream guardar = new FileOutputStream(nombreArchivo);
			byte[] array = new byte[Base.BYTES];
			int leido = 0;
			while ((leido = documento.read(array)) > 0) {
				guardar.write(array, 0, leido);
				guardar.flush();
			}
			documento.close();
			guardar.close();
		} catch (Exception ioe) {
		}
	}

	private static void activarSocketSSL() throws KeyManagementException, NoSuchAlgorithmException {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}

	public static String getHtml(String enlaceWeb) {
		StringBuilder texto = new StringBuilder("");
		try {
			URL url = new URL(enlaceWeb);
			if (url.getProtocol().equals("https"))
				activarSocketSSL();
			URLConnection urlConexion = url.openConnection();
			urlConexion.setRequestProperty("User-Agent", Base.USER_AGENT);
			urlConexion.setReadTimeout(Base.RETARDO_MILISEGUNDOS);
			urlConexion.connect();
			BufferedReader pagina = new BufferedReader(new InputStreamReader(urlConexion.getInputStream()), Base.BYTES);
			String linea;
			while ((linea = pagina.readLine()) != null)
				texto.append(linea);
			pagina.close();
		} catch (Exception e) {
		}
		return texto.toString();
	}

	public static String encodeUrl(String enlaceWeb) {
		String encoded = "";
		try {
			encoded = URLEncoder.encode(enlaceWeb, "UTF-8").replaceAll("\\+", "%2B");
		} catch (Exception e) {
		}
		return encoded;
	}

	public static String decodeUrl(String enlaceWeb) {
		String decoded = "";
		try {
			decoded = URLDecoder.decode(enlaceWeb, "UTF-8");
		} catch (Exception e) {
		}
		return decoded;
	}
	
}
