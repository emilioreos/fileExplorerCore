package com.revelsoft.fileExplorerCore;
import java.io.File;
import java.io.FileFilter;

/**
 * 
 * @author emiliorereos_@hotmail.com
 *
 */
public interface FileClassifier extends FileFilter {
	/**
	 * classifie a file
	 * @param file to be classified
	 * @return the FileType for the file
	 */
	public FileType classifyFile(File file);
}
