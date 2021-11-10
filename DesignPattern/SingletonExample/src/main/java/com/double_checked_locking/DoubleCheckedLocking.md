# Double-checked locking
[Kham khảo tại đây](https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java "[wikipedia]Double-checked locking") 
<br>
[More description at here](http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html)

## Introduce
Trong kỹ thuật phần mềm, **double-checked locking**(còn được gọi là "double-checked locking optimization") là một mẫu thiết kế phần mềm được sử dụng để giảm chi phí mua khóa bằng cách thử nghiệm locking criterion(tiêu chí khóa)(hay "lock hint") trước đó mua lại khóa. Việc khóa chỉ xảy ra nếu việc kiểm tra locking criterion chỉ ra rằng yêu cầu phải khóa.
<br>
The pattern, khi được triển khai trong một số kết hợp language/hardware, có thể không **unsafe**. Đôi khi, nó có thể được coi là một anti-pattern.
<br>
Nó thường được sử dụng để giảm chi phí khóa khi thực hiện "lazy initialization" trong môi trường multi-threaded, đặc biệt là một phần của mẫu **Singleton**. `Lazy initialization tránh khởi tạo một giá trị cho đến lần đầu tiên nó được truy cập`.

## Example
Example 1:

```
// Single-threaded version
class Foo {
    private static Helper helper;
    public Helper getHelper() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }

    // other functions and members...
}
```
The problem is that this does not work when using <i>multiple threads</i>. Một clock phải được lấy trong trường hợp hai thread gọi getHelper() đồng thời. Nếu không, cả hai có thể cố gắng tạo Object cùng một lúc, hoặc một người có thể kết thúc việc nhận tham chiếu đến một Object được khởi tạo chưa hoàn chỉnh.

Example 2: Khóa có được bằng cách synchronizing đắt tiền, như được hiển thị trong ví dụ sau.

```
// Correct but possibly expensive multithreaded version
class Foo {
    private Helper helper;
    public synchronized Helper getHelper() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }

    // other functions and members...
}
```
Tuy nhiên, lệnh gọi getHelper() đầu tiên sẽ tạo object và chỉ một số luồng cố gắng truy cập nó trong thời gian đó cần được đồng bộ hóa; sau đó tất cả các cuộc gọi chỉ nhận được một tham chiếu đến biến thành viên. Vì việc đồng bộ hóa một phương thức trong một số trường hợp cực đoan có thể làm giảm hiệu suất xuống hệ số 100 hoặc cao hơn, [5] chi phí thu thập và giải phóng khóa mỗi khi phương thức này được gọi dường như không cần thiết: khi quá trình khởi tạo đã hoàn thành, việc thu thập và giải phóng khóa ổ khóa sẽ xuất hiện không cần thiết. Nhiều lập trình viên đã cố gắng tối ưu hóa tình huống này theo cách sau:
1. Kiểm tra để đảm bảo rằng biến đã được khởi tạo (mà không có lock). Nếu nó được khởi tạo, hãy return nó ngay lập tức.
2. Lấy khóa.
3. Kiểm tra kỹ xem biến đã được khởi tạo chưa: nếu một luồng khác có được khóa trước, nó có thể đã thực hiện khởi tạo. Nếu vậy, hãy trả về biến đã khởi tạo.
4. Nếu không, hãy khởi tạo và trả về biến.

```
// Broken multithreaded version
// "Double-Checked Locking" idiom
class Foo {
    private Helper helper;
    public Helper getHelper() {
        if (helper == null) {
            synchronized (this) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }

    // other functions and members...
}
```
Về mặt trực quan, thuật toán này có vẻ như là một giải pháp hiệu quả cho vấn đề. Tuy nhiên, kỹ thuật này có nhiều vấn đề phức tạp và thường nên tránh. Ví dụ: hãy xem xét chuỗi sự kiện sau:
1. Luồng A thông báo rằng giá trị không được khởi tạo, vì vậy nó nhận được khóa và bắt đầu khởi tạo giá trị.
2. Do ngữ nghĩa của một số ngôn ngữ lập trình, mã do trình biên dịch(compiler) tạo ra được phép cập nhật biến chia sẻ để trỏ đến một đối tượng được xây dựng một phần trước khi A kết thúc quá trình khởi tạo. Ví dụ, trong Java nếu một lệnh gọi đến một phương thức khởi tạo đã được nội tuyến thì biến chia sẻ có thể ngay lập tức được cập nhật sau khi bộ nhớ đã được cấp phát nhưng trước khi phương thức khởi tạo nội tuyến khởi tạo đối tượng.
3. Luồng B thông báo rằng biến được chia sẻ đã được khởi tạo (hoặc gần như nó xuất hiện) và trả về giá trị của nó. Bởi vì luồng B tin rằng giá trị đã được khởi tạo, nó không nhận được khóa. Nếu B sử dụng đối tượng trước khi tất cả quá trình khởi tạo được thực hiện bởi A được B nhìn thấy (vì A chưa hoàn thành khởi tạo nó hoặc vì một số giá trị được khởi tạo trong đối tượng chưa được gắn vào bộ nhớ mà B sử dụng (tính liên kết bộ nhớ cache)) , chương trình có thể sẽ bị sập.

