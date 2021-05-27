package WebAPI;


import WebAPI.Sensor.Sensor;
import WebAPI.Sensor.SensorRepository;
import WebAPI.SensorData.SensorData;
import WebAPI.SensorData.SensorDataRepository;
import WebAPI.Task.Task;
import WebAPI.Task.TaskRepository;
import WebAPI.TaskList.TaskList;
import WebAPI.TaskList.TaskListRepository;
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
import java.time.LocalTime;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(SensorRepository sensorRepository, SensorDataRepository sensorDataRepository, TaskRepository taskRepository,
                                   TaskListRepository taskListRepository, TerrariumRepository terrariumRepository, UserRepository userRepository,
                                   TerrariumProfileRepository terrariumProfileRepository) {
        return args -> {

            SensorData sensorData1 = new SensorData(32, 26, 28, 19);
            log.info("Preloading" + sensorDataRepository.save(sensorData1));

            Sensor sensor1 = new Sensor();
            log.info("Preloading" + sensorRepository.save(sensor1));

            TerrariumProfile terrariumProfile1 = new TerrariumProfile("John Kalimdor/Azeroth", 27, 57, 29, 30, 19, 38, 48, 58);
            log.info("Preloading" + terrariumProfileRepository.save(terrariumProfile1));

            TaskList taskList1 = new TaskList();
            log.info("Preloading" + taskListRepository.save(taskList1));


        //    Task task = new Task(Timestamp.valueOf(LocalDateTime.now()), "name");
        //    log.info("Preloading" + taskRepository.save(task));

            User user = new User("Kyle");
            log.info("Preloading" + userRepository.save(user));

            Terrarium terrarium = new Terrarium("Terry Stormrage");
            log.info("Preloading" + terrariumRepository.save(terrarium));


        };
    }
}
