import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NoteManager {
    private List<Note> notes;
    private Scanner scanner;

    public NoteManager() {
        notes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addNote() {
        System.out.print("Enter note title: ");
        String title = scanner.nextLine();
        System.out.print("Enter note content: ");
        String content = scanner.nextLine();
        Note newNote = new Note(title, content);
        notes.add(newNote);
        System.out.println("Note added successfully with ID: " + newNote.getId());
    }

    public void displayAllNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
            return;
        }
        System.out.println("All Notes:");
        for (Note note : notes) {
            System.out.println("ID: " + note.getId());
            System.out.println("Title: " + note.getTitle());
            System.out.println("Content: " + note.getContent());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NoteManager noteManager = new NoteManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add new note");
            System.out.println("2. Display all notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    noteManager.addNote();
                    break;
                case 2:
                    noteManager.displayAllNotes();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}