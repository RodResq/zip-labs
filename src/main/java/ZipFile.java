import java.io.IOException;

import br.com.local.ziphelper.ZipDirectory;
import br.com.local.ziphelper.ZipMultipleFiles;
import br.com.local.ziphelper.ZipSingleFile;

public class ZipFile {

	public static void main(String[] args) throws IOException {
		
//		ZipSingleFile zipSingle = new ZipSingleFile();
//		zipSingle.createZip();
		
//		ZipMultipleFiles zipMultipleFiles = new ZipMultipleFiles();
//		zipMultipleFiles.createMultiplesZipFiles();
		
		ZipDirectory zipDirectory = new ZipDirectory();
		zipDirectory.zipDirectoryMain();
	}

}
