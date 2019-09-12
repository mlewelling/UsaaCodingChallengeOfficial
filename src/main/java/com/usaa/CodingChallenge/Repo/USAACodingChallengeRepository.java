package com.usaa.CodingChallenge.Repo;

import com.usaa.CodingChallenge.Model.ChallengeObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Repository
public class USAACodingChallengeRepository {

    @Autowired
    private ChallengeRepository challengeRepository;

    private static final Logger logger = LogManager.getLogger(USAACodingChallengeRepository.class);

    public String getAnswer(String input) {

        if (challengeRepository.findById(input).isPresent()) {
            return challengeRepository.findById(input).get().getAnswer();
        }

        return "";
    }

    public byte[] getImage(String input) {

        if (challengeRepository.findById(input).isPresent()) {
            //return challengeRepository.findById(input).get().getImage();
            return challengeRepository.findById(input).get().getImage();
        }

        return new byte[0];
    }

    @PostConstruct
    public void init() throws IOException {
        InputStream initialStream = new FileInputStream("encrypted.jpg");

        byte[] targetArr = new byte[initialStream.available()];
        initialStream.read(targetArr);

        ChallengeObject object = new ChallengeObject("OntoProblem2WithYou!", "getTheImageFromHere", targetArr);
        challengeRepository.save(object);
    }


}
