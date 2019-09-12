package com.usaa.CodingChallenge.Resource;

import com.usaa.CodingChallenge.CodingChallengeApplication;
import com.usaa.CodingChallenge.Service.USAACodingChallengeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class USAACodingChallengeResource {

    private static final Logger logger = LogManager.getLogger(CodingChallengeApplication.class);

    @Autowired
    private USAACodingChallengeService usaaCodingChallengeService;

    /**
     * Use the provided list of words to find all the palindromes per line and perform some special operations
     *
     * @param listOfWords
     * @return
     */
    @PostMapping("/problem1")
    public @ResponseBody String usaaCodingChallengeProblem1(@RequestBody String listOfWords) {
        return usaaCodingChallengeService.question1(listOfWords);
    }

    /**
     * Use the response from question 1 to get started on question 2
     *
     *
     * @return
     */
    @PostMapping(
            value = "/problem2",
            produces = "image/png"
    )
    public @ResponseBody byte[] usaaCodingChallengeProblem2(@RequestBody String inputEncryptionPhrase) {
        return usaaCodingChallengeService.question2(inputEncryptionPhrase);
    }

    /**
     * Use the clues from the decrypted image to solve the question
     *
     *
     * @return
     */
    @GetMapping("/problem3")
    public @ResponseBody String usaaCodingChallengeProblem3() {
        return usaaCodingChallengeService.question3();
    }

}
