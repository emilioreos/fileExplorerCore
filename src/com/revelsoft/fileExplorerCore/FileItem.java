package com.revelsoft.fileExplorerCore;

import java.io.File;
import java.io.Serializable;

import java.net.URI;

public class FileItem extends File implements Serializable{

	/**
	 * serailization version 
	 */
	private static final long serialVersionUID = 7156350355867897320L;
	/**
	 * the type of file represented by this instance
	 */
	private FileType type;
	public FileItem(File parent, String child) {
		this(parent.getAbsolutePath()+child);
	}
	public FileItem(String a,String b){
		this(a+File.separator+b,(FileClassifier)null);
	}
	public FileItem(String path){
		this(path,(FileClassifier)null);
	}
	public FileItem(URI uri){
		super(uri);
		type=clasifiFile(null, this);
	}
	public FileItem(File origin,FileClassifier classifier){
		this(origin.getAbsolutePath());
	}
	public FileItem(String path,FileClassifier classifier){
		super(path);
		type=clasifiFile(classifier, this);
	}
	
	public FileType getFileType(){
		return type;
	}
	
	
	private static final FileType clasifiFile(FileClassifier fileClassifier,File file){
		if(fileClassifier == null){
			fileClassifier=new DefaultFileClassifier();
		}
		return fileClassifier.classifyFile(file);
	}
	private static final class DefaultFileClassifier implements FileClassifier {

		@Override
		public FileType classifyFile(File file) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
