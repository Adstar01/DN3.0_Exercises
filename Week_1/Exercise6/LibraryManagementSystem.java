package Exercise6;

public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size == books.length) {
            System.out.println("Library is full. Cannot add more books.");
            return;
        }
        books[size] = book;
        size++;
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(5);

        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("B002", "1984", "George Orwell"));
        library.addBook(new Book("B003", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("B004", "Moby-Dick", "Herman Melville"));
        library.addBook(new Book("B005", "War and Peace", "Leo Tolstoy"));

        System.out.println("Linear Search:");
        Book book = library.linearSearchByTitle("1984");
        System.out.println(book != null ? book : "Book not found");

        System.out.println("\nBinary Search:");
        book = library.binarySearchByTitle("1984");
        System.out.println(book != null ? book : "Book not found");
    }
}
