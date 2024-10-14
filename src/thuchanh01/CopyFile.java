package thuchanh01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	public static void copyFile(String source, String destination) throws IOException {
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos = new FileOutputStream(destination);
		byte[] data = new byte[102400];
		int byteread;
		long bt = System.currentTimeMillis();
		while ((byteread = fis.read(data)) != -1) {
			fos.write(data, 0, byteread);
				
		}
		long et = System.currentTimeMillis();
		fis.close();
		fos.close();
		System.out.println("Done in "+ (et - bt) + " ms");
	}
	public static void main(String[] args) {
		String filePath = "D:\\Test";
	}
}
