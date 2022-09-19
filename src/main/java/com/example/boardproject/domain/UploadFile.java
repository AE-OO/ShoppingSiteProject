package com.example.boardproject.domain;

/**
 * created : OH
 * last update : 2022.09.16
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class UploadFile {
    private String uploadFileName;
    private String storeFileName;

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }

    public UploadFile() {
    }
}
