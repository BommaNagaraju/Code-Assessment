package com.filedetails.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filedetails.vo.FileDescriptionVO;
import com.filedetails.vo.FileDetailsVO;

/**
 * @author BommaNagaraju
 *
 */
public class FileDetails {

	public static void main(String[] args) {
		//String path = "C:\\TechM\\interviews";
		//String path ="C:\\TechM\\test empty";
		String path = "F:\\Prathima";
		//Method1 call
		String fileDetailsJson = getFileDetails(path);
		System.out.println("files:"+fileDetailsJson);
		
		//Method2 call
		//String filePath = "C:\\TechM\\interviews\\05_11_Core_Java\\SRS_AyushGoyal_Java_4.7years_Techmahindra_Mumbai.doc";
		String filePath = "F:\\Prathima\\Resume Samples\\RajamRaju_Resume.doc";
		String fileDescription = getFileDescription(filePath);
		System.out.println("fileDescription:"+fileDescription);
	}
	
	/**
	 * Method1
	 * @param path
	 * @return
	 */
	public static String getFileDetails(String path) {
		List<FileDetailsVO> fileDetails = new ArrayList<FileDetailsVO>();
		getFilesRecursvely(path,fileDetails,true);
		System.out.println(fileDetails.size());
		
		String jsonString = convertToJson(fileDetails);
		System.out.println("jsonString is:"+jsonString);
		return jsonString;
	}
	
	/**
	 * Recursive function to get the files
	 * @param directoryPath
	 * @param fileDetails
	 * @param isRootFolder
	 */
	private static void getFilesRecursvely(String directoryPath,List<FileDetailsVO> fileDetails, boolean isRootFolder) {
		File rootFolder = new File(directoryPath);
		File[] files = rootFolder.listFiles();
		
		if(files.length ==0 && isRootFolder) {
			log(rootFolder.getAbsolutePath(), rootFolder.length(), "Root Directory");
			fileDetails.add(new FileDetailsVO(rootFolder.getAbsolutePath(), rootFolder.length(), false));
			return;
		}
		for(File file: files) {
			if(file.isDirectory()) {
				log(file.getAbsolutePath(), file.length(), "Directory");
				fileDetails.add(new FileDetailsVO(file.getAbsolutePath(), file.length(), false));
				getFilesRecursvely(file.getAbsolutePath(),fileDetails,false);
			}else {
				log(file.getAbsolutePath(), file.length(), "File");
				fileDetails.add(new FileDetailsVO(file.getAbsolutePath(), file.length(), true));
			}
		}
	}
	
	/**
	 * Given a full path to a file as a parameter, return an XML\JSON that contains a full description of that file
	 * @param filePath
	 * @return
	 */
	public static String getFileDescription(String filePath) {
		String descriptionJson = null;
		try {
			File file = new File(filePath);
			Path path = file.toPath();
			BasicFileAttributes fatr = Files.readAttributes(path, BasicFileAttributes.class);
			FileDescriptionVO description = new FileDescriptionVO();
			description.setFilePath(file.getAbsolutePath());
			description.setFileSize(fatr.size());
			description.setFile(file.isFile());
			description.setDirectory(fatr.isDirectory());
			description.setCanExecute(file.canExecute());
			description.setCanRead(file.canRead());
			description.setCanWrite(file.canWrite());
			description.setHidden(file.isHidden());
			description.setCreationTime(fatr.creationTime());
			description.setLastModifiedTime(fatr.lastModifiedTime());
			description.setLastAccessTime(fatr.lastAccessTime());
			descriptionJson = convertToJson(description);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return descriptionJson;
	}
	
	
	/**
	 * @param obj
	 * @return
	 */
	private static String convertToJson(Object obj) {
		ObjectMapper Obj = new ObjectMapper(); 
		String jsonStr = null;
		try { 
			jsonStr = Obj.writeValueAsString(obj); 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
		return jsonStr;
	}
	
	/**
	 * Method to Write the log to console
	 * @param path
	 * @param size
	 * @param fileORDirectory
	 */
	private static void log(String path, long size, String fileORDirectory) {
		System.out.println(path+"::"+size+"::"+fileORDirectory);
	}
}
