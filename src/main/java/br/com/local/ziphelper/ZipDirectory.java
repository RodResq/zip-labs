package br.com.local.ziphelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirectory {
	
	
	public void zipDirectoryMain() throws IOException {
		
		String sourceFile = "src/main/resources/zipTest";
		
		FileOutputStream fos = new FileOutputStream("src/main/resources/dirCompress.zip");
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		
		File fileToZip = new File(sourceFile);
		
		zipFile(fileToZip, fileToZip.getName(), zipOut);
		zipOut.close();
		fos.close();
	}

	private static void zipFile(final File fileToZip, final String fileName, final ZipOutputStream zipOut) throws IOException {
		
		if (fileToZip.isHidden()) {
			return;
		};
		
		if(fileToZip.isDirectory()) {
			if(fileName.endsWith("/")) {
				zipOut.putNextEntry(new ZipEntry(fileName));
				zipOut.closeEntry();
			} else {
				zipOut.putNextEntry(new ZipEntry(fileName + "/"));
				zipOut.closeEntry();
			}
			File[] children = fileToZip.listFiles();
			for (File childFile : children) {
				zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
			}
			return;
		}
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zipOut.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		fis.close();
		
	
	}	

}
