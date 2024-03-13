public class User {
    private int uid;
    private String uname;
    private String ucontact;
    private String uborrowedbooks; // Make sure to declare the variable as private

    public User(int id, String name, String contact, String borrowedbooks){
        this.uid = id;
        this.uname = name;
        this.ucontact = contact;
        this.uborrowedbooks = borrowedbooks;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getUcontact() {
        return ucontact;
    }

    public String getUborrowedbooks() {
        return uborrowedbooks;
    }
}
