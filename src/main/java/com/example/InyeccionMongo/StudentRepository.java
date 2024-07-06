package com.example.InyeccionMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Students, String> {

    @Query("{firstName:'?0'}")
    Optional<Students> findItemByName(String firstName);

    @Query(value = "{program:'?0'}", fields = "{'firstName' : 1, 'lastName' : 1, 'email' : 1}")
    List<Students> findAll(String program);

    long count();
}
