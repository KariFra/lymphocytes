package com.example.lymphocytes.databaseSequence;

import com.example.lymphocytes.Lymphocyte;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class LymphocyteModelListener extends AbstractMongoEventListener<Lymphocyte> {
    private final SequenceGeneratorService sequenceGeneratorService;

    public LymphocyteModelListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Lymphocyte> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService.generateSequence(Lymphocyte.SEQUENCE_NAME));
        }
    }
}
