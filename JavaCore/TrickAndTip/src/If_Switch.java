import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class If_Switch {

	/*
	 * Switch vs If..else
	 * 
	 * 1. Biểu thức kiểm tra:
	 * 	if-else có thể kiểm tra biểu thức dựa trên phạm vi giá trị hoặc điều kiện
	 * 	switch chỉ kiểm tra biểu thức dựa trên một single integer, enumerated value hoặc String object.
	 * 
	 * 2. Switch tốt hơn khi thực hiện trên nhiều branchs-nhánh:
	 * 	switch --compiles--> "jump table" dựa theo các case constants. Dựa vào value truyền vào, sẽ chọn path phù hợp
	 * 	Complier có thể làm được vì nó biết là các case của nó cùng type, nhưng if thì không nha
	 * 
	 * 3. if...else better for boolean:
	 * 	với câu điều kiện là true|flase thì if...else sẽ nhanh hơn switch. Switch thích hợp với các value "fixed"
	 * 
	 * 4. Speed: 
	 * 	Switch mang lại hiệu quả hơn nếu được sử dụng trong trường hợp >5 case, ít hơn thì sử dụng if...else.
	 * 	Vì khi >5 case thì "jump table" hoặc hash list mới được thực hiện. 
	 * 		Nếu case là giá trị cuối cùng thì if..else sẽ mất rất nhiều time mới tới case cuối, 
	 * 		mà switch chỉ cần vào table và lấy theo case đã được tạo sẵn nên nhanh hơn rất nhiều
	 * 
	 * 5. Dễ đọc: 
	 * 	Switch gọn và dễ nhìn hơn, trong khi if thì khá là dễ bị lỗi. Adding/removing case vào switch cũng dễ dang hơn.
	 * 	Nên switch bảo trì cũng thuận tiện hơn
	 * 
	 * Note:
	 * 	- switch sẽ được thực hiện ở compile time --> chú ý những giá trị trong case cũng phải được xác định rõ, 
	 * 		tránh các biến được gán khi runtime. Thường ENUM sử dụng ở đây
	 * 	- Thực hiện statement nào mà rõ ràng và dễ bảo trì hơn cho code của bạn
	 * 	- Với 1 khối switch hoặc if...else khổng lồ hãy suy nghĩ tới các kỹ thuật khác như "Đa hình". 
	 * 	Cố gắng tìm ra behavior of Object và đóng gói nó nếu có thể
	 *  - Switch là thiết kế tốt, nhưng nếu sử dụng không đúng chỗ thì nó sẽ trở thành "code smell", đặt biệt là trong OOPs
	 *  		https://www.c-sharpcorner.com/article/switch-statement-a-code-smell/ 
	 *  	Đọc kham khảo thêm bài trên thì ta thấy nó sẽ vi phạm một số nguyên tắc trong code:
	 *  	- Vi phạm nguyên tắc Open và Close:
	 *  		Khi muốn thêm một feature mới thì chúng ta phải chèn thêm case trong switch -> Sửa code hiện có -> không nên
	 *  	- Difficult to maintain
	 *  	- Cung cấp nhiều cơ hội cho mã dự phòng
	 *		***Bài viết trên cũng cung cấp 1 ví dụ rất hay về OOP
	 */
	public static void main(String[] args) {
		
	}
	
	/*
	 * function chưa được cải tiến
	 */
	public List<String> getSortedData(String searchType, List<String> data)  
    {  
        List<String> sortedData = null;  
 
        switch (searchType)  
        {  
            case "BubbleSort":  
                //Peform Bubble sort and assign to data.  
                sortedData = data;  
                break;  

            case "HeapSort":  
                //Peform Heap sort and assign to data.  
                sortedData = data;  
                break;  

            case "MergeSort":  
                //Peform Merge sort and assign to data.  
                sortedData = data;  
                break;  

            case "InsertionSort":  
                //Peform Insertion sort and assign to data.  
                sortedData = data;  
                break;  
        }  

        return sortedData;  
    } 
	
	/*
	 * Sau khi cải tiến
	 */
	interface ISortData  
	{  
	    List<String> getSortedData(List<String> data);  
	}  
	  
	class BubbleSortData implements ISortData  
	{  
	    public List<String> getSortedData(List<String> data)  
	    {  
	        //implement bubble sort and sort the data and return it.  
	        return data;  
	    }  
	}  
	  
	class HeapSortData implements ISortData  
	{  
	    public List<String> getSortedData(List<String> data)  
	    {  
	        //implement Heap sort and sort the data and return it.  
	        return data;  
	    }  
	}  
	  
	class MergeSortData implements ISortData  
	{  
	    public List<String> getSortedData(List<String> data)  
	    {  
	        //implement Merge sort and sort the data and return it.  
	        return data;  
	    }  
	}  
	  
	class InsertionSortData implements ISortData  
	{  
	    public List<String> getSortedData(List<String> data)  
	    {  
	        //implement Insertion sort and sort the data and return it.  
	        return data;  
	    }  
	}  
	  
	class SortingContext  
	{  
	     private Map<String, ISortData> sortStrategy = new HashMap<>();
	  
	    public SortingContext()  
	    {  
	        sortStrategy.put("BubbleSort", new BubbleSortData());  
	        sortStrategy.put("HeapSort", new HeapSortData());  
	        sortStrategy.put("MergeSort", new MergeSortData());  
	        sortStrategy.put("InsertionSort", new InsertionSortData());  
	    }  
	  
	    public List<String> getSortedData(String searchType, List<String> data)  
	    {  
	        return sortStrategy.get(searchType).getSortedData(data);  
	    }  
	}  
	  
	class SortingClient  
	{  
		List<String> data = Arrays.asList(new String[]{"Ball", "Apple", "Cat"});
		//		List.of() from Java9
		
	    SortingContext sortingContext = new SortingContext();  
	    List<String> result = sortingContext.getSortedData("BubbleSort", data);  
	}  

}
