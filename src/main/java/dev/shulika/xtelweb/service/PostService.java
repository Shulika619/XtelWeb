package dev.shulika.xtelweb.service;

import dev.shulika.xtelweb.model.Post;
import dev.shulika.xtelweb.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public Page<Post> findAll(Pageable pageable){
        log.info("+++++ IN PostService :: findAll :: START +++++");
        var posts = postRepository.findAllWithoutNPlusOne(pageable);
        log.info("+++++ IN PostService :: findAll :: FINISHED SUCCESSFULLY +++++");
        return posts;
    }

    public Page<Post> findByDepartment(Pageable pageable, Long departmentId){
        log.info("+++++ IN PostService :: findByDepartment :: START +++++");
        var posts = postRepository.findByDepartmentWithoutNPlusOne(pageable, departmentId);
        log.info("+++++ IN PostService :: findByDepartment :: FINISHED SUCCESSFULLY +++++");
        return posts;
    }
}
