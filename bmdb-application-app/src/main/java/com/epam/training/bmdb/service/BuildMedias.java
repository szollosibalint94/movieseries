package com.epam.training.bmdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.bmdb.domain.Actor;
import com.epam.training.bmdb.domain.Media;
import com.epam.training.bmdb.domain.Movie;
import com.epam.training.bmdb.domain.Rating;
import com.epam.training.bmdb.domain.Review;
import com.epam.training.bmdb.domain.Series;
import com.epam.training.bmdb.domain.Sex;
import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.domain.UserRole;
import com.epam.training.bmdb.repository.MediaRepository;

@Component
public class BuildMedias {

    @Autowired MediaRepository mediaRepository;

    private List<Media> medias = new ArrayList<>();

    private void build() {
        User testUser = User.newUser()
            .name("Teszt Elek")
            .email("test@test.com")
            .passWord("Passw0rd")
            .addrole(UserRole.ROLE_USER)
            .build();

        User me = User.newUser()
            .name("Urbán Gergely")
            .email("gergo093@hotmail.com")
            .passWord("Passw0rd")
            .addrole(UserRole.ROLE_ADMIN)
            .build();

        Media chernobyl = Series.newSeries()
            .id(1L)
            .title("Chernobyl")
            .description(
                "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.")
            .premier(LocalDate.of(2019, 5, 7))
            .build();

        Actor ignatenko = Actor.newActor()
            .name("Jessie Buckley")
            .born(LocalDate.of(1989, 12, 28))
            .sex(Sex.FEMALE)
            .biography(
                "Jessie Buckley is an Irish singer and actress, who came in second place in the BBC talent show-themed television series I'd Do Anything, and subsequently played Anne Egermann in the West End revival of Stephen Sondheim's A Little Night Music.")
            .build();

        Actor legasov = Actor.newActor()
            .name("Jared Harris")
            .born(LocalDate.of(1961, 8, 24))
            .sex(Sex.MALE)
            .biography(
                "Jared Francis Harris was born in London, England. He is the son of Irish actor Richard Harris and Welsh actress Elizabeth Harris (Elizabeth Rees), and brother of Damian Harris and Jamie Harris.")
            .build();

        Actor shcherbina = Actor.newActor()
            .name("Stellan Skarsgård")
            .born(LocalDate.of(1951, 6, 13))
            .sex(Sex.MALE)
            .biography("Stellan Skarsgård was born in Gothenburg, Västra Götalands län, Sweden, to Gudrun (Larsson) and Jan Skarsgård.")
            .build();

        Review chernobyl1 = Review.newReview()
            .id(1L)
            .media(chernobyl)
            .rating(Rating.GOOD)
            .text("Excellent series")
            .creator(me)
            .build();

        Review chernobyl2 = Review.newReview()
            .id(2L)
            .media(chernobyl)
            .rating(Rating.AVERAGE)
            .text("I don't understand the hype...")
            .creator(testUser)
            .build();

        //----------------------------------------------------------------------------------------------------------------------------------------------------------

        Media starWars = Movie.newMovie()
            .id(2L)
            .title("Star Wars: Episode IX - The Rise of Skywalker")
            .description(
                "The surviving members of the resistance face the First Order once again, and the legendary conflict between the Jedi and the Sith reaches its peak bringing the Skywalker saga to its end.")
            .premier(LocalDate.of(2019, 12, 19))
            .build();

        Actor rey = Actor.newActor()
            .name("Daisy Ridley")
            .born(LocalDate.of(1992, 4, 10))
            .sex(Sex.FEMALE)
            .biography(
                "Daisy Jazz Isobel Ridley is an English actress. She is best known for her breakthrough role as Rey in the 2015 film, Star Wars: Force Awakens (2015).")
            .build();

        Actor ren = Actor.newActor()
            .name("Adam Driver")
            .born(LocalDate.of(1983, 11, 19))
            .sex(Sex.MALE)
            .biography(
                "Adam Douglas Driver was born in San Diego, California. His mother, Nancy (Needham) Wright, is a paralegal from Mishawaka, Indiana, and his father, Joe Douglas Driver, who has deep roots in the American South, is from Little Rock, Arkansas.")
            .build();

        Actor luke = Actor.newActor()
            .name("Mark Hamill")
            .born(LocalDate.of(1951, 9, 25))
            .sex(Sex.MALE)
            .biography("Mark Hamill is best known for his portrayal of Luke Skywalker in the original Star Wars trilogy.")
            .build();

        Review starWars1 = Review.newReview()
            .id(3L)
            .media(starWars)
            .rating(Rating.GOOD)
            .text("Excellent movie")
            .creator(testUser)
            .build();

        Review starWars2 = Review.newReview()
            .id(4L)
            .media(starWars)
            .rating(Rating.AVERAGE)
            .text("I don't understand the hype...")
            .creator(me)
            .build();

        //----------------------------------------------------------------------------------------------------------------------------------------------------------

        Media fordFerrari = Movie.newMovie()
            .id(3L)
            .title("Ford v Ferrari")
            .description("American car designer Carroll Shelby and driver Ken Miles battle corporate interference, the laws of physics and their own personal demons to build a revolutionary race car for Ford and challenge Ferrari at the 24 Hours of Le Mans in 1966.")
            .premier(LocalDate.of(2019, 11, 15))
            .build();

        Actor shelby = Actor.newActor()
            .name("Matt Damon")
            .born(LocalDate.of(1970, 10, 8))
            .sex(Sex.MALE)
            .biography("Matthew Paige Damon was born on October 8, 1970, in Boston, Massachusetts, to Kent Damon, a stockbroker, realtor and tax preparer, and Nancy Carlsson-Paige, an early childhood education professor at Lesley University.")
            .build();

        Actor miles = Actor.newActor()
            .name("Christian Bale")
            .born(LocalDate.of(1974, 1, 30))
            .sex(Sex.MALE)
            .biography("Christian Charles Philip Bale was born in Pembrokeshire, Wales, UK on January 30, 1974, to English parents Jennifer \"Jenny\" (James) and David Bale.")
            .build();

        Actor iacocca = Actor.newActor()
            .name("Jon Bernthal")
            .born(LocalDate.of(1976, 9, 20))
            .sex(Sex.MALE)
            .biography(
                "Jon Bernthal was born and raised in Washington D.C., the son of Joan (Marx) and Eric Bernthal, a lawyer.")
            .build();

        Review fordFerrari1 = Review.newReview()
            .media(fordFerrari)
            .rating(Rating.GOOD)
            .text("A lot of notes were hit by Ford v Ferrari. The characters are fleshed out very well and give you the emotional attachment you're looking for in a movie.")
            .creator(testUser)
            .build();

        Review fordFerrari2 = Review.newReview()
            .media(fordFerrari)
            .rating(Rating.AVERAGE)
            .text("well done for its genre, but only just, good acting on the part of Bale and Damon")
            .creator(me)
            .build();

        //----------------------------------------------------------------------------------------------------------------------------------------------------------

        Media inception = Movie.newMovie()
            .id(4L)
            .title("Inception")
            .description(
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.")
            .premier(LocalDate.of(2010, 7, 16))
            .build();

        Actor cobb = Actor.newActor()
            .name("Leonardo DiCaprio")
            .born(LocalDate.of(1974, 11, 11))
            .sex(Sex.MALE)
            .biography("Few actors in the world have had a career quite as diverse as Leonardo DiCaprio's.")
            .build();

        Actor arthur = Actor.newActor()
            .name("Joseph Gordon-Levitt")
            .born(LocalDate.of(1981, 1, 30))
            .sex(Sex.MALE)
            .biography("Joseph Gordon-Levitt has completed production on the untitled Henry Joost/Ariel Schulman sci-fi film for Netflix in which he stars opposite Jamie Foxx and on the independent thriller, 7500, written and directed by Patrick Vollarth.")
            .build();

        Actor ariadne = Actor.newActor()
            .name("Ellen Page")
            .born(LocalDate.of(1987, 2, 20))
            .sex(Sex.FEMALE)
            .biography("Ellen Grace Philpotts-Page was born on February 21, 1987, in Halifax, Nova Scotia, to Martha Philpotts, a teacher, and Dennis Page, a graphic designer. ")
            .build();

        Review inception1 = Review.newReview()
            .media(inception)
            .rating(Rating.GOOD)
            .text("Surrealism can appear to be ineffably bizarre, or inquisitively titillating, depending purely on the viewer's intellect.")
            .creator(testUser)
            .build();

        Review inception2 = Review.newReview()
            .media(inception)
            .rating(Rating.AVERAGE)
            .text("I cannot understand why this movie is rated so highly, it is infantile in its storyline and soooo boring.")
            .creator(me)
            .build();

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

        //Finish Ford vs Ferrari
        shelby.addMovieToFilmography(fordFerrari);
        miles.addMovieToFilmography(fordFerrari);
        iacocca.addMovieToFilmography(fordFerrari);
        fordFerrari.addCast(shelby);
        fordFerrari.addCast(miles);
        fordFerrari.addCast(iacocca);
        fordFerrari.addReview(fordFerrari1);
        fordFerrari.addReview(fordFerrari2);

        //Finish Inception
        cobb.addMovieToFilmography(inception);
        arthur.addMovieToFilmography(inception);
        ariadne.addMovieToFilmography(inception);
        inception.addCast(cobb);
        inception.addCast(arthur);
        inception.addCast(ariadne);
        inception.addReview(inception1);
        inception.addReview(inception2);

        testUser.addReview(chernobyl1);
        testUser.addReview(starWars1);
        testUser.addReview(fordFerrari1);
        testUser.addReview(inception1);

        me.addReview(chernobyl2);
        me.addReview(starWars2);
        me.addReview(fordFerrari2);
        me.addReview(inception2);

        medias.add(chernobyl);
        mediaRepository.save(chernobyl);
        medias.add(starWars);
        mediaRepository.save(starWars);
        medias.add(fordFerrari);
        mediaRepository.save(fordFerrari);
        medias.add(inception);
        mediaRepository.save(inception);
    }

    public void buildMedias() {
        build();
    }

    public List<Media> getMedias() {
        build();
        return medias;
    }
}
