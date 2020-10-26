package pl.gpalpin.gpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gpalpin.gpa.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
