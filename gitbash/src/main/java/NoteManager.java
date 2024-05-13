import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteManager {
    private List<Note> notes;
    private int nextId;

    public NoteManager() {
        this.notes = new ArrayList<>();
        this.nextId = 1;
    }

    public void addNote(String title, String content) {
        Note note = new Note(nextId++, title, content);
        notes.add(note);
        System.out.println("Note added successfully!");
    }

    public void viewAllNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }
        for (Note note : notes) {
            System.out.println("ID: " + note.getId());
            System.out.println("Title: " + note.getTitle());
            System.out.println("Content: " + note.getContent());
            System.out.println("------------");
        }
    }

    public void deleteNote(int id) {
        notes.removeIf(note -> note.getId() == id);
        System.out.println("Note deleted successfully!");
    }

    public static void main(String[] args) {
        NoteManager noteManager = new NoteManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Delete Note");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.next();
                    System.out.print("Enter content: ");
                    String content = scanner.next();
                    noteManager.addNote(title, content);
                    break;
                case 2:
                    noteManager.viewAllNotes();
                    break;
                case 3:
                    System.out.print("Enter note ID to delete: ");
                    int id = scanner.nextInt();
                    noteManager.deleteNote(id);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}