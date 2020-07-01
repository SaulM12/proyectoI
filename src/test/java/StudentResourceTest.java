import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unibe.edu.proyect.dtos.StudentDto;
import com.unibe.edu.proyect.resources.RestService;
import com.unibe.edu.proyect.resources.StudentResource;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentResourceTest {

	@Rule
	public ExpectedException thrown= ExpectedException.none();
	
	@Autowired
	private RestService restService;
	private StudentDto studentDto;
	
	@Before
	public void before() {
		this.studentDto= new StudentDto(1, "1727171404", "Jose Jose", "Jaramillo Perez", "kasj@gmail", "0969043552", "2020-04-03", "Caderon");
	}
	
	@Test
	public void createStudentTest() {
		restService.restBuilder().path(StudentResource.STUDENT).body(studentDto).post().build();
	}
	
}