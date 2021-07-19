import java.io.IOException;

import br.com.local.ziphelper.ZipSingleFile;

public class ZipFile {

	public static void main(String[] args) throws IOException {
		
		ZipSingleFile zipSingle = new ZipSingleFile();
		zipSingle.createZip();
	}

}
