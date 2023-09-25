package com.example.product.repository;

import com.example.product.domain.entity.OptionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OptionDetailRepository extends JpaRepository<OptionDetail, Long> {

    @Query("select od from OptionDetail od where od.option.id in :optionIds")
    List<OptionDetail> findByOptionIds(List<Long> optionIds);

}
