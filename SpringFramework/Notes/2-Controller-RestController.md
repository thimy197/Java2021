# @Controller & @RestController

## @Controller

@ Controller <b>Là nơi nhận các request từ client.</b> Nó có nhiệm vụ đón nhận các yêu cầu (kèm theo thông tin request) và chuyển các yêu cầu này xuống cho tầng @Service xử lý logic.<br>
Đây đơn giản là 1 dạng đặt biệt của <i>@Component</i>, <b>cho phép auto-detect các implement class thông qua classpath scanning</b>

```
@Controller
@RequestMapping("books")
public class SimpleBookController {

    @GetMapping("/{id}", produces = "application/json")
    public @ResponseBody Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```
Nếu không có @ResponseBody thì @Controller là sẽ trả về một template.<br>
@ResponseBody: chuyển Object Java trong response -> JSON.

## @RestController
Là phiên bản đặt biệt của controller, làm đơn giản hóa việc thực thi các controller<br> 
<b>@RestController = @Controller + @ResponseBody</b><br>
Trả về dữ liệu dưới dạng JSON. Object, List, Map,.. sẽ được chuyển thành JSON.<br>
Mặt định sử dụng Jackson để convert

```
@RestController
@RequestMapping("books-rest")
public class SimpleBookRestController {
    
    @GetMapping("/{id}", produces = "application/json")
    public Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```

@PathVariable: Lấy thông tin từ URL<br>
<br>
Có thể tùy biến response, ta return về giá trị <b>ResponseEntity</b> mà Spring cung cấp. Đây là đối tượng cha của tất cả response và sẽ wrapper các Object trả về<br>
@RequestBody: chuyển JSON trong request -> Object Java.

```
@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    List<Todo> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        todoList.add(todo);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
        return ResponseEntity.ok().body(todo);
    }

}
```

### Notes
1. @Controller là common annotation sử dụng phổ biến trong SpringMVC. Còn @RestController là controller đặt biệt của Restful web service
2. @RestController được thêm vào ở những Spring version 4.0. @Controller có từ khi Spring hỗ trợ annotation, từ version 2.0
