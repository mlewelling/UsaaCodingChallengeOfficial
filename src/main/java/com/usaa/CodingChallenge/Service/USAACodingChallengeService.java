package com.usaa.CodingChallenge.Service;

import com.usaa.CodingChallenge.Repo.USAACodingChallengeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class USAACodingChallengeService {

    private static final Logger logger = LogManager.getLogger(USAACodingChallengeService.class);

    @Autowired
    private USAACodingChallengeRepository usaaCodingChallengeRepository;

    public String question1(String question1Input) {
        return usaaCodingChallengeRepository.getAnswer("REPLACE_ME");
    }

    public byte[] question2(String question2Input) {
        byte[] encryptedImage = usaaCodingChallengeRepository.getImage(question2Input);
        return null;
    }

    public String question3() {
        return usaaCodingChallengeRepository.getAnswer("REPLACE_ME");
    }
}
