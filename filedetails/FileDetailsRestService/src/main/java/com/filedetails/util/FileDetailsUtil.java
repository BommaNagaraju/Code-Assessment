package com.filedetails.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.filedetails.vo.FileDescriptionVO;
import com.filedetails.vo.FileDetailsVO;
/**
 * @author BommaNagaraju
 *
 */
public class FileDetailsUtil {

	private static final Log LOG = LogFactory.getLog(FileDetailsUtil.class);
	
	/**
	 * Method1
	 * @param path
	 * @return
	 */
	public static List<FileDetailsVO> getFileDetails(String path) {
		List<FileDetailsVO> fileDetails = new ArrayList<FileDetailsVO>();
		getFilesRecursvely(path,fileDetails,true);
		return fileDetails;
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
	
	private static void log(String path, long size, String fileORDirectory) {
		System.out.println(path+"::"+size+"::"+fileORDirectory);
		LOG.info(path+"::"+size+"::"+fileORDirectory);
	}

	/**
	 * Method2
	 * Given a full path to a file as a parameter, return an XML\JSON that contains a full description of that file
	 * @param filePath
	 */
	public static FileDescriptionVO getFileDescription(String filePath) {
		FileDescriptionVO description = new FileDescriptionVO();
		try {
		File file = new File(filePath);
		Path path = file.toPath();
		BasicFileAttributes fatr = Files.readAttributes(path, BasicFileAttributes.class);
		description.setFilePath(file.getAbsolutePath());
		description.setFileSize(file.length());
		description.setFile(file.isFile());
		description.setDirectory(fatr.isDirectory());
		description.setCanExecute(file.canExecute());
		description.setCanRead(file.canRead());
		description.setCanWrite(file.canWrite());
		description.setHidden(file.isHidden());
		description.setCreationTime(fatr.creationTime());
		description.setLastModifiedTime(fatr.lastModifiedTime());
		description.setLastAccessTime(fatr.lastAccessTime());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return description;
	}
	
}
