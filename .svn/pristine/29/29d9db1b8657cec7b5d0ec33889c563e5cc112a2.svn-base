package Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {

	@SuppressWarnings("null")
	public static String loadFileAsString(String path){
		String map = "";
		Scanner inScanner = null;
		try {
			inScanner = new Scanner(new File(path));
			while(inScanner.hasNextLine()){
				map += inScanner.nextLine();
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			inScanner.close();
		}
		return map;
	}
	
}
