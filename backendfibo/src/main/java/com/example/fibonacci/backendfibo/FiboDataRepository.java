package com.example.fibonacci.backendfibo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiboDataRepository extends JpaRepository<FiboDataModel,Long> {
    
    long count();

    List<FiboDataModel> findByFiboIndexLessThanEqualOrderByFiboIndex(Integer n);
}
