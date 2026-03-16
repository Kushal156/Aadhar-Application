package com.uidai.aadhar.ServiceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.util.UUID;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class HelperService {

	@Value("${uploadPath}")
	private String uploadPath;

	private static final AtomicLong counter = new AtomicLong(32); // Start from V00032
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

	// File Name
	public String getFileName(MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			log.info("File Name :: {}", file.getOriginalFilename());
			return file.getOriginalFilename();
		}
		return null;
	}

	// save file
	public String saveFile(MultipartFile file) throws IOException {

		if (file == null || file.isEmpty()) {
			return null;
		}

		// Ensure directory exists
		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// Generate unique file name
		String originalName = file.getOriginalFilename();
		String extension = "";

		if (originalName != null && originalName.contains(".")) {
			extension = originalName.substring(originalName.lastIndexOf("."));
		}

		String storedFileName = originalName + extension;

		File destination = new File(dir, storedFileName);
		file.transferTo(destination);

		return storedFileName; // save THIS in DB
	}

	// generate operator id
	public String generateOperatorId() {

		long nextId = counter.getAndIncrement();
		return String.format("OP%05d", nextId);
	}
}
