import java.util.Date;

 public class Post {
	private String title;
	private Date date;
	private String content;
	private int likes;
	private int deslikes;

	//métodos get e set
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDeslikes() {
		return deslikes;
	}

	public void setDeslikes(int deslikes) {
		this.deslikes = deslikes;
	}

	//métodos do blog
	public void like(Post post) { 
		int quant = post.getLikes(); //pega do metodo get, soma e devolve o novo numero de 
		quant++;                    //curtidas para o metodo set, o mesmo com o deslike
		post.setLikes(quant);

	}

	public void dislike(Post post) { 
		int quant = post.getDeslikes();
		quant++;
		post.setDeslikes(quant);
	}

	public void show(){
		System.out.println("Título: " +title+ "\nConteúdo: "+content+"\nData: "+date);
		System.out.println("Likes: " +likes+ "\nDeslikes : "+deslikes);
	}
}

	


