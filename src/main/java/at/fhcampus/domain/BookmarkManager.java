package at.fhcampus.domain;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class BookmarkManager {

    private List<Bookmark> bookmarkArrayList = new ArrayList<>();


    public void addBookmark(String url) {
        if (url == null)
            throw new IllegalArgumentException("Url can't be null"); //to test
        url = url.toLowerCase();
        if (validateURL(url)) {



            for (Bookmark bookmark : bookmarkArrayList) {
                if (bookmark.getUrl().equalsIgnoreCase(url)) {
                    bookmark.setRating(bookmark.getRating() + 1);
                    return;
                }
            }
            Bookmark bookmark = new Bookmark(url);
            bookmarkArrayList.add(bookmark);
            addAssociates(bookmark);
        } else
            throw new IllegalArgumentException("URL is not valid!");
    }

    public void addTagToBookmark(String url, String tag) {
        bookmarkArrayList.forEach(bookmark -> {   if (bookmark.getUrl().equalsIgnoreCase(url)) {
            bookmark.getTags().add(tag);
        }});

        /*for (Bookmark bookmark : bookmarkArrayList) {
            if (bookmark.getUrl().equalsIgnoreCase(url)) {
                bookmark.getTags().add(tag);
            }
        }*/
    }

    static public boolean validateURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public int getNumbersOfSecureURL() {
        return (int) bookmarkArrayList.stream()
                .filter(Bookmark::isSecure)
                .count();
    }

    public List<Bookmark> filterByTags(List<String> tags) {
        return bookmarkArrayList.stream()
                .flatMap(bookmark ->
                        bookmark.getTags().stream()
                                .map(tag -> {
                                    if (tags.contains(tag))
                                        return bookmark;
                                    return null;
                                }))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public String getDomainName(String url) {
        try {
            URI uri = new URI(url);
            String domain = uri.getHost();
            return domain.startsWith("www.") ? domain.substring(4) : domain;
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void addAssociates(Bookmark bookmark) {
        String bookmarkDomain = getDomainName(bookmark.getUrl());
        if (bookmarkDomain != null)
        bookmarkArrayList.stream()
                .filter(element -> getDomainName(element.getUrl()).equalsIgnoreCase(bookmarkDomain) && !bookmark.equals(element))
                .forEach(element -> {
                    element.getAssociates().add(bookmark);
                    bookmark.getAssociates().add(element);
                });
    }


    public List<Bookmark> getBookmarkArrayList() {
        return bookmarkArrayList;
    }

    public void setBookmarkArrayList(List<Bookmark> bookmarkArrayList) {
        this.bookmarkArrayList = bookmarkArrayList;
    }

}
