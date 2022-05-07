package it.jpanik.templatejava17.services.impl;

import it.jpanik.templatejava17.dtos.AckDto;
import it.jpanik.templatejava17.dtos.TestDto;
import it.jpanik.templatejava17.entities.Test;
import it.jpanik.templatejava17.exceptions.ServiceException;
import it.jpanik.templatejava17.mappers.impl.TestMapper;
import it.jpanik.templatejava17.repositories.TestRepository;
import it.jpanik.templatejava17.services.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jPanik
 */
@Service
public class TestService implements ITestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    private final TestRepository testRepository;
    private final TestMapper testMapper;


    public TestService(
            final TestRepository testRepository,
            final TestMapper testMapper
    ) {
        this.testRepository = testRepository;
        this.testMapper = testMapper;
    }

    @Override
    public List<TestDto> findAll() throws ServiceException {
        List<Test> result = new ArrayList<>();
        testRepository.findAll().forEach(result::add);
        return testMapper.convertEntityListToDtoList(result);
    }

    @Override
    public TestDto findById(Long id) throws ServiceException {
        Test test = testRepository.findById(id).orElseThrow(() ->
                throwNotFound(String.format("Test not found with id=%s", id)));
        return testMapper.convertEntityToDto(test);
    }

    @Override
    public AckDto save(TestDto testDto) throws ServiceException {
        Test test = testMapper.convertDtoToEntity(testDto);
        testRepository.save(test);
        return ackOK();
    }

    @Override
    public AckDto delete(Long id) throws ServiceException {
        Test test = testRepository.findById(id).orElseThrow(() ->
                throwNotFound(String.format("Test not found with id=%s", id)));
        testRepository.delete(test);
        return ackOK();
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
