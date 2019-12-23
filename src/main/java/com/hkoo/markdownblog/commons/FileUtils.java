package com.hkoo.markdownblog.commons;

import com.hkoo.markdownblog.domain.Thumbnail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class FileUtils {
    @Value("${upload.location.prefix}")
    private String PREFIX;

    @Value("${upload.location.suffix}")
    private String SUFFIX;


    public Thumbnail parseFileInfo(Long boardIdx, MultipartFile multipartFile)throws Exception{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();
        String path = PREFIX+SUFFIX+current.format(formatter);
        File file = new File(path);
        if (file.exists() == false){
            file.mkdirs();
        }
        String newFileName, originalFileExtension = ".jpg", contentType;

        if (multipartFile.isEmpty()  == false){
            contentType = multipartFile.getContentType();
            if (ObjectUtils.isEmpty(contentType)){
            }
            else{
                if(contentType.contains("image/jpeg")) {
                    originalFileExtension = ".jpg";
                }
                else if(contentType.contains("image/png")) {
                    originalFileExtension = ".png";
                }
                else if(contentType.contains("image/gif")) {
                    originalFileExtension = ".gif";
                }
            }
            newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
            Thumbnail thumbnail = Thumbnail.builder()
                    .board_idx(boardIdx)
                    .fileSize(multipartFile.getSize())
                    .originalFileName(multipartFile.getOriginalFilename())
                    .storedFilePath(path.replace(PREFIX,"") + "/" + newFileName)
                    .build();
            file = new File(path + "/" + newFileName);
            multipartFile.transferTo(file);
            return thumbnail;
        }
        return null;
    }
    public void oldThumbnailDelete(Thumbnail thumbnail){
        String path = thumbnail.getStoredFilePath();
        File file = new File(PREFIX + path);
        file.delete();
    }
}
