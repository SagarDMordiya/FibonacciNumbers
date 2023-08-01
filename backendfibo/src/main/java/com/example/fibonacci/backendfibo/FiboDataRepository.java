package com.example.fibonacci.backendfibo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiboDataRepository extends JpaRepository<FiboDataModel,Long> {
    
}
