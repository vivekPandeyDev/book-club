package com.bookhive;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookhive.entity.Achievement;
import com.bookhive.entity.Book;
import com.bookhive.entity.BookClub;
import com.bookhive.entity.Follow;
import com.bookhive.entity.Recommendation;
import com.bookhive.entity.Review;
import com.bookhive.entity.User;
import com.bookhive.repository.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final BookClubRepository bookClubRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final FollowRepository followRepository;
    private final AchievementRepository achievementRepository;
    private final ReviewRepository reviewRepository;
    private final RecommendationRepository recommendationRepository;



    @Override
    @Transactional
    public void run(String... args) {

        if (userRepository.count() == 0) {
            // Create users
            User john = new User();
            john.setUsername("john_doe");
            john.setEmail("john@example.com");
            john.setPassword("password");
            john.setRole("USER");
            john.setAvatar("https://example.com/john_avatar.png");
            john.setBio("Love to read books");

            User jane = new User();
            jane.setUsername("jane_doe");
            jane.setEmail("jane@example.com");
            jane.setPassword("password");
            jane.setRole("USER");

            userRepository.saveAll(List.of(john, jane));

            // Create Follow relationship (John follows Jane)
            Follow follow = new Follow();
            follow.setFollower(john);
            follow.setFollowing(jane);
            followRepository.save(follow);

            // Create Achievements for John
            Achievement achievement1 = new Achievement();
            achievement1.setTitle("Top Reader");
            achievement1.setDescription("Read 50 books");
            achievement1.setUser(john);

            Achievement achievement2 = new Achievement();
            achievement2.setTitle("Book Critic");
            achievement2.setDescription("Reviewed 10 books");
            achievement2.setUser(john);

            achievementRepository.saveAll(List.of(achievement1, achievement2));
            //create book club
            BookClub bookClub = new BookClub();
            bookClub.setCreatedAt(LocalDateTime.now());
            bookClub.setName("test-club");
            bookClub.setOwner(john);
            bookClub = bookClubRepository.saveAndFlush(bookClub);

            // Create a Book
            Book book = new Book();
            book.setTitle("The Great Gatsby");
            book.setAuthor("F. Scott Fitzgerald");
            book.setCoverImageUrl("test ulr");
            book.setBookUrl("test book url");
            book.setBookClub(bookClub);
            bookRepository.save(book);
            // Create a Review for John
            Review review = new Review();
            review.setBook(book);
            review.setUser(john);
            review.setRating(4.5);
            review.setContent("An amazing book with deep meaning.");
            reviewRepository.save(review);

            // Create a Recommendation for John
            Recommendation recommendation = new Recommendation();
            recommendation.setBook(book);
            recommendation.setUser(john);
            recommendation.setScore(9.0);
            recommendationRepository.save(recommendation);

            System.out.println("Sample data loaded successfully!");
        }

    }

}