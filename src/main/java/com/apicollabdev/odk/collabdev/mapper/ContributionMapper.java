package com.apicollabdev.odk.collabdev.mapper;

import com.apicollabdev.odk.collabdev.dto.ContributionDTO;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.Contribution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContributionMapper {

    @Mapping(source = "contributeur.id", target = "contributeurId")
    ContributionDTO toDto(Contribution contribution);

    @Mapping(target = "contributeur", expression = "java(contributeurFromId(dto.getContributeurId()))")
    Contribution toEntity(ContributionDTO dto);

    default Contributeur contributeurFromId(Long id) {
        if (id == null) return null;
        Contributeur c = new Contributeur();
        c.setId(id);
        return c;
    }
}
