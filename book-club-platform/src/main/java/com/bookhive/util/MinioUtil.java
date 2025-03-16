package com.bookhive.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookhive.service.MinioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MinioUtil {

    private final MinioService minioService;

    @Value("${minio.bucket-name}")
    private String bucketName;

    /**
     * Upload file to MinIO using provided folder name and object name
     *
     * @param file       The file to upload
     * @param objectName Desired object name (excluding extension)
     * @param folderName Folder in MinIO bucket
     * @return URL of the uploaded file
     * @throws Exception if upload fails
     */
    public String uploadFile(MultipartFile file, String objectName, String folderName) throws Exception {
        String extension = getExtensionFromFilename(file.getOriginalFilename());
        String fileName = objectName + "_" + System.currentTimeMillis() + extension;

        return minioService.uploadFile(file, bucketName, folderName + "/" + fileName);
    }

    /**
     * Get file extension from filename
     *
     * @param filename Original filename
     * @return File extension (including '.')
     */
    private String getExtensionFromFilename(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf("."));
    }
}
