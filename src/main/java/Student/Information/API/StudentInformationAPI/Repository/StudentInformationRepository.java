package Student.Information.API.StudentInformationAPI.Repository;

import Student.Information.API.StudentInformationAPI.Entity.StudentInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInformationRepository extends JpaRepository<StudentInformation, Long> {
}
