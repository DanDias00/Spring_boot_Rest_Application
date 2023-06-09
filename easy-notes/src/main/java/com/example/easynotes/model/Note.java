package com.example.easynotes.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;



  @Entity
  @Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"},allowGetters = true)

public class Note implements Serializable{

      //creating an auto generating Id
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

      //creating an attribute without Null value
      @NotBlank
      private String title;


      //creating an attribute without Null value
      @NotBlank
      private String content;

      //creating columns
      @Column(nullable = false,updatable = false)
      @Temporal(TemporalType.TIMESTAMP)
      @CreatedDate
      private Date createdAt;

      @Column(nullable = false,updatable = false)
      @Temporal(TemporalType.TIMESTAMP)
      @LastModifiedDate
      private Date updatedAt;

      public Long getId() {
          return Id;
      }

      public void setId(Long id) {
          Id = id;
      }

      public String getTitle() {
          return title;
      }

      public void setTitle(String title) {
          this.title = title;
      }

      public String getContent() {
          return content;
      }

      public void setContent(String content) {
          this.content = content;
      }

      public Date getCreatedAt() {
          return createdAt;
      }

      public void setCreatedAt(Date createdAt) {
          this.createdAt = createdAt;
      }

      public Date getUpdatedAt() {
          return updatedAt;
      }

      public void setUpdatedAt(Date updatedAt) {
          this.updatedAt = updatedAt;
      }
  }



