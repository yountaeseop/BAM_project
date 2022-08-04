package BAM.dto;

public class Article {
	
	public int id;
	public static int num;
	public String title;
	public String body;
	public String regDate;
	public int hit;


	public Article(String title, String body, String regDate) {
		this.id = ++num; //id 자동증가
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.hit = 0;
	}
	
	public Article(String title, String body, String regDate, int hit) {
		this.id = ++num; //id 자동증가
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.hit = hit;
	}

	public void increaseHit() {
		hit++;
	}



}
