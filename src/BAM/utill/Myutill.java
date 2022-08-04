package BAM.utill;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Myutill {
			
			// 현재 날짜/시간        
			static LocalDateTime now = LocalDateTime.now();         
			// 현재 날짜/시간 출력
			// 2021-06-17T06:43:21.419878100   
			
			// 포맷팅
			public static String regDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			// 포맷팅 현재 날짜/시간 출력        
  
			// 2021년 06월 17일 06시 43분 21초  
	
}		

