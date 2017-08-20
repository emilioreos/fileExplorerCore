package com.revelsoft.fileExplorerCore;

import java.io.File;
import java.io.IOException;
/**
 * 
 * @author emiliorereos_@hotmail.com
 *
 */

public class FileManager implements java.io.Serializable {
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 9093720495666966278L;
	/**
	 * default classifier for folders used only to clasyfy folders on getFolders
	 */
	private static final FileClassifier DEFAULT_FOLDER_CLASSIFIER=new FolderFileClassifier();
	/**
	 * classifier used to create FileItem's when getAllFiles is called
	 */
	private FileClassifier classifier;
	/**
	 * root file to this FileManager insatance
	 */
	private File root;
	/**
	 * Construct a FileManager instance with default classifier
	 * @param root root file for this instance
	 * @throws IOException when root is not a folder or not exists
	 */
	public FileManager(File root) throws IOException {
		this(root,null);
	}
	/**
	 * Construct a FileManager instance with default classifier
	 * @param root root file for this instance
	 * @param classifier classifier for this instance when getAllFiles is called
	 * @throws IOException when root is not a folder or not exists
	 */
	public FileManager(File root,FileClassifier classifier) throws IOException {
		if(!root.exists() && root.isDirectory()){
			this.root=root;
			this.classifier=classifier;
		}else{
			throw new IOException("Root file most be a folder");
		}
	}
	/**
	 * get files on root folder
	 * @return an FileItem[] containing files on this root folder 
	 */
	public FileItem[] getAllFiles(){
		File[] files=root.listFiles();
		FileItem[] items=new FileItem[files.length];
		for(int i=0;i<items.length;i++){
			items[i]=new FileItem(files[i],classifier);
			files[i]=null;
		}
		return items;
	}
	/**
	 * get folder contained on this root file
	 * @return an FileItem[] with folders contained on root folder
	 */
	public FileItem[] getFolders(){
		File[] files=root.listFiles(DEFAULT_FOLDER_CLASSIFIER);
		FileItem[] items=new FileItem[files.length];
		for(int i=0;i<items.length;i++){
			items[i]=new FileItem(files[i],DEFAULT_FOLDER_CLASSIFIER);
			files[i]=null;
		}
		return items;
	}
	/**
	 * move the actual root folder to its parent folders if exists
	 * @return true only if actual root file has parent
	 */
	public boolean topFolder(){
		File top=root.getParentFile();
		if(top!=null){
			root=top;
			return true;
		}
		return false;
	}
	/**
	 * move the actual root folder to down folder
	 * @param downFolder folder to be a down folder
	 * @return true only if downfolder exists is a directory and its parent is the actual root file
	 */
	public boolean downFolder(File downFolder){
		if(downFolder.exists() && downFolder.isDirectory() && downFolder.getParentFile().equals(root)){
			root=downFolder;
			return true;
		}
		return false;
	}
	/**
	 * gets the actual root file
	 * @return a FileItem representing the actual root file
	 */
	public FileItem getRootFile(){
		return new FileItem(root,DEFAULT_FOLDER_CLASSIFIER);
	}
	/**
	 * delete the file in the same way that if you call secureRemoveFile(file,0)
	 * @param file the file to be deleted
	 * @return true if file can be deleted
	 */
	public boolean removeFile(File file){
		return secureRemoveFile(file,(byte) 0);
	}
	/**
	 * first write the file with random data and then delete it
	 * this operation takes too much time
	 * @param file the file to be deleted
	 * @param times to write random data
	 * @return true if file can be deleted but file can be writen and return false if something hapens
	 */
	public boolean secureRemoveFile(File file,byte times){
		
		return file.delete();
	}
	/**
	 * copy a file to destination
	 * @param origin the file to copy
	 * @param destination the folder to place the new file
	 * @return true if the file could be copied
	 */
	public boolean copyFile(File origin,File destination){
		if(!destination.isDirectory()){
			return false;
		}
		
		return false;
	}
	/**
	 * moves a file to destination
	 * @param origin the file to move
	 * @param destination the folder to place the file
	 * @return true only if file can be write in destination and deleted from its origin
	 */
	public boolean moveFile(File origin,File destination){
		
		return false;
	}
	/**
	 * create a new folder with name in the root folder of this instance
	 * @param name the name to use for the folder
	 * @return
	 */
	public FileItem createFolder(String name){
		return null;
	}
	/**
	 * create an new file with name
	 * @param name the name to the file
	 * @return a FileItem file representing the file created
	 */
	public FileItem createFile(String name){
		FileItem file=new FileItem(root,name);
		try{
			file.createNewFile();
		}catch(IOException e){
			return null;
		}
		return file;
	}
	/**
	 * rename a file can be a file or a folder
	 * @param origin file to be renamed
	 * @param newName new name for file
	 * @return
	 */
	public boolean rename(File origin,String newName){
		File newNameFile=new File(origin.getParentFile(),newName);
		return origin.renameTo(newNameFile);
	}
	/**
	 * 
	 * @author emiliorereos_@hotmail.com
	 *
	 */
	public static class FolderFileClassifier implements FileClassifier{

		@Override
		public FileType classifyFile(File file) {
			return (file.isDirectory())? FileType.FOLDER : FileType.GENERIC_FILE ;
		}

		@Override
		public boolean accept(File pathname) {
			return pathname.isDirectory();
		}
		
	}
	
}