Một trong những mối nguy hiểm của việc sử dụng double-checked locking trong J2SE 1.4 (và các phiên bản trước đó) là nó sẽ thường hoạt động: không dễ để phân biệt giữa việc triển khai đúng kỹ thuật và một cách có các vấn đề nhỏ. Tùy thuộc vào trình compiler, sự xen kẽ các luồng bởi scheduler và bản chất của hoạt động hệ thống đồng thời khác, các lỗi do triển khai không chính xác double-checked locking có thể chỉ xảy ra không liên tục. Việc reproducing các lỗi có thể khó khăn.

Example 3: Kể từ J2SE 5.0, sự cố này đã được khắc phục. Từ khóa volatile hiện đảm bảo rằng nhiều luồng xử lý cá thể singleton một cách chính xác

```
// Works with acquire/release semantics for volatile in Java 1.5 and later
// Broken under Java 1.4 and earlier semantics for volatile
class Foo {
    private volatile Helper helper;
    public Helper getHelper() {
        Helper localRef = helper;
        if (localRef == null) {
            synchronized (this) {
                localRef = helper;
                if (localRef == null) {
                    helper = localRef = new Helper();
                }
            }
        }
        return localRef;
    }

    // other functions and members...
}
```
Lưu ý biến local "localRef", có vẻ như không cần thiết. Hiệu quả của điều này là trong trường hợp helper đã được khởi tạo(tức là hầu hết thời gian), trường volatile chỉ được truy cập một lần(do "return localRef;" thay vì "return helper;"), điều này có thể cải thiện hiệu suất tổng thể của phương pháp lên tới 40%. [In "Effective Java, Third Edition", p. 372]

Java 9 đã giới thiệu lớp **VarHandle**, cho phép sử dụng các nguyên tử đơn giản để truy cập các field, cho phép đọc nhanh hơn một chút trên các máy có mô hình bộ nhớ yếu, với chi phí cơ học khó hơn và mất tính nhất quán tuần tự(truy cập field không còn tham gia vào thứ tự đồng bộ hóa(synchronization order), global order của quyền truy cập vào các volatile fields). [8]

```
// Works with acquire/release semantics for VarHandles introduced in Java 9
class Foo {
    private volatile Helper helper;

    public Helper getHelper() {
        Helper localRef = getHelperAcquire();
        if (localRef == null) {
            synchronized (this) {
                localRef = getHelperAcquire();
                if (localRef == null) {
                    localRef = new Helper();
                    setHelperRelease(localRef);
                }
            }
        }
        return localRef;
    }

    private static final VarHandle HELPER;
    private Helper getHelperAcquire() {
        return (Helper) HELPER.getAcquire(this);
    }
    private void setHelperRelease(Helper value) {
        HELPER.setRelease(this, value);
    }

    static {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            HELPER = lookup.findVarHandle(Foo.class, "helper", Helper.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // other functions and members...
}
```
Nếu đối tượng helper là static (một đối tượng trên mỗi class loader), thì một lựa chọn thay thế là [Initialization-on-demand holder idiom](https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom)

```
// Correct lazy initialization in Java
class Foo {
    private static class HelperHolder {
       public static final Helper helper = new Helper();
    }

    public static Helper getHelper() {
        return HelperHolder.helper;
    }
}
```
Điều này dựa trên thực tế là nested classes(các lớp lồng nhau) không được tải cho đến khi chúng được tham chiếu.
<br>
Ngữ nghĩa của final field trong Java 5 có thể được sử dụng để xuất bản đối tượng helper một cách safely(an toàn) mà không sử dụng volatile

```
public class FinalWrapper<T> {
    public final T value;
    public FinalWrapper(T value) {
        this.value = value;
    }
}

public class Foo {
   private FinalWrapper<Helper> helperWrapper;

   public Helper getHelper() {
      FinalWrapper<Helper> tempWrapper = helperWrapper;

      if (tempWrapper == null) {
          synchronized (this) {
              if (helperWrapper == null) {
                  helperWrapper = new FinalWrapper<Helper>(new Helper());
              }
              tempWrapper = helperWrapper;
          }
      }
      return tempWrapper.value;
   }
}
```
Biến cục bộ tempWrapper là bắt buộc để đảm bảo tính đúng đắn: chỉ cần sử dụng helperWrapper cho cả kiểm tra null và câu lệnh trả về có thể không thành công do read reordering allowed under the Java Memory Model. Hiệu suất của việc triển khai này không nhất thiết phải tốt hơn so với việc thực hiện volatile.




