package com.example.Hasan.common.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Hasan on 20.10.2018.
 */

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

    @Column(updatable = false, nullable = false)
    private Date createdAt;

    @Column
    private Date updatedAt;

    @Column(nullable = false)
    private Boolean deleted = false;

    @PrePersist
    private void onPersist() {
        if(createdAt == null){
            createdAt = Calendar.getInstance().getTime();
        }
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = Calendar.getInstance().getTime();
    }
}
