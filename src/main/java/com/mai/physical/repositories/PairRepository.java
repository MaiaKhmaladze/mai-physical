package com.mai.physical.repositories;

import com.mai.physical.domain.Pair;
import com.mai.physical.domain.PairConstants;
import com.mai.physical.services.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PairRepository extends JpaRepository<Pair, Long>
{

    Page<Pair> findAll( Pageable pageable);

   /* @EntityGraph(value = "Pair.cables", type = EntityGraph.EntityGraphType.LOAD)
    Page<Pair> findAllByCable_TargetId(Long cableId, Pageable pageable);
*/

}
