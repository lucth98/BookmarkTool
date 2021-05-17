package at.fhcampus.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Bookmark {


    private String url;
    private List<String> tags;
    private Set<Bookmark> associates;
    private int rating;
    private boolean secure;

    private LocalDateTime addingTime;




    public Bookmark() {
    }

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

    public LocalDateTime getAddingTime() {
        return addingTime;
    }

    public void setAddingTime(LocalDateTime addingTime) {
        this.addingTime = addingTime;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookmark bookmark = (Bookmark) o;
        return rating == bookmark.rating && secure == bookmark.secure && url.equals(bookmark.url);
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "url='" + url + '\'' +
                ", rating=" + rating +
                ", secure=" + secure +
                '}';
    }
}
