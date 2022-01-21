package Student.Information.API.StudentInformationAPI.Controller;

import Student.Information.API.StudentInformationAPI.Entity.StudentInformation;
import Student.Information.API.StudentInformationAPI.Service.StudentInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentInformationController {

    @Autowired
    private StudentInformationService studentInformationService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentInformation save(@RequestBody StudentInformation studentInformation){
        return studentInformationService.save(studentInformation);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentInformation> listStudentInformation(){
        return studentInformationService.listStudentInformation();
    }

    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public StudentInformation findbyStudentId(@PathVariable("studentId") Long studentId){
        return studentInformationService.searchbyId(studentId)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND), "Student not found." ));
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentId(@PathVariable("studentId") Long studentId){
        studentInformationService.searchbyId(studentId)
                .map(studentInformation -> {
                    studentInformationService.deleteStudentId(studentInformation.getStudentId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND), "Student not found." ));
    }

    @PutMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudentInformation(@PathVariable("studentId") Long studentId, @RequestBody StudentInformation studentInformation){
        studentInformationService.searchbyId(studentId)
                .map(studentInformationCurrent ->{
                    modelMapper.map(studentInformation, studentInformationCurrent);
                    return Void.TYPE;
                    }).orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND), "Student not found." ));
    }
}
