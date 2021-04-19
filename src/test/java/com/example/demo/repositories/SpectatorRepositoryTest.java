package com.example.demo.repositories;

import com.example.demo.domain.Spectator;
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
public class SpectatorRepositoryTest {

    @Autowired
    private SpectatorRepository spectatorRepository;

    @Test
    public void addSpectator(){
        Spectator spectator = new Spectator();
        spectator.setName("Popa");
        spectator.setSurname("Andreea");
        spectator.setPhone("0755764161");
        spectatorRepository.save(spectator);

    }
}
