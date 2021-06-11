package com.codeup.springblog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByTitle(String title); // select * from ads where title = ?
    Ad findByTitleLike(String searchPattern); // select * from ads where title LIKE = ?
    Ad findFirstByTitle(String title); // select * from ads where title = ? limit 1
}