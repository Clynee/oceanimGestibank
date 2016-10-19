package com.wha.springmvc.util;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;





import com.wha.springmvc.entities.FileContainer;



public class FileValidator implements Validator{
	
	
	public boolean supports(Class<?> clazz) {
		return FileContainer.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		FileContainer file = (FileContainer) obj;
			
		if(file.getFile()!=null){
			if (file.getFile().getSize() == 0) {
				errors.rejectValue("file", "missing.file");
			}
		}
	}

	
}
