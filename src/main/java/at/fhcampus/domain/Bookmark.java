package at.fhcampus.domain;

import java.util.*;

public class Bookmark {

    private String url;
    private List<String> tags;
    private Set<Bookmark> associates;
    private int rating;
    private boolean secure;

    public Bookmark(String url) {
        this.url = url.toLowerCase();
        this.rating = 1;
        tags = new ArrayList<>();
        associates = new LinkedHashSet<>();
        secure = url.startsWith("https");
    }

    public Bookmark(String url, String tag) {
        this(url);
        this.tags.add(tag);
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public Set<Bookmark> getAssociates() {
        return associates;
    }

    public void setAssociates(Set<Bookmark> associates) {
        this.associates = associates;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "url='" + url + '\'' +
                ", tags=" + tags +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookmark bookmark = (Bookmark) o;
        return rating == bookmark.rating && Objects.equals(url, bookmark.url) && Objects.equals(tags, bookmark.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, tags, rating);
    }
}
