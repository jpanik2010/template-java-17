package it.jpanik.templatejava17.controllers;

import it.jpanik.templatejava17.dtos.AckDto;
import it.jpanik.templatejava17.dtos.TestDto;
import it.jpanik.templatejava17.exceptions.ServiceException;
import it.jpanik.templatejava17.services.ITestService;
import it.jpanik.templatejava17.validators.ITestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jPanik
 */
@RestController
@RequestMapping("/api/tests")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private final ITestService testService;
    private final ITestValidator testValidator;


    public TestController(
            final ITestService testService,
            final ITestValidator testValidator
    ) {
        this.testService = testService;
        this.testValidator = testValidator;
    }

    @GetMapping
    public List<TestDto> getTests() throws ServiceException {
        LOGGER.info("Called GET /tests");
        return testService.findAll();
    }

    @GetMapping("/{id}")
    public TestDto findById(@PathVariable Long id) throws ServiceException {
        LOGGER.info("Called GET /tests/{}", id);
        return testService.findById(id);
    }

    @PostMapping
    public AckDto save(@RequestBody TestDto testDto) throws ServiceException {
        LOGGER.info("Called POST /tests with body={}", testDto);
        testValidator.validate(testDto);
        return testService.save(testDto);
    }

    @DeleteMapping("/{id}")
    public AckDto deleteTest(@PathVariable Long id) throws ServiceException {
        LOGGER.info("Called DELETE /tests/{}", id);
        return testService.delete(id);
    }
}
