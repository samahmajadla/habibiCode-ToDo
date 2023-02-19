package habibicode.todolist.repository;

import habibicode.todolist.model.ToDoItem;
import org.springframework.data.repository.CrudRepository;

public interface ToDoItemRepository  extends CrudRepository<ToDoItem, Long> {
}
