package com.myapp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class ExcelFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fileName;
    @Lob
    private byte[] fileData;

    private String createdBy;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    private String status;

}
