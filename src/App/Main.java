package App;

import java.util.ArrayList;
import java.util.Scanner;

import App.utill.Myutill;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Article> articles = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("==프로그램 시작==");
		int lastArticleId = 0;
		
		while(true) {
			System.out.printf("명령어) ");
			String input = sc.nextLine().trim();
			
			if(input.equals("article list")) {
				System.out.printf("번호  /  제목\n");
				
				for(int i = articles.size()-1; i >= 0 ; i--) {
					int articleId = articles.get(i).id;
					String articleTitle = articles.get(i).title;
					
					System.out.printf("%d %8s\n",articleId, articleTitle);
					
				}
				
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다");
				}
				
			} else if(input.equals("article write")) {
				int id = lastArticleId + 1;
				lastArticleId = id;
				
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
				articles.add(new Article(id, title, body, Myutill.regDate));
				
				System.out.printf("%d번글이 생성되었습니다\n", id);
				
				id++;
				
			} else if(input.startsWith("article detail ")) {
				String[] arr = input.split(" ");
				int num = Integer.parseInt(arr[2]);
				
				
				Article article = null;
				
				for (int i = 0; i < articles.size(); i++) {
					if(num - 1 == i) {
						article = articles.get(i);
						break;
					} 
				}
				
				if(article == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.", num);
					break;
				}
				
				System.out.printf("번호 : %d\n", article.id);
				System.out.printf("날짜 : %s\n", article.regDate);
				System.out.printf("제목 : %s\n", article.title);
				System.out.printf("내용 : %s\n", article.body);
				
			} else if(input.startsWith("article delete ")) {
				String[] arr = input.split(" ");
				int id = Integer.parseInt(arr[2]);
				
				int foundIndex = -1;

				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					if(article.id == id) {
						foundIndex = i;
						break;
					} 
				}
				
				if(foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				
				articles.remove(foundIndex);
				System.out.printf("%d번 게시물을 삭제했습니다.\n", id);
//				break문은 조건문도 빠져나가면서 반복문 자체도 탈출하고 끝이나지만
//				continue문은 해당 '조건문만' 실행하지 않고, 반복문은 이어서 실행하는 제어문이다.
			}
			else if(input.equals("exit")) {
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
