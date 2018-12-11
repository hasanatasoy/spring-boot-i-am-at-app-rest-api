package com.example.Hasan.domain.EditProfile;

import com.example.Hasan.domain.EditProfile.EditProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Hasan on 26.11.2018.
 */
@Repository
public interface EditProfileRepository extends JpaRepository<EditProfile,Long>{

    @Query(value = "SELECT username_img_url FROM edit_profile e Where e.username = ?1",nativeQuery = true)
    String findProfileUrlByUsername(String username);
    EditProfile findByUsername(String username);
}
