package it.jpanik.templatejava17.services;

import it.jpanik.templatejava17.dtos.AckDto;
import it.jpanik.templatejava17.exceptions.ServiceException;
import org.slf4j.Logger;

/**
 * @author jPanik
 */
public interface IService {

    Logger getLogger();

    default AckDto ackOK() {
        return buildAck(true);
    }

    default AckDto ackOK(String message) {
        return buildAck(true);
    }

    default AckDto ackKO(String message) {
        return buildAck(false);
    }

    default ServiceException throwNotFound(String message) {
        getLogger().error(message);
        return new ServiceException(message);
    }

    private AckDto buildAck(boolean result) {
        AckDto ackDto = new AckDto();
        ackDto.setResult(result);
        return ackDto;
    }

}
