package Movie;


import java.util.*;
public class MovieRental {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Insert or Get");
        String selection=scanner.nextLine();
        System.out.println("Choose a choice");
        System.out.println("1.Comedy");
        System.out.println("2.Thriller");
        System.out.println("3.Romance");
        System.out.println("4.ScienceFiction");
        System.out.println("5.Adventure");
        System.out.println("6.Animated");
        int choice=scanner.nextInt();
        String movie;
        String director,genre;
        int year,quantity,sno;
        double imdb;
        int price;
        String name;
        ComedyMovie comedyMovie= new ComedyMovie();
        ThrillerMovie thrillerMovie = new ThrillerMovie();
        RomanceMovie romanceMovie = new RomanceMovie();
        ScienceFictionMovie scienceFictionMovie = new ScienceFictionMovie();
        AdventureMovie adventureMovie = new AdventureMovie();
        AnimatedMovie animatedMovie = new AnimatedMovie();
        if(selection.equals("Insert")){
            switch (choice){
                case 1:
                    System.out.println("Sno:");
                    sno = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Movie Name:");
                    movie = scanner.nextLine();
                    System.out.println("Director Name:");
                    director = scanner.nextLine();
                    System.out.println("Year:");
                    year = scanner.nextInt();
                    System.out.println("Imdb:");
                    imdb = scanner.nextDouble();
                    System.out.println("Price:");
                    price = scanner.nextInt();
                    System.out.println("Quantity:");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Genre:");
                    genre = scanner.nextLine();
                    comedyMovie= new ComedyMovie(sno,movie,director,year,imdb, price,quantity,genre);
                    comedyMovie.DBconnection(selection);
                case 2:
                    System.out.println("Sno:");
                    sno = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Movie Name:");
                    movie = scanner.nextLine();
                    System.out.println("Director Name:");
                    director = scanner.nextLine();
                    System.out.println("Year:");
                    year = scanner.nextInt();
                    System.out.println("Imdb:");
                    imdb = scanner.nextDouble();
                    System.out.println("Price:");
                    price = scanner.nextInt();
                    System.out.println("Quantity:");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Genre:");
                    genre = scanner.nextLine();
                    thrillerMovie = new ThrillerMovie(sno,movie,director,year,imdb,price,quantity,genre);
                    thrillerMovie.DBconnection(selection);
                    break;
                case 3:
                    System.out.println("Sno:");
                    sno = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Movie Name:");
                    movie = scanner.nextLine();
                    System.out.println("Director Name:");
                    director = scanner.nextLine();
                    System.out.println("Year:");
                    year = scanner.nextInt();
                    System.out.println("Imdb:");
                    imdb = scanner.nextDouble();
                    System.out.println("Price:");
                    price = scanner.nextInt();
                    System.out.println("Quantity:");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Genre:");
                    genre = scanner.nextLine();
                    romanceMovie = new RomanceMovie(sno,movie,director,year,imdb,price,quantity,genre);
                    romanceMovie.DBconnection(selection);
                    break;
                case 4:
                    System.out.println("Sno:");
                    sno = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Movie Name:");
                    movie = scanner.nextLine();
                    System.out.println("Director Name:");
                    director = scanner.nextLine();
                    System.out.println("Year:");
                    year = scanner.nextInt();
                    System.out.println("Imdb:");
                    imdb = scanner.nextDouble();
                    System.out.println("Price:");
                    price = scanner.nextInt();
                    System.out.println("Quantity:");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Genre:");
                    genre = scanner.nextLine();
                    scienceFictionMovie = new ScienceFictionMovie(sno,movie,director,year,imdb,price,quantity,genre);
                    scienceFictionMovie.DBconnection(selection);
                    break;
                case 5:
                    System.out.println("Sno:");
                    sno = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Movie Name:");
                    movie = scanner.nextLine();
                    System.out.println("Director Name:");
                    director = scanner.nextLine();
                    System.out.println("Year:");
                    year = scanner.nextInt();
                    System.out.println("Imdb:");
                    imdb = scanner.nextDouble();
                    System.out.println("Price:");
                    price = scanner.nextInt();
                    System.out.println("Quantity:");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Genre:");
                    genre = scanner.nextLine();
                    adventureMovie = new AdventureMovie(sno,movie,director,year,imdb,price,quantity,genre);
                    adventureMovie.DBconnection(selection);
                    break;
                case 6:
                    System.out.println("Sno:");
                    sno = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Movie Name:");
                    movie = scanner.nextLine();
                    System.out.println("Director Name:");
                    director = scanner.nextLine();
                    System.out.println("Year:");
                    year = scanner.nextInt();
                    System.out.println("Imdb:");
                    imdb = scanner.nextDouble();
                    System.out.println("Price:");
                    price = scanner.nextInt();
                    System.out.println("Quantity:");
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Genre:");
                    genre = scanner.nextLine();
                    animatedMovie = new AnimatedMovie(sno,movie,director,year,imdb,price,quantity,genre);
                    animatedMovie.DBconnection(selection);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        else {
            switch(choice) {
                case 1:
                    name=comedyMovie.getCustomerMovie();
                    comedyMovie=new ComedyMovie(name);
                    comedyMovie.DBconnection(selection);
                    break;
                case 2:
                    name=thrillerMovie.getCustomerMovie();
                    thrillerMovie=new ThrillerMovie(name);
                    thrillerMovie.DBconnection(selection);
                    break;
                case 3:
                    name= romanceMovie.getCustomerMovie();
                    romanceMovie=new RomanceMovie(name);
                    romanceMovie.DBconnection(selection);
                    break;
                case 4:
                    name= scienceFictionMovie.getCustomerMovie();
                    scienceFictionMovie=new ScienceFictionMovie(name);
                    scienceFictionMovie.DBconnection(selection);
                    break;
                case 5:
                    name= adventureMovie.getCustomerMovie();
                    adventureMovie=new AdventureMovie(name);
                    adventureMovie.DBconnection(selection);
                    break;
                case 6:
                    name= animatedMovie.getCustomerMovie();
                    animatedMovie=new AnimatedMovie(name);
                    animatedMovie.DBconnection(selection);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}