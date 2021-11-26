# @Transactional

## Reference
- [stackoverflow.com: transactional with JPA and Hibernate ](https://stackoverflow.com/questions/54326306/what-is-the-use-of-transactional-with-jpa-and-hibernate)<br>
@Transactional annotation được sử dụng khi bạn muốn 1 method/class nhất định(=all methods inside) được **thực thi trong 1 transaction**.<br>
**@Transactions means all or nothing.** -> @Transaction được đặt trong **service** level<br>
<br>
Ex: A chuyển B $100, có 2 hành động được thực hiện:<br>
	1. Giảm tài khoản của A $100<br>
	2. Tăng tài khoản B thêm $100<br>
giả sử bị exception tại bước 2, thì toàn bộ hành động trước đó (bước 1 và hành động trước khi bị exception của bước 2)sẽ bị **rollback**
