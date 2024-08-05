package com.mai.physical.repositories;

import com.mai.physical.domain.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Long>
{

    Page<Site> findAll( Pageable pageable);

    Page<Site> findAllByName(String name, Pageable pageable);

}
