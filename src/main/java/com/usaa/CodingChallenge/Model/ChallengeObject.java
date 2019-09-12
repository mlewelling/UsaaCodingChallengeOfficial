package com.usaa.CodingChallenge.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CHALLENGE")
public class ChallengeObject implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "image")
    private byte[] image;

    public ChallengeObject(String id, String answer, byte[] image) {
        this.id = id;
        this.answer = answer;
        this.image = image;
    }

    public String getAnswer() {
        return this.answer;
    }

    public byte[] getImage() {
        return this.image;
    }
}
