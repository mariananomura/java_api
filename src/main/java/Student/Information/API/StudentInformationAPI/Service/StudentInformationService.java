package Student.Information.API.StudentInformationAPI.Service;

import Student.Information.API.StudentInformationAPI.Entity.StudentInformation;
import Student.Information.API.StudentInformationAPI.Repository.StudentInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentInformationService {

    @Autowired
    private StudentInformationRepository studentInformationRepository;

    public StudentInformation save(StudentInformation studentInformation){
        return studentInformationRepository.save(studentInformation);
    }

    public List<StudentInformation> listStudentInformation(){
        return studentInformationRepository.findAll();
    }

    public Optional<StudentInformation> searchbyId(Long studentId){
        return studentInformationRepository.findById(studentId);
    }

    public void deleteStudentId(Long studentId){
        studentInformationRepository.deleteById(studentId);
    }
}
