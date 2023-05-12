package dev.shulika.xtelweb.repository;

import dev.shulika.xtelweb.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(
            value = "select p from Post p join fetch p.fromEmployee join fetch p.toDepartment join fetch p.taskExecutor",
            countQuery = "SELECT count(p) from Post p")
    Page<Post> findAllWithoutNPlusOne(Pageable pageable);

}
