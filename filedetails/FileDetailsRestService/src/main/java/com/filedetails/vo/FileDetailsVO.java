package com.filedetails.vo;

import java.io.Serializable;

public class FileDetailsVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String filePath;
	private long fileSize;
	boolean isFile;
	
	public FileDetailsVO(String path,long size, boolean isFile) {
		this.filePath = path;
		this.fileSize = size;
		this.isFile = isFile;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public boolean isFile() {
		return isFile;
	}
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + (int) (fileSize ^ (fileSize >>> 32));
		result = prime * result + (isFile ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileDetailsVO other = (FileDetailsVO) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (fileSize != other.fileSize)
			return false;
		if (isFile != other.isFile)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileDetailsVO [filePath=" + filePath + ", fileSize=" + fileSize + ", isFile=" + isFile + "]";
	}
	
	
}
