package domain;


public class Article {
    private int id;
    private String title;
    private String brief;
    private String content;
    private String createDate;
    private boolean isPublished;
    private int user_id;


    public Article(int id, String title, String brief, String content, String createDate, boolean isPublished, int user_id) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.isPublished = isPublished;
        this.user_id = user_id;
    }
    public void changeInfo(String title,String brief,String content,String createDate){
        setTitle(title);
        setBrief(brief);
        setContent(content);
        setCreateDate(createDate);
    }
    public void changePublishied(boolean isPublished){
        this.isPublished = isPublished;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getContent() {
        return content;
    }

    public String getBrief() {
        return brief;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }
}
