package com.mai.physical.services;

import com.mai.physical.domain.Site;
import com.mai.physical.model.SitePagedList;
import com.mai.physical.repositories.SiteRepository;
import com.mai.physical.web.mappers.SiteMapper;
import com.mai.physical.model.SiteDto;
import com.mai.sdk.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService
{
    private final SiteRepository siteRepository;
    private final SiteMapper siteMapper;
    @Override
    public SiteDto getSiteById( Long id )
    {
        return siteMapper.siteToSiteDto(
                siteRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public SitePagedList findSites( QueryParam[] params, PageRequest pageRequest)
    {
        SitePagedList sitePagedList;
        Page<Site> sitePage;

        sitePage = siteRepository.findAll(pageRequest);
        sitePagedList = new SitePagedList(sitePage
                .getContent()
                .stream()
                .map(siteMapper::siteToSiteDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(sitePage.getPageable().getPageNumber(),
                                sitePage.getPageable().getPageSize()),
                sitePage.getTotalElements());

        return sitePagedList;
    }

    @Override
    public SiteDto createSite( SiteDto siteDto )
    {
        return siteMapper.siteToSiteDto(siteRepository.save(siteMapper.siteDtoToSite(siteDto)));
    }

    @Override
    public SiteDto updateSite( Long id,  SiteDto siteDto )
    {
        Site site = siteRepository.findById(id).orElseThrow(NotFoundException::new);
        site.setName(siteDto.getName());
        site.setStatus(siteDto.getStatus());
        site.setType(siteDto.getType());

        return siteMapper.siteToSiteDto(siteRepository.save(site));
    }

    @Override
    public void deleteSite( Long id )
    {
        siteRepository.deleteById(id);
    }
}
