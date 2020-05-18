package com.filedetails.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filedetails.util.FileDetailsUtil;
import com.filedetails.vo.FileDescriptionVO;
import com.filedetails.vo.FileDetailsVO;
/**
 * @author BommaNagaraju
 *
 */
@RestController
@RequestMapping("/FileDetails")
public class FileDetailsController {
	
	private static final Log LOG = LogFactory.getLog(FileDetailsController.class);
	
	@GetMapping("/listFilesAndDirectories")
	public List<FileDetailsVO> getFileDetails(@RequestParam(name="filePath",required = true) String filePath){
		log("in getFileDetails::"+filePath);
		return FileDetailsUtil.getFileDetails(filePath);
	}
	
	@GetMapping("/listFileProperties")
	public FileDescriptionVO getFileDescription(@RequestParam(name="filePath",required = true) String filePath) {
		log("in getFileDescription::"+filePath);
		return FileDetailsUtil.getFileDescription(filePath);
	}
	
	private void log(String message) {
		LOG.info(message);
	}
}
