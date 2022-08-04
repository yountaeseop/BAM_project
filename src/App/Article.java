package App;

public class Article {
	
	int id;
	static int num;
	String title;
	String body;
	String regDate;
	int hit;

	public Article(String title, String body, String regDate) {
		this.id = ++num; //id 자동증가
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.hit = 0;
	}

	public void increaseHit() {
		hit++;
	}

//	public Article(int id, String title, String body) {
//		this.id = id;
//		this.title = title;
//		this.body = body;
//	}

}
