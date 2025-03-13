package com.bookhive;

import com.bookhive.entity.*;
import com.bookhive.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader {



    @Bean
    CommandLineRunner loadData(UserRepository userRepository,
                               BookRepository bookRepository,
                               BookClubRepository bookClubRepository,
                               MembershipRepository membershipRepository,
                               DiscussionRepository discussionRepository,
                               CommentRepository commentRepository) {
        return args -> {

            if(userRepository.findUserByUsername("john_doe").isPresent()){
                return;
            }
            // Create Users
            User user1 = new User();
            user1.setUsername("john_doe");
            user1.setEmail("john@example.com");
            user1.setPassword("password");

            User user2 = new User();
            user2.setUsername("jane_doe");
            user2.setEmail("jane@example.com");
            user2.setPassword("password");

            userRepository.saveAll(List.of(user1, user2));

            // Create Books
            Book book1 = new Book();
            book1.setTitle("The Alchemist");
            book1.setAuthor("Paulo Coelho");

            Book book2 = new Book();
            book2.setTitle("1984");
            book2.setAuthor("George Orwell");

            bookRepository.saveAll(List.of(book1, book2));

            // Create Book Club
            BookClub bookClub = new BookClub();
            bookClub.setName("Philosophy Readers");
            bookClub.setDescription("Discussing philosophical books");
            bookClub.setOwner(user2);
            bookClubRepository.save(bookClub);

            // Create Membership
            Membership membership = new Membership();
            membership.setUser(user1);
            membership.setBookClub(bookClub);
            membership.setJoinedAt(LocalDateTime.now());

            membershipRepository.save(membership);

            // Create Discussion
            Discussion discussion = new Discussion();
            discussion.setTitle("Thoughts on The Alchemist");
            discussion.setBook(book1);
            discussion.setUser(user1);
            discussion.setCreatedAt(LocalDateTime.now());

            discussionRepository.save(discussion);

            // Create Comment
            Comment comment = new Comment();
            comment.setDiscussion(discussion);
            comment.setUser(user2);
            comment.setContent("Great insight!");
            comment.setCreatedAt(LocalDateTime.now());

            commentRepository.save(comment);

            System.out.println("Sample data loaded successfully!");
        };
    }
}
