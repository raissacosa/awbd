package com.example.demo.repositories;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Hall;
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
public class HallRepositoryTest {

    @Autowired
    private HallRepository hallRepository;

    @Test
    public void addHall(){
        Cinema cinema = new Cinema();
        cinema.setName("Cinema City");
        cinema.setCity("Bucuresti");
        cinema.setAddress("Strada Republicii");
        cinema.setConstructionyear(2000);
        Hall hall = new Hall();
        hall.setNumber(1);
        hall.setCapacity(200);
        hall.setCinema(cinema);

        hallRepository.save(hall);
    }
}
