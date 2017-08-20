package com.revelsoft.fileExplorerCore;

/**
 * 
 * @author emiliorereos_@hotmail.com
 *
 */
public enum FileType {
	/**
	 * Represent a folder
	 */
	FOLDER,
	/**
	 * represent a generic office file
	 */
	OFFICE_FILE,
	/**
	 * represent an office text file like pdf or doc
	 */
	OFFICE_TEXT,
	/**
	 * represent a spread sheet file like xls
	 */
	OFFICE_SPREAD_SHEET,
	/**
	 * represent a presentation file like ppt
	 */
	OFFICE_PRESENTATION,
	/**
	 * represent a music file like mp3
	 */
	MUSIC,
	/**
	 * represent an image file like jpg
	 */
	IMAGE,
	/**
	 * represent a video file like mp4
	 */
	VIDEO,
	/**
	 * represent a file that can be a generic multimedia file
	 */
	MULTIMEDIA,
	/**
	 * represent a compress file like zip
	 */
	COMPRESS,
	/**
	 * represent a binary file like an executable file like exe
	 */
	BINARY_FILE,
	/**
	 * represent a plain text file like txt
	 */
	TEXT_FILE,
	/**
	 * represent an executable file like exe or out
	 */
	EXECUTABLE,
	/**
	 * represent a plain text file of source code like java or cpp
	 */
	SOURCE_FILE,
	/**
	 * represent an image disk file like iso
	 */
	DISCK_IMAGE,
	/**
	 * represent a file like db
	 */
	DATA_BASE,
	/**
	 * represent a font file like otf
	 */
	FONT,
	/**
	 * represent a file for data interchance like xml or json
	 */
	DATA_INTERCHANGE,
	/*
	 * represent a crypted file like crypt
	 */
	CODE,
	/**
	 * represent a script file like js
	 */
	SCRIPT,
	/**
	 * represent a certificate file like cer
	 */
	CERTIFICATE,
	/**
	 * represent a save game data like 3ds
	 */
	SAVE_GAME_DATA,
	/**
	 * represent a temporary file like tmp
	 */
	TEMPORARY_FILE,
	/**
	 * represent a generic file like a file without extention
	 */
	GENERIC_FILE
}
