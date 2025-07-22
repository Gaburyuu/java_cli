package src.main.java.com.example.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// this handles web routes like / and /add and uses a local list of todos for now
@Controller
public class TodoController {
    private final List<Todo> todos = new ArrayList<>();
    private int nextId = 1;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String text) {
        if (!text.isBlank()) {
            todos.add(new Todo(nextId++, text, false));
        }
        return "redirect:/";
    }

    @PostMapping("/toggle")
    public String toggle(@RequestParam int id) {
        for (int i = 0; i < todos.size(); i++) {
            Todo t = todos.get(i);
            if (t.id() == id) {
                todos.set(i, new Todo(t.id(), t.text(), !t.done()));
                break;
            }
        }
        return "redirect:/";
    }
}
