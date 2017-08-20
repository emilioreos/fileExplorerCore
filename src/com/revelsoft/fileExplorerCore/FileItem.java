package com.revelsoft.fileExplorerCore;

import java.io.File;
import java.io.Serializable;
import java.util.regex.Pattern;

import java.net.URI;
/**
 * 
 * @author emiliorereos_@hotmail.com
 *
 */
public class FileItem extends File implements Serializable{

	/**
	 * serailization version 
	 */
	private static final long serialVersionUID = 7156350355867897320L;
	/**
	 * the type of file represented by this instance
	 */
	private FileType type;
	/**
	 * create a new FileItem instance 
	 * @param parent the parent for this file
	 * @param child the name for this file
	 */
	public FileItem(File parent, String child) {
		this(parent.getAbsolutePath()+child);
	}
	/**
	 * create a new FileItem instance
	 * @param path the parent path
	 * @param name the name for this file
	 */
	public FileItem(String path,String name){
		this(path+File.separator+name,(FileClassifier)null);
	}
	/**
	 * create a new FileItem instance
	 * @param path the full path for this file or name for default root with this name
	 */
	public FileItem(String path){
		this(path,(FileClassifier)null);
	}
	/**
	 * create a FileItem instance
	 * @param uri that represents this file
	 */
	public FileItem(URI uri){
		super(uri);
		type=clasifiFile(null, this);
	}
	/**
	 * create a FileItem instance
	 * @param origin the file to construct this FileItem
	 * @param classifier to clasify this instance
	 */
	public FileItem(File origin,FileClassifier classifier){
		this(origin.getAbsolutePath(),(FileClassifier) classifier);
	}
	/**
	 * create a FileItem instance
	 * @param path full path to this FileItem
	 * @param classifier to clasify this instance
	 */
	public FileItem(String path,FileClassifier classifier){
		super(path);
		type=clasifiFile(classifier, this);
	}
	/**
	 * gets the type of this FileItem
	 * @return the type of this file
	 */
	public FileType getFileType(){
		return type;
	}
	
	/**
	 * classify a file basing on fileClassifier
	 * @param fileClassifier to classify the file
	 * @param file file to classify
	 * @return the type of file
	 */
	private static final FileType clasifiFile(FileClassifier fileClassifier,File file){
		if(fileClassifier == null){
			fileClassifier=new DefaultFileClassifier();
		}
		return fileClassifier.classifyFile(file);
	}
	/**
	 * 
	 * @author emiliorereos_@hotmail.com
	 * default FileClassifier implementation only for this class
	 */
	private static final class DefaultFileClassifier implements FileClassifier {

		@Override
		public FileType classifyFile(File file) {
			String fileName=file.getName().toLowerCase();
			if(file.isDirectory()){
				return FileType.FOLDER;
			}else if(Pattern.matches(".+((\\.mp3)|(\\.m4a)|(\\.wav)|(\\.flac)|(\\.aac)|(\\.wma)|(\\.alac)|(\\.ogg)|(\\.aiff))$", fileName)){
				return FileType.MUSIC;
			}else if(Pattern.matches(".+((\\.jpg)|(\\.jpeg)|(\\.gif)|(\\.png)|(\\.bmp)|(\\.svg)|(\\.raw))$", fileName)){
				return FileType.IMAGE;
			}else if(Pattern.matches(".+((\\.mp4)|(\\.avi)|(\\.mpeg)|(\\.mpg)|(\\.flv)|(\\.mkv)|(\\.3gp)|(\\.mov)|(\\.wmv)|(\\.divx))$", fileName)){
				return FileType.VIDEO;
			}else if(Pattern.matches(".+((\\.txt)|(\\.java)|(\\.php)|(\\.js)|(\\.tex)|(\\.c)|(\\.h)|(\\.cpp)|(\\.hpp))$", fileName)){
				return FileType.TEXT_FILE;
			}
			return FileType.GENERIC_FILE;
		}

		@Override
		public boolean accept(File arg0) {
			return true;
		}
		
	}
}
