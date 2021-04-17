package com.example.demo;

import com.example.demo.domain.Actor;
import com.example.demo.domain.Cinema;
import com.example.demo.domain.Genre;
import com.example.demo.domain.Spectator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findGenre() {
        Genre genreFound = entityManager.find(Genre.class, 1L);

        assertEquals(genreFound.getName(),"comedy");
    }

    @Test
    public void findActor() {
        Actor actorFound = entityManager.find(Actor.class, 2L);

        assertEquals(actorFound.getName(),"Roberts");
    }

    @Test
    public void findSpectator() {
        Spectator spectatorFound = entityManager.find(Spectator.class, 1L);

        assertEquals(spectatorFound.getSurname(),"Julia");
    }

    @Test
    public void findCinema() {
        Cinema cinemaFound = entityManager.find(Cinema.class, 1L);

        assertEquals(cinemaFound.getName(),"Cinema City");
        assertEquals(cinemaFound.getCity(),"Bacau");
    }

}
