package com.mai.physical.web.mappers;

import com.mai.physical.domain.Site;
import com.mai.physical.model.SiteDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper (uses = {DateMapper.class})
@DecoratedWith(SiteMapperDecorator.class)
public interface SiteMapper
{

    SiteDto siteToSiteDto( Site site );

    Site siteDtoToSite( SiteDto dto );
}
