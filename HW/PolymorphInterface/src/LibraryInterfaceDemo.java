public class LibraryInterfaceDemo {
    public static void main(String[] args) {

        KidUsers KidUser = new KidUsers();
        AdultUser AdultUser = new AdultUser();

        KidUser.age = 10;
        KidUser.registerAccount();

        KidUser.age = 18;
        KidUser.registerAccount();

        KidUser.bookType = "Kids";
        KidUser.requestBook();

        KidUser.bookType = "Fiction";
        KidUser.requestBook();

        AdultUser.age = 5;
        AdultUser.registerAccount();

        AdultUser.age = 23;
        AdultUser.registerAccount();

        AdultUser.bookType = "Kids";
        AdultUser.requestBook();
        
        AdultUser.bookType = "Fiction";
        AdultUser.requestBook();

    }
}