public class Book {
    private String title;
    private String author;
    private int year;

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }


    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setYear(int year) { this.year = year; }


    public void displayInfo() {
        System.out.println("Книга: " + title + ", Автор: " + author + ", Рік: " + year);
    }


    public static void main(String[] args) {
        Book myBook = new Book();
        myBook.setTitle("Таро Уейта. Велика книга символів");
        myBook.setAuthor("Мартін Велс");
        myBook.setYear(2021);
        myBook.displayInfo();
    }
}

