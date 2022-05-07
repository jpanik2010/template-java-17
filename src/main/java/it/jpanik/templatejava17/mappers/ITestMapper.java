package it.jpanik.templatejava17.mappers;

import it.jpanik.templatejava17.dtos.TestDto;
import it.jpanik.templatejava17.entities.Test;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author jPanik
 */
@Mapper
public interface ITestMapper {
    ITestMapper INSTANCE = Mappers.getMapper(ITestMapper.class);

    TestDto convertEntityToDto(Test entity);

    Test convertDtoToEntity(TestDto dto);

    @InheritConfiguration(name = "convertDtoToEntity")
    void mergeDtoToEntity(@MappingTarget Test entity, TestDto dto);
}
