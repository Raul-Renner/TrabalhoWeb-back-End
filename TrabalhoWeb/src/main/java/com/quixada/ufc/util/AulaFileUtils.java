package com.quixada.ufc.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class AulaFileUtils {

	public static void salvarImagem(String caminho, MultipartFile imagem) {
		// TODO Auto-generated method stub
		File file = new File(caminho);
		
		try {
		FileUtils.writeByteArrayToFile(file, imagem.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
