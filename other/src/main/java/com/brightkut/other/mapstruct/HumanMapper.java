package com.brightkut.other.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HumanMapper {

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "age", source = "dto.age")
    @Mapping(target = "gender", source = "gender")
    Human humanDtoToHuman(HumanDto dto, String gender);
}
