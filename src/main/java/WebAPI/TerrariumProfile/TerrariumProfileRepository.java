package WebAPI.TerrariumProfile;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrariumProfileRepository extends JpaRepository<TerrariumProfile, Long> {
}
