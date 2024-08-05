package com.mai.physical.web.mappers;

import com.mai.physical.domain.Site;
import com.mai.physical.model.SiteDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class SiteMapperDecorator implements SiteMapper {

    private SiteMapper mapper;

    @Autowired
    public void setMapper(SiteMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public SiteDto siteToSiteDto( Site site) {
        SiteDto dto = mapper.siteToSiteDto(site);
        dto.setId(site.getObjectId());
        return dto;
    }

    @Override
    public Site siteDtoToSite( SiteDto siteDto) {
        return mapper.siteDtoToSite(siteDto);
    }
}
