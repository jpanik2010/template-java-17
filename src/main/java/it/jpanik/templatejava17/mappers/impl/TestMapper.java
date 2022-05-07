package it.jpanik.templatejava17.mappers.impl;

import it.jpanik.templatejava17.dtos.TestDto;
import it.jpanik.templatejava17.entities.Test;
import it.jpanik.templatejava17.exceptions.ServiceException;
import it.jpanik.templatejava17.mappers.ITestMapper;
import it.jpanik.templatejava17.mappers.IMapper;
import it.jpanik.templatejava17.repositories.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author jPanik
 */
@Service
public class TestMapper implements IMapper<TestDto, Test> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestMapper.class);

    private final TestRepository testRepository;

    public TestMapper(
            final TestRepository testRepository
    ) {
        this.testRepository = testRepository;
    }

    @Override
    public TestDto convertEntityToDtoImpl(Test entity) {
        return ITestMapper.INSTANCE.convertEntityToDto(entity);
    }

    @Override
    public Test convertDtoToEntityImpl(TestDto dto) throws ServiceException {
        Test entity;
        if (dto.getId() != null) {
            entity = testRepository.findById(dto.getId()).orElseThrow(() ->
                    throwNotFound(String.format("Test non trovato con id=%s", dto.getId())));
            ITestMapper.INSTANCE.mergeDtoToEntity(entity, dto);
        } else {
            entity = ITestMapper.INSTANCE.convertDtoToEntity(dto);
        }
        return entity;
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
