package WebAPI.Sensor;


import WebAPI.SensorData.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
