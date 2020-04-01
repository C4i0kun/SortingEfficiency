package sortingefficiency;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import java.util.ArrayList;

public class CSVWriter {
	ArrayList<File> csvFiles;
	
	public CSVWriter() throws IOException {
		generateCSVFiles();
	}

	private void generateCSVFiles() throws IOException {
		this.csvFiles = new ArrayList<>();
		
		// Create all files and add them to ArrayList
		File bubbleFile = new File("BubbleFile.csv");
		File insertionFile = new File("InsertionFile.csv");	
		
		csvFiles.add(bubbleFile);
		csvFiles.add(insertionFile);
		
		File heapFile = new File("HeapFile.csv");
		File mergeFile = new File("MergeFile.csv");
		
		csvFiles.add(heapFile);
		csvFiles.add(mergeFile);
		
	}
	
	public void write(String text, String target) throws IOException {
		File file = targetToFile(target);
		
	    FileWriter fileWriter = new FileWriter(file, true);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    printWriter.printf("%s", text);
	    
	    printWriter.close();
	}
	
	public void writeAll(String text) throws IOException {
		write(text, "BubbleFile");
		write(text, "InsertionFile");
		write(text, "HeapFile");
		write(text, "MergeFile");
	}
	
	private File targetToFile(String target) {
		int index = 0;
		
		if (target == "BubbleFile") {
			index = 0;
		} else if (target == "InsertionFile") {
			index = 1;
		} else if (target == "HeapFile") {
			index = 2;
		} else /*if (target == "MergeFile")*/ {
			index = 3;
		}
		
		return csvFiles.get(index);
	}
	
}
