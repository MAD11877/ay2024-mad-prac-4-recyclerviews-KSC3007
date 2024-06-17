package sg.edu.np.mad.madpractical4;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean isfollowed;


    public Integer getId() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public boolean getFollowed() {return isfollowed;}

    public void setId(int id) {this.id = id;}
    public void setName(String username) {this.name = username;}
    public void setDescription(String description) {this.description = description;}
    public void setFollowed(boolean followed) {this.isfollowed = followed;}

    public User(String name, String description, int id, boolean followed){
        this.name = name;
        this.description = description;
        this.id = id;
        this.isfollowed = isfollowed;
    }
}
