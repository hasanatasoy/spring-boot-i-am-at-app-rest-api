package com.example.Hasan.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hasan on 21.11.2018.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query(value = "SELECT * FROM Post p WHERE ((p.location_latitude BETWEEN ?1-0.5 AND ?1+0.5) AND (p.location_longtitude" +
            " BETWEEN ?2-0.5 AND ?2+0.5)) ORDER BY p.created_at DESC fetch first 5 rows only",nativeQuery = true)
    List<Post> findPostByLocation(double locationLatitude, double locationLongtitude);
    List<Post> findAllByUsernameOrderByCreatedAtDesc(String username);
}
