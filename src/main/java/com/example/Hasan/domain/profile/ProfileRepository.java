package com.example.Hasan.domain.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hasan on 26.11.2018.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long>{

    Profile findByUsername(String username);
}
