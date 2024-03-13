public class book {
    private int bid;
    String btitle;
    String bauthor;
    String bgenre;
    char bAvailability;

    public book(int id, String title, String author, String genre, char availability){
        this.bid=id;
        this.btitle=title;
        this.bauthor=author;
        this.bgenre=genre;
        this.bAvailability=availability;
    }

    public int getBid() {
        return bid;
    }
}
