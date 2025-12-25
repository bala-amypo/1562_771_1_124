import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {
    List<DiversityTarget> findByTargetYear(Integer year);
}
