package pawel.ApiReader.model;

import com.google.gson.JsonObject;

public class Owner {

    private String fullName;
    private String description;
    private String cloneURL;
    private Integer stars;
    private String createdAt;

    public Owner() {
    }

    public Owner(String fullName, String description, String cloneURL, Integer stars, String createdAt) {
        this.fullName = fullName;
        this.description = description;
        this.cloneURL = cloneURL;
        this.stars = stars;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", cloneURL='" + cloneURL + '\'' +
                ", stars=" + stars +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCloneURL() {
        return cloneURL;
    }

    public void setCloneURL(String cloneURL) {
        this.cloneURL = cloneURL;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
