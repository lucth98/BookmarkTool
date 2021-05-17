package at.fhcampus.domain;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            /*DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime= LocalDateTime.now().format(dateTimeFormatter.withLocale());


            localDateTime.*/

            bookmark.setAddingTime(LocalDateTime.now());
            bookmarkArrayList.add(bookmark);
            addAssociates(bookmark);
        } else
            throw new IllegalArgumentException("URL is not valid!");
    }

    public void addTagToBookmark(String url, String tag) {
        bookmarkArrayList.forEach(bookmark -> {
            if (bookmark.getUrl().equalsIgnoreCase(url)) {
                bookmark.getTags().add(tag);
            }
        });

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
        String returnValue = null;
        try {
            URI uri = new URI(url);
            String domain = uri.getHost();
            returnValue = domain.startsWith("www.") ? domain.substring(4) : domain;
            // return returnValue;
        } catch (Exception e) {
            //   System.out.println(e.getMessage());
            // returnValue=null;
        }
        return returnValue;
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

    public void removeTagFromBookmark(String url, String tag) {
        for (Bookmark bookmark : bookmarkArrayList) {
            if (bookmark.getUrl().equalsIgnoreCase(url)) {
                bookmark.getTags().removeIf(currentTag -> currentTag.equalsIgnoreCase(tag));
/*               for (int i=0;i<bookmark.getTags().size();i++){
                    if(bookmark.getTags().get(i).equalsIgnoreCase(tag)){
                        bookmark.getTags().remove(i);
                    }
               }*/
            }
        }

    }

    public void removeBookmark(String url) {
//        for (Bookmark bookmark:bookmarkArrayList) {
//            if(bookmark.getUrl().equalsIgnoreCase(url)){
//                bookmarkArrayList.remove(bookmark);
//            }
//        }
/*        for (int i=0;i<bookmarkArrayList.size();i++){
            if(bookmarkArrayList.get(i).getUrl().equalsIgnoreCase(url)){
                bookmarkArrayList.remove(i);
          }
        }*/
        bookmarkArrayList.removeIf(currentBookmark -> currentBookmark.getUrl().equalsIgnoreCase(url));
    }

    public List<Bookmark> getSortedBookmarksByRating(){
        return null;
    }
}
