package com.fount.filesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fount.filesystem.model.Doc;
import com.fount.filesystem.repository.DocRepository;

@Service
public class DocStorageService {

	@Autowired
	DocRepository docRepository;

	public Doc saveFile(MultipartFile file) {

		String docName = file.getOriginalFilename();

		try {
			Doc doc = new Doc(docName, file.getContentType(), file.getBytes());
			return docRepository.save(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Optional<Doc> getFile(Integer fileId) {

		return docRepository.findById(fileId);
	}

	public List<Doc> getFiles() {

		return docRepository.findAll();
	}

}
