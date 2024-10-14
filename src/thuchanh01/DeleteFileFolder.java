package thuchanh01;

import java.io.File;
import java.util.Iterator;

public class DeleteFileFolder {
	public static boolean delete(String path) {
		File file = new File(path);
		if (!file.exists())
			return true;
		File[] content = file.listFiles();
		if (content != null)
			for (File f : content) {
				delete(f.getAbsolutePath());
			}
		return file.delete();
	}

	public static void main(String[] args) {
		String nonePath = "D:\\TDC\\DN";
		String filePath = "D:\\Test\\Test1";
		System.out.println(delete(nonePath));
		System.out.println(delete(filePath));
	}
}
