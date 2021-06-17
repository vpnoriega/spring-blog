package com.codeup.springblog.daos;
import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository are a predefined parent class (also called base class). We extend this class and define the type of objects it will be manipulating, as well as the data type of the entity's id.

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByTitle(String title); // select * from ads where title = ?
    Ad findByTitleLike(String searchPattern); // select * from ads where title LIKE = ?
    Ad findFirstByTitle(String title); // select * from ads where title = ? limit 1
}