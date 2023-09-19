package com.example.product.repository;

import com.example.product.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.product.id = :id order by r.createdAt desc")
    List<Review> findByProductId(Long id);

}
