package resourceLoader;

import java.io.InputStream;


public class ResourceLoader {
	
	static ResourceLoader rl = new ResourceLoader();
	
	public static InputStream load(String filename){
		InputStream is = rl.getClass().getResourceAsStream("data/" + filename);
		return is;
	}
}
