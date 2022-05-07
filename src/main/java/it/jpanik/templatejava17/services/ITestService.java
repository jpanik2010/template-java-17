package it.jpanik.templatejava17.services;

import it.jpanik.templatejava17.dtos.AckDto;
import it.jpanik.templatejava17.dtos.TestDto;
import it.jpanik.templatejava17.exceptions.ServiceException;

import java.util.List;

/**
 * @author jPanik
 */
public interface ITestService extends IService {

    List<TestDto> findAll() throws ServiceException;

    TestDto findById(Long id) throws ServiceException;

    AckDto save(TestDto testDto) throws ServiceException;

    AckDto delete(Long id) throws ServiceException;
}
