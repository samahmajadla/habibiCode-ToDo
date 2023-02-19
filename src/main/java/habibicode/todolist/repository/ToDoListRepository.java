package habibicode.todolist.repository;

import habibicode.todolist.model.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository  extends CrudRepository<ToDoList, Long> {

    List<ToDoList> findAllByTitle(String title);
}
