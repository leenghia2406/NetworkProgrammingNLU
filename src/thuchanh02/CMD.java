package thuchanh02;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CMD {
	File defaultDir;
	BufferedReader userIn;
	boolean quit = false;
	public CMD(String initDir) {
		this.defaultDir = new File(initDir);
		this.userIn = new BufferedReader(new InputStreamReader(System.in));
	}
	public void run() {
		String line;
		String res;
		//show prompt
		System.out.println(getPrompt());
		//loop
		while(!quit) {
		//get user commmand line
			line = getUserCommand();
		//execute
			res = executeCommand(line);
		//show result
			System.out.println(res);
		//show prompt
			System.out.println(getPrompt());
		}
	}
	private String executeCommand(String line) {
		// TODO Auto-generated method stub
		String res = "";
		String com = "";
		String param = "";
		if (line.trim().isEmpty()) return "";
		StringTokenizer st = new StringTokenizer(line);
		com = st.nextToken().toUpperCase();
		if(st.hasMoreElements()) param = st.nextToken();
		switch (com) {
		case "EXIT":
			quit = true;
			break;
		case "CD":
			res = changeDir(param);
			break;
		case "DIR":
			res = lisFolder();
			break;
		}
		return res;
	}
	private String lisFolder() {
		// TODO Auto-generated method stub
		File[] content = defaultDir.listFiles();
		List<File> folders = new ArrayList<File>();
		List<File> files = new ArrayList<File>();
		for(File f : content) {
			if (f.isDirectory()) folders.add(f); else files.add(f);
		}
		StringBuilder sb = new StringBuilder();
		for(File f : folders) {
			sb.append(f.getName().toUpperCase()+ "\n");
		}
		for(File f : files) {
			sb.append(f.getName().toLowerCase()+ "\n");
		}
		return sb.toString();
	}
	private String changeDir(String param) {
		// TODO Auto-generated method stub
		String res = "";
		if(param.isBlank()) return defaultDir.getAbsolutePath();
		if("..".equals(param)) { //return to parent
			File temp = defaultDir.getParentFile();
			if (temp!= null) defaultDir = temp;
				
		}else { // change to child
			File temp = new File(defaultDir, param);
			if(temp.exists()) {
				defaultDir = temp;
			} else {
				res = "Subfolder: "+param+ " not exist";
			}
		}
		return res;
	}
	private String getUserCommand() {
		// TODO Auto-generated method stub
		try {
			return userIn.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	private String getPrompt() {
		// TODO Auto-generated method stub
		return defaultDir.getAbsolutePath()+ ">";
	}
	public static void main(String[] args) {
		String initDir = "D:\\TEMP\\LTM";
		
		new CMD(initDir).run();
	}
}
