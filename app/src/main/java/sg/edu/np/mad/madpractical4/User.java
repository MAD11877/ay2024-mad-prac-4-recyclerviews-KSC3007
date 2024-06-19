package sg.edu.np.mad.madpractical4;

public class User {
    public String name;
    public String description;
    public int image;
    public boolean isfollowed;


    public Integer getImage() {return image;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public boolean getFollowed() {return isfollowed;}

    public void setImage(int image) {this.image = image;}
    public void setName(String username) {this.name = username;}
    public void setDescription(String description) {this.description = description;}
    public void setFollowed(boolean followed) {this.isfollowed = followed;}

    public User(String name, String description, int image, boolean followed){
        this.name = name;
        this.description = description;
        this.image = image;
        this.isfollowed = isfollowed;
    }
}
