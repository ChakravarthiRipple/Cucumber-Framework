package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtile {
		private FileUtile() {

		}

		public static FileUtile objforfileutil() {
			FileUtile prop = new FileUtile();
			return prop;
		}

		
		public String readDatafromPropfile(String key) throws IOException {
			FileInputStream fis = new FileInputStream(IAutoconstant.propfilepath);
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key);

		}

		public String readDatafromPropfile(String key, String path) throws IOException {
			FileInputStream fis = new FileInputStream(path);
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key);

		}

	

}