package WebAPI.Terrarium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrariumRepository extends JpaRepository <Terrarium, Long> {
}
