package com.mai.physical.repositories;

import com.mai.physical.domain.PairBinding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PairBindingRepository extends JpaRepository<PairBinding, Long>
{

    Page<PairBinding> findAll( Pageable pageable);

}
