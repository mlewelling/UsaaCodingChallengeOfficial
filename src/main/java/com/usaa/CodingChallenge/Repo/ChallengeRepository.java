package com.usaa.CodingChallenge.Repo;

import com.usaa.CodingChallenge.Model.ChallengeObject;
import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends CrudRepository<ChallengeObject, String> {}
