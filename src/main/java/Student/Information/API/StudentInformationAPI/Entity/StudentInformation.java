package Student.Information.API.StudentInformationAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class StudentInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column(name = "studentName", nullable = false)
    private String studentName;

    @Column(name = "studentCourse", nullable = false)
    private String studentCourse;

    @Column(name = "studentAge", nullable = false)
    private String studentAge;


}
