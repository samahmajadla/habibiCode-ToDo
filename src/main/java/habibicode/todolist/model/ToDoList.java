package habibicode.todolist.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@Entity
public class ToDoList {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @OneToMany
    private List<ToDoItem> toDoItems;

}
