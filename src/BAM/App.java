package BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BAM.dto.Article;
import BAM.utill.Myutill;

public class App {

	private List<Article> articles;
	
	public App() {
		articles = new ArrayList<>();
	}
	
	public void run() {
			
			System.out.println("==프로그램 시작==");
			
			makeTestData();
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.printf("명령어) ");
				String input = sc.nextLine().trim();
				if(input.length() == 0) {
					System.out.println("명령어를 입력해주세요");
					continue;
				}
				
				if(input.equals("exit")) {
					break;
				}
				
				if(input.equals("article write")) {
					
					System.out.printf("제목 : ");
					String title = sc.nextLine();
					System.out.printf("내용 : ");
					String body = sc.nextLine();
					
					Article article = new Article(title, body, Myutill.regDate);
					articles.add(article);
					
					System.out.printf("%d번글이 생성되었습니다\n", article.id);
					
				}
				else if(input.equals("article list")) {
					
					if(articles.size() == 0) {
						System.out.println("게시글이 없습니다");
						continue; // 이번 반복패턴 지나가고 다음 반복 패턴으로 넘기기.
					}
					
					System.out.printf("  번호  |           작성일          |  제목  |  조회수  |\n");
					for(int i = articles.size()-1; i >= 0 ; i--) {
						Article article = articles.get(i);
						
						System.out.printf("%4d   |    %10s  |%4s  |%6d  |\n", article.id, article.regDate, article.title, article.hit);
					}
					
					
				} 
				 else if(input.startsWith("article detail ")) {
					String[] arr = input.split(" ");
					int id = Integer.parseInt(arr[2]);
					
					Article foundArticle = null;

					for(int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						
						if(article.id == id) {
							foundArticle = article;
							break;
						} 
					}
					
					if(foundArticle == null) {
						System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
						continue;
					}
					
					foundArticle.increaseHit();
					
					System.out.printf("번호 : %d\n", foundArticle.id);
					System.out.printf("날짜 : %s\n", foundArticle.regDate);
					System.out.printf("제목 : %s\n", foundArticle.title);
					System.out.printf("내용 : %s\n", foundArticle.body);
					System.out.printf("조회수 : %d\n", foundArticle.hit);
					
				 }
				 else if(input.startsWith("article modify ")) {
						String[] arr = input.split(" ");
						int id = Integer.parseInt(arr[2]);
						
						Article foundArticle = null;
						
						for(int i = 0; i < articles.size(); i++) {
							Article article = articles.get(i);
							
							if(article.id == id) {
								foundArticle = article;
								break;
							} 
						}
						
						if(foundArticle == null) {
							System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
							continue;
						}
						
						System.out.printf("제목 %s를 무엇으로 변경하시겠습니까? : ", foundArticle.title);
						String title = sc.nextLine();
						System.out.printf("내용 %s를 무엇으로 변경하시겠습니까? : ", foundArticle.body);
						String body = sc.nextLine();
						
						foundArticle.title = title;
						foundArticle.body = body;
						
						System.out.printf("%d번 글이 수정되었습니다.\n", id);
						
					}
				 else if(input.startsWith("article delete ")) {
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
//					break문은 조건문도 빠져나가면서 반복문 자체도 탈출하고 끝이나지만
//					continue문은 해당 '조건문만' 실행하지 않고, 반복문은 이어서 실행하는 제어문이다.
				} 
				else {
					System.out.println("존재하지 않는 명령어 입니다.");
				}
				
			}
			
			System.out.println("==프로그램 종료==");
			sc.close();
			
		}

	private void makeTestData() {
		System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");
		articles.add(new Article("test1", "aa", Myutill.regDate, 1));
		articles.add(new Article("test2", "bb", Myutill.regDate, 2));
		articles.add(new Article("test3", "cc", Myutill.regDate, 3));

	}

}
