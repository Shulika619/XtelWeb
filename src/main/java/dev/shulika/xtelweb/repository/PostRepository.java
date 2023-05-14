package dev.shulika.xtelweb.repository;

import dev.shulika.xtelweb.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select p from Post p join fetch p.fromEmployee join fetch p.toDepartment",
            countQuery = "SELECT count(p) from Post p")
    Page<Post> findAllPosts(Pageable pageable);

    @Query(value = "select p from Post p join fetch p.fromEmployee join fetch p.toDepartment where p.toDepartment.id = :departmentId",
            countQuery = "SELECT count(p) from Post p")
    Page<Post> findByDepartmentId(Pageable pageable, Long departmentId);

    @Query(value = "select p from Post p join fetch p.fromEmployee join fetch p.toDepartment " +
                   "where lower(p.textMsg) LIKE lower(concat('%', :searchTxt,'%'))",
            countQuery = "SELECT count(p) from Post p")
    Page<Post> findBySearchText(Pageable pageable, String searchTxt);

}
