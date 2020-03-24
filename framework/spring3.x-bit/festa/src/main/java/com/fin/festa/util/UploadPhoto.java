package com.fin.festa.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

//���Ͼ��ε��� ���ڰ����� MultipartFile, HttpServletRequest �ʿ� 
//���Ͼ��ε� �迭������ �޾Ƽ� DB�� , �������� �־��ټ��ְ� ��������
public class UploadPhoto {
	
	String path="test\\src\\main\\webapp\\resources\\upload\\";
	
	//���Ͼ��ε� ���ִ¸޼ҵ�
	public String upload(MultipartFile[] files,HttpServletRequest req) {
		
		//���� �۾����� ������Ʈ��� �˾Ƴ��� �װ���� resources�ȿ� upload������ �����
		String realPath=req.getRealPath(req.getContextPath());
		String[] path1=realPath.split("\\.metadata");
		path=path1[0]+path;
		
		//������ ���鰪 ����ְ� ,�������� �����ְ� io�۾�
		int i=0;
		String photoName= "";
		for(MultipartFile multi : files) {
			if(multi.getOriginalFilename().isEmpty()) {
				i++;
				continue;
			}
			String filenames =multi.getOriginalFilename();
			String rename=System.currentTimeMillis()+"_"+filenames;
			
			if(i!=files.length-1) {
				photoName+=rename+",";
			}else {
				photoName+=rename;
			}
			File file = new File(path+rename);
			
			try {
				multi.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		}
		
		//������ ,�� ó��
		String[] photo=photoName.split("\\,");
		String photos="";
		for(int j=0; j<photo.length; j++) {
			if(j!=photo.length-1) {
				photos+=photo[j]+",";
			}else {
				photos+=photo[j];
			}
		}
		
		return photos;
	}
}
