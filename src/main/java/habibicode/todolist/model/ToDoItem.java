package habibicode.todolist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@Entity
public class ToDoItem {

    @Id
    @GeneratedValue
    private long id;

    private String content;

    private Date dueDate;
}
