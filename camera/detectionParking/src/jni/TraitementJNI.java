package jni;

import obj.Blob;

public class TraitementJNI {
	private static TraitementJNI singleton = null;
	public static TraitementJNI getInstance() {
		if (singleton == null) {
			singleton = new TraitementJNI();
		}
		return singleton;
	}

	static {
		System.loadLibrary("gestionCamera");
	}
	public native void lancerCapture(String camera, String repertoireImages, boolean debug);
	public native Blob[] getBlobs(String camera);
}
