package OpertaionsUringJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JavaFileHandlings {
	public void CreateFile() throws IOException {
		File files = new File("D:\\RoughWorks\\text.txt");

		if (files.createNewFile()) {
			System.out.println("File created in : " + files.getPath());
		} else {
			System.out.println("File is Already Exist !");
		}
	}

	public static void writeFile() throws IOException {
		FileWriter fileWriter = new FileWriter("D:\\RoughWorks\\text.txt");
		fileWriter.write("This is test File,Files in Java might be tricky, but it is fun enough!");
		System.out.println("Successfully wrote to the file.");
		fileWriter.close();
	}

	public static void readFile() throws FileNotFoundException {
		File file = new File("D:\\RoughWorks\\text.txt");
		Scanner fileScanner = new Scanner(file);
		while (fileScanner.hasNext()) {
			String dataS = fileScanner.nextLine();
			System.out.println(dataS);
		}
		fileScanner.close();
	}

	public static void main(String[] args) throws IOException {
		JavaFileHandlings fileHandlings = new JavaFileHandlings();
		fileHandlings.CreateFile();
		fileHandlings.writeFile();
		fileHandlings.readFile();

	}
}
