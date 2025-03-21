package com.bookhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookhive.entity.Membership;
import com.bookhive.projection.MembershipProjection;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    @Query("SELECT m FROM Membership m WHERE m.bookClub.id = :clubId")
    List<Membership> findMembersByClubId(@Param("clubId") Long clubId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Membership m WHERE m.bookClub.id = :clubId AND m.user.id = :userId")
    void deleteByBookClubIdAndUserId(@Param("clubId") Long clubId, @Param("userId") Long userId);

    @Query("""
        SELECT new com.bookhive.projection.MembershipProjection(m.membershipId)
        FROM Membership m
        WHERE m.bookClub.clubId = :clubId AND m.user.userId = :userId
    """)
    MembershipProjection findMembershipAndEntities(@Param("clubId") Long clubId, @Param("userId") Long userId);
}
