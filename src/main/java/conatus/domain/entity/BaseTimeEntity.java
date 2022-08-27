package conatus.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @Column(name = "created_time", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime createdTime;


    @Column(name = "updated_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updatedTime;

    @PrePersist
    private void beforeSaving() {
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
        System.out.println("createdDate = " + createdTime);
//        createdBy = Thread.currentThread().getName(); //todo: put your logic here
    }

    @PreUpdate
    private void beforeUpdating() {
        this.updatedTime = LocalDateTime.now();
        System.out.println("updatedDate = " + updatedTime);
//        modifiedBy = Thread.currentThread().getName(); //todo: put your logic here
    }


}