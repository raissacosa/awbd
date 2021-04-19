package com.example.demo.repositories;

import com.example.demo.domain.Actor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Slf4j
public class ActorRepositoryTest {

    @Autowired
    ActorRepository actorRepository;

    @Test
    public void addActor(){
        Actor actor = new Actor();
        actor.setName("Popa");
        actor.setSurname("Andrei");

        actorRepository.save(actor);
    }

}
