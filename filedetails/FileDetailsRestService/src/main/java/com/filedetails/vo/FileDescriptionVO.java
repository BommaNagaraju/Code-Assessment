package com.filedetails.vo;

import java.io.Serializable;
import java.nio.file.attribute.FileTime;

public class FileDescriptionVO implements Serializable{

	private String filePath;
	private long fileSize;
	boolean isFile;
	boolean isDirectory;
	boolean canExecute;
	boolean canWrite;
	boolean canRead;
	boolean isHidden;
	FileTime creationTime;
	FileTime lastModifiedTime;
	FileTime lastAccessTime;

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

	public boolean isDirectory() {
		return isDirectory;
	}

	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public boolean isCanExecute() {
		return canExecute;
	}

	public void setCanExecute(boolean canExecute) {
		this.canExecute = canExecute;
	}

	public boolean isCanWrite() {
		return canWrite;
	}

	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}

	public boolean isCanRead() {
		return canRead;
	}

	public void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public FileTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(FileTime creationTime) {
		this.creationTime = creationTime;
	}

	public FileTime getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(FileTime lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public FileTime getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(FileTime lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (canExecute ? 1231 : 1237);
		result = prime * result + (canRead ? 1231 : 1237);
		result = prime * result + (canWrite ? 1231 : 1237);
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + (int) (fileSize ^ (fileSize >>> 32));
		result = prime * result + (isDirectory ? 1231 : 1237);
		result = prime * result + (isFile ? 1231 : 1237);
		result = prime * result + (isHidden ? 1231 : 1237);
		result = prime * result + ((lastAccessTime == null) ? 0 : lastAccessTime.hashCode());
		result = prime * result + ((lastModifiedTime == null) ? 0 : lastModifiedTime.hashCode());
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
		FileDescriptionVO other = (FileDescriptionVO) obj;
		if (canExecute != other.canExecute)
			return false;
		if (canRead != other.canRead)
			return false;
		if (canWrite != other.canWrite)
			return false;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (fileSize != other.fileSize)
			return false;
		if (isDirectory != other.isDirectory)
			return false;
		if (isFile != other.isFile)
			return false;
		if (isHidden != other.isHidden)
			return false;
		if (lastAccessTime == null) {
			if (other.lastAccessTime != null)
				return false;
		} else if (!lastAccessTime.equals(other.lastAccessTime))
			return false;
		if (lastModifiedTime == null) {
			if (other.lastModifiedTime != null)
				return false;
		} else if (!lastModifiedTime.equals(other.lastModifiedTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileDescriptionVO [filePath=" + filePath + ", fileSize=" + fileSize + ", isFile=" + isFile
				+ ", isDirectory=" + isDirectory + ", canExecute=" + canExecute + ", canWrite=" + canWrite
				+ ", canRead=" + canRead + ", isHidden=" + isHidden + ", creationTime=" + creationTime
				+ ", lastModifiedTime=" + lastModifiedTime + ", lastAccessTime=" + lastAccessTime + "]";
	}

}
