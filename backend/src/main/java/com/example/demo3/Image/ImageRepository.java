package com.example.demo3.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Images,Long> {

    @Query("SELECT i.url FROM Images i WHERE i.pid = :pid")
    List<String> findUrlsByPid(@Param("pid") Long pid);
}
