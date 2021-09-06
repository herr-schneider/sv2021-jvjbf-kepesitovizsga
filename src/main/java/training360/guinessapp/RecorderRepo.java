package training360.guinessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecorderRepo extends JpaRepository<Recorder, Long>{

}
