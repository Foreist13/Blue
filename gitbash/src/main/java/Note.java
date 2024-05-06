import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Note {
    private static int idCounter = 0;
    private int id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.id = ++idCounter;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}