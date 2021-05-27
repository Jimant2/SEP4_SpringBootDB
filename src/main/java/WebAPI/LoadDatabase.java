package WebAPI;


import WebAPI.MotherboardData.MotherboardData;
import WebAPI.MotherboardData.MotherboardDataRepository;
import WebAPI.Task.Task;
import WebAPI.Task.TaskRepository;
import WebAPI.Terrarium.Terrarium;
import WebAPI.Terrarium.TerrariumRepository;
import WebAPI.TerrariumProfile.TerrariumProfile;
import WebAPI.TerrariumProfile.TerrariumProfileRepository;
import WebAPI.user.User;
import WebAPI.user.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(MotherboardDataRepository motherboardDataRepository, TaskRepository taskRepository,
                                   TerrariumRepository terrariumRepository, UserRepository userRepository,
                                   TerrariumProfileRepository terrariumProfileRepository) {
        return args -> {

     MotherboardData motherboardData1 = new MotherboardData(32, 18, 40, 28, 41, 57, 18);
       log.info("Preloading" + motherboardDataRepository.save(motherboardData1));

       Task task = new Task(Timestamp.valueOf(LocalDateTime.now()), "dshajikhy");
       log.info("Preloading" + taskRepository.save(task));

         TerrariumProfile terrariumProfile1 = new TerrariumProfile("John Kalimdor/Azeroth", 27, 57, 29, 30, 19, 38, 48, 58);
         log.info("Preloading" + terrariumProfileRepository.save(terrariumProfile1));

          Terrarium terrarium = new Terrarium("fYOP");
          log.info("Preloading" + terrariumRepository.save(terrarium));

         User user = new User("Kyle");
         log.info("Preloading" + userRepository.save(user));


        };
    }
}
