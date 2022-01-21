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
    private Long StudentId;

    @Column(name = "studentName", nullable = false)
    private String StudentName;

    @Column(name = "studentCourse", nullable = false)
    private String StudentCourse;


}
