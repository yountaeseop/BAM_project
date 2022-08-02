package App;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Article> articles = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("==프로그램 시작==");
		int id = 1;
		
		while(true) {
			System.out.printf("명령어) ");
			String input = sc.nextLine().trim();
			
			if(input.equals("article list")) {
				System.out.printf("번호  /  제목\n");
				
				
				
				for(int i = 0; i < articles.size(); i++) {
					int articleId = articles.get(i).id;
					String articleTitle = articles.get(i).title;
					
					System.out.printf("%d %8s\n",articleId, articleTitle);
					
				}
				
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다");
				}
				
			} else if(input.equals("article write")) {
				
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
				articles.add(new Article(id, title, body));
				
				System.out.printf("%d번글이 생성되었습니다\n", id);
				
				id++;
				
			} else if(input.equals("exit")) {
				break;
			} 
			  else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
			
		}
		
		
		
		System.out.println("==프로그램 종료==");
		sc.close();
		
		
	}

}
