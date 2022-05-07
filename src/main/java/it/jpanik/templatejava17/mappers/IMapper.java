package it.jpanik.templatejava17.mappers;

import it.jpanik.templatejava17.exceptions.ServiceException;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jPanik
 * @param <D> : DTO
 * @param <E> : ENTITY
 */
public interface IMapper<D, E> {

    default D convertEntityToDto(E entity) throws ServiceException {
        getLogger().debug("Start convertEntityToDto");

        if (entity == null) {
            getLogger().debug("Null ENTITY, returned null DTO");
            return null;
        }

        D dto = convertEntityToDtoImpl(entity);

        getLogger().debug("End convertEntityToDto with result={}", dto);

        return dto;
    }

    default E convertDtoToEntity(D dto) throws ServiceException {
        getLogger().debug("Start convertDtoToEntity with dto={}", dto);

        if (dto == null) {
            getLogger().warn("Null DTO, returned null ENTITY");
            return null;
        }

        E entity = convertDtoToEntityImpl(dto);

        getLogger().debug("End convertDtoToEntity");

        return entity;
    }

    default List<D> convertEntitySetToDtoList(Set<E> entities) throws ServiceException {
        getLogger().debug("Start convertEntitySetToDtoList");

        if (entities == null) {
            getLogger().debug("Null ENTITY SET, returned empty DTO LIST");
            return new ArrayList<>();
        }

        List<D> result = new ArrayList<>();
        for (E value: entities) {
            result.add(convertEntityToDto(value));
        }

        getLogger().debug("End convertEntitySetToDtoList with result={}", result);

        return result;
    }

    default List<D> convertEntityListToDtoList(List<E> entities) throws ServiceException {
        getLogger().debug("Start convertEntityListToDtoList");

        if (entities == null) {
            getLogger().debug("Null ENTITY LIST, returned empty DTO LIST");
            return new ArrayList<>();
        }

        List<D> result = new ArrayList<>();
        for (E value: entities) {
            result.add(convertEntityToDto(value));
        }

        getLogger().debug("End convertEntityListToDtoList with result={}", result);

        return result;
    }

    default Set<E> convertDtoListToEntitySet(List<D> dto) throws ServiceException {
        getLogger().debug("Start convertDtoListToEntitySet");

        if (dto == null) {
            getLogger().debug("Null DTO LIST, returned empty ENTITY SET");
            return new HashSet<>();
        }

        Set<E> result = new HashSet<>();
        for (D value: dto) {
            result.add(convertDtoToEntity(value));
        }

        getLogger().debug("End convertDtoListToEntityList");

        return result;
    }

    default List<E> convertDtoListToEntityList(List<D> dto) throws ServiceException {
        getLogger().debug("Start convertDtoListToEntityList");

        if (dto == null) {
            getLogger().debug("Null DTO LIST, returned empty ENTITY LIST");
            return  new ArrayList<>();
        }

        List<E> result = new ArrayList<>();
        for (D value: dto) {
            result.add(convertDtoToEntity(value));
        }

        getLogger().debug("End convertDtoListToEntityList");

        return result;
    }

    default ServiceException throwNotFound(String message) {
        getLogger().error(message);
        return new ServiceException(message);
    }

    D convertEntityToDtoImpl(E entity) throws ServiceException;

    E convertDtoToEntityImpl(D dto) throws ServiceException;

    Logger getLogger();
}
