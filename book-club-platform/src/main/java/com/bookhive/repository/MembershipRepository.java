package com.bookhive.repository;

import com.bookhive.entity.Membership;
import com.bookhive.projection.BookClubProjection;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    @Cacheable(value = "bookClubs", key = "#userId")
    @Query("SELECT m.bookClub.id AS id, m.bookClub.name AS name, m.bookClub.description AS description " +
           "FROM Membership m WHERE m.user.id = :userId")
    List<BookClubProjection> findBookClubsByUserId(Long userId, Pageable pageable);
}
