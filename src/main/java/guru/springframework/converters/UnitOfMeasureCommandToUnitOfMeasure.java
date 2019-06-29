package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand,UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasure) {
        if(unitOfMeasure == null)
        {
            return null;
        }

        final UnitOfMeasure unitofMeasure = new UnitOfMeasure();

        unitofMeasure.setId(unitOfMeasure.getId());
        unitofMeasure.setDescription(unitOfMeasure.getDescription());

        return unitofMeasure;
    }
}
