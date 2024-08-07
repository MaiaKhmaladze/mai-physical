package com.mai.physical.repositories;

import com.mai.physical.domain.Pair;
import com.mai.physical.domain.PairConstants;
import com.mai.physical.services.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PairRepository extends JpaRepository<Pair, Long>
{

    Page<Pair> findAll( Pageable pageable);

    @Query(value = "SELECT p FROM Pair p JOIN p.cables c where p.cables = :cableId ")
    Page<Pair> findAllByCableId(Long cableId, Pageable pageable);

}
