package com.mai.physical.repositories;

import com.mai.physical.domain.Cable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CableRepository extends JpaRepository<Cable, Long>
{

    Page<Cable> findAll( Pageable pageable);

    Page<Cable> findAllByName(String name, Pageable pageable);

}
