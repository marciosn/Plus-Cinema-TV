package com.es.ufc.persisntence;

import com.es.ufc.quixada.File;

public class FileJPADAO extends GenericJPADAO<File> implements FileDAO{
	public FileJPADAO(){
		this.persistentClass = File.class;
	}
}
