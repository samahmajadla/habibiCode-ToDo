package habibicode.todolist.controller;

import habibicode.todolist.model.ToDoItem;
import habibicode.todolist.service.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
public class ToDoListController {

    private ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService){
        this.toDoListService = toDoListService;
    }

    @PostMapping("/list")
    public ResponseEntity createList(@RequestParam String title){
        return ResponseEntity.ok(this.toDoListService.createList(title));
    }

    @GetMapping("/list")
    public ResponseEntity getListById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(this.toDoListService.getListById(id));
        } catch (NoSuchElementException exception){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lists")
    public ResponseEntity getListsByTitle(@RequestParam String title){
        return ResponseEntity.ok(this.toDoListService.getListsByTitle(title));
    }

    @DeleteMapping("/list")
    public ResponseEntity deleteList(@RequestParam Long id){

        boolean deletedList = this.toDoListService.deleteList(id);
        if (deletedList){
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{listId}/item")
    public ResponseEntity addItem(@RequestBody ToDoItem item, @PathVariable Long listId){
        try {
            return ResponseEntity.ok(toDoListService.addItemToList(item, listId));
        } catch( NoSuchElementException exception){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
