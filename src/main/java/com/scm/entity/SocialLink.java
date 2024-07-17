package com.scm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SocialLink {
    @Id
    private Long id;
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;

}
