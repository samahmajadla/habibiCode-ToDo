package habibicode.todolist.service;

import habibicode.todolist.model.ToDoItem;
import habibicode.todolist.model.ToDoList;
import habibicode.todolist.repository.ToDoItemRepository;
import habibicode.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ToDoListService {

    ToDoItemRepository toDoItemRepository;
    ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository, ToDoItemRepository toDoItemRepository){
        this.toDoListRepository = toDoListRepository;
        this.toDoItemRepository = toDoItemRepository;
    }

    public ToDoList createList(String title) {
        ToDoList toDoList = new ToDoList();
        toDoList.setTitle(title);
        toDoList.setToDoItems(new ArrayList<>());
        return this.toDoListRepository.save(toDoList);
    }

    public ToDoList getListById(Long id) {
        Optional<ToDoList> optional = toDoListRepository.findById(id);
        return optional.orElseThrow();
    }

    public List<ToDoList> getListsByTitle(String title) {
        return this.toDoListRepository.findAllByTitle(title);
    }

    public boolean deleteList(Long id) {
        try {
            getListById(id);
            this.toDoListRepository.deleteById(id);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public ToDoList addItemToList(ToDoItem item, Long listId) {
        ToDoItem savedItem = this.toDoItemRepository.save(item);
        ToDoList list = getListById(listId);
        list.getToDoItems().add(savedItem);
        return toDoListRepository.save(list);
    }


    public List<ToDoList> getAllLists() {
        return (List) this.toDoListRepository.findAll();
    }
}
