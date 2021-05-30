package WebAPI.MotherboardData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherboardDataRepository extends JpaRepository<MotherboardData, Long> {
}
