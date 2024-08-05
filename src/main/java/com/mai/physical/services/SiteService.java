package com.mai.physical.services;

import com.mai.physical.model.SiteDto;
import com.mai.physical.model.SitePagedList;
import com.mai.sdk.QueryParam;
import org.springframework.data.domain.PageRequest;

public interface SiteService
{
    SiteDto getSiteById(Long id);
    SitePagedList findSites( QueryParam[] params, PageRequest pageRequest);

    SiteDto createSite(SiteDto siteDto);

    SiteDto updateSite(Long id, SiteDto siteDto);

    void deleteSite(Long id);
}
