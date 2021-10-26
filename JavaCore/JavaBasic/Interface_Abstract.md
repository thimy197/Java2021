# Khác nhau giữa Abstract và Interface

## Lý thuyết:

## When to use???
1. Abstract class:
Ví dụ: an Engineer here, let’s create an abstract class “Engineer” with common methods that engineers usually do
<br>
Now, why abstract class here and not an interface? ==> They all are humans but we want to pass on specific things that engineers do to child classes, the things that engineers have to do.

```
public abstract class Engineer {
    abstract void dieSingle();
    abstract void haveNoRespect();
    abstract void haveNoLife();
    abstract void netflixAndChill(boolean cry);
    abstract void work();
    abstract boolean hasJob();
    abstract boolean foundJob();
    abstract void noLuck();
    public void startWorking() {
        if (hasJob()) {
            work();
        } else {
            if (foundJob()) {
                work();
            } else {
                noLuck();
            }
        }
    }

}
```

Bạn có thể sử dụng Abstract class khi…<br>
i) Bạn muốn các lớp con của Lớp Abstract cha được thực thi để ghi đè các phương thức cụ thể.<br>
ii) Về mặt lý thuyết, bạn có thể coi nó như một Lớp Abstract cha đưa ra hướng dẫn cho các lớp con mà chúng phải tuân theo.<br>
iii) Bạn muốn xác định một thực thể cụ thể và giới hạn việc sử dụng nó cho các thực thể con.<br>
iv) Bạn muốn lớp có code không chỉ là các abstract method.<br>

2. Interface:
Ví dụ: think of an entity “Human”, a living healthy common man(or woman, not sexist). We are going to create an Interface namely Human.

```
public interface Human {
    void breathe();
    void eat();
    void live();
    void letLive();
    void think();
    void love();
}
```
Bạn có thể sử dụng Interface khi…
i) Bạn muốn thực thi các phương thức interface cho bất kỳ lớp bên dưới nào dưới dạng triển khai.
ii) Bạn không muốn có mối quan hệ parent-child trong quá trình triển khai của mình.
iii) Bạn muốn thiết kế một plugin, một tập hợp các sự kiện có thể được chuyển đến bất kỳ lớp nào mà nó được triển khai.
iv) Bạn muốn thực hiện hành vi chung của một thực thể cụ thể.
v) Bạn chắc chắn rằng sẽ không có mã nào ở đó trong một interface ngoài các phương thức abstract.




