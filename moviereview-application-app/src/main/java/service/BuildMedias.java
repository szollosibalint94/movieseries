package service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.Actor;
import domain.Media;
import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.Series;
import domain.Sex;
import domain.User;

public class BuildMedias {
    private List<Media> medias=new ArrayList<>();

    User testUser=User.newUser()
        .name("Teszt Elek")
        .build();

    Media chernobyl=Series.newMedia()
        .id(BigDecimal.valueOf(1))
        .title("Chernobyl")
        .description("In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.")
        .premier(LocalDate.of(2019,5,7))
        .build();

    Actor ignatenko=Actor.newActor()
        .name("Jessie Buckley")
        .born(LocalDate.of(1989,12,28))
        .sex(Sex.FEMALE)
        .biography("Jessie Buckley is an Irish singer and actress, who came in second place in the BBC talent show-themed television series I'd Do Anything, and subsequently played Anne Egermann in the West End revival of Stephen Sondheim's A Little Night Music.")
        .build();

    Actor legasov=Actor.newActor()
        .name("Jared Harris")
        .born(LocalDate.of(1961,8,24))
        .sex(Sex.MALE)
        .biography("Jared Francis Harris was born in London, England. He is the son of Irish actor Richard Harris and Welsh actress Elizabeth Harris (Elizabeth Rees), and brother of Damian Harris and Jamie Harris.")
        .build();

    Actor shcherbina=Actor.newActor()
        .name("Stellan Skarsgård")
        .born(LocalDate.of(1951,6,13))
        .sex(Sex.MALE)
        .biography("Stellan Skarsgård was born in Gothenburg, Västra Götalands län, Sweden, to Gudrun (Larsson) and Jan Skarsgård.")
        .build();

    Review chernobyl1= Review.newReview()
        .media(chernobyl)
        .rating(Rating.GOOD)
        .text("Excellent series")
        .creator(testUser)
        .build();

    Review chernobyl2= Review.newReview()
        .media(chernobyl)
        .rating(Rating.AVERAGE)
        .text("I don't understand the hype...")
        .creator(testUser)
        .build();

    //----------------------------------------------------------------------------------------------------------------------------------------------------------

    Media starWars= Movie.newMedia()
        .id(BigDecimal.valueOf(2))
        .title("Star Wars: Episode IX - The Rise of Skywalker")
        .description("The surviving members of the resistance face the First Order once again, and the legendary conflict between the Jedi and the Sith reaches its peak bringing the Skywalker saga to its end.")
        .premier(LocalDate.of(2019,12,19))
        .build();

    Actor rey=Actor.newActor()
        .name("Daisy Ridley")
        .born(LocalDate.of(1992,4,10))
        .sex(Sex.FEMALE)
        .biography("Daisy Jazz Isobel Ridley is an English actress. She is best known for her breakthrough role as Rey in the 2015 film, Star Wars: Force Awakens (2015).")
        .build();

    Actor ren=Actor.newActor()
        .name("Adam Driver")
        .born(LocalDate.of(1983,11,19))
        .sex(Sex.MALE)
        .biography("Adam Douglas Driver was born in San Diego, California. His mother, Nancy (Needham) Wright, is a paralegal from Mishawaka, Indiana, and his father, Joe Douglas Driver, who has deep roots in the American South, is from Little Rock, Arkansas.")
        .build();

    Actor luke=Actor.newActor()
        .name("Mark Hamill")
        .born(LocalDate.of(1951,9,25))
        .sex(Sex.MALE)
        .biography("Mark Hamill is best known for his portrayal of Luke Skywalker in the original Star Wars trilogy.")
        .build();

    Review starWars1= Review.newReview()
        .media(starWars)
        .rating(Rating.GOOD)
        .text("Excellent movie")
        .creator(testUser)
        .build();

    Review starWars2= Review.newReview()
        .media(starWars)
        .rating(Rating.AVERAGE)
        .text("I don't understand the hype...")
        .creator(testUser)
        .build();

    private void build(){
        //Finish Chernobyl series
        ignatenko.addMovieToFilmography(chernobyl);
        legasov.addMovieToFilmography(chernobyl);
        shcherbina.addMovieToFilmography(chernobyl);
        chernobyl.addCast(ignatenko);
        chernobyl.addCast(legasov);
        chernobyl.addCast(shcherbina);
        chernobyl.addReview(chernobyl1);
        chernobyl.addReview(chernobyl2);

        //Finish Star Wars movie
        rey.addMovieToFilmography(starWars);
        ren.addMovieToFilmography(starWars);
        luke.addMovieToFilmography(starWars);
        starWars.addCast(rey);
        starWars.addCast(ren);
        starWars.addCast(luke);
        starWars.addReview(starWars1);
        starWars.addReview(starWars2);

        medias.add(chernobyl);
        medias.add(starWars);
    }

    public List<Media> getMedias() {
        build();
        return medias;
    }
}
