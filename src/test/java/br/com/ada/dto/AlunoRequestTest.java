package br.com.ada.dto;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AlunoRequestTest {

    final String NOME = "Aderson";
    final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    final Validator validator = factory.getValidator();

    @Test
    void constructorBuild(){
        AlunoRequest alunoRequest = AlunoRequest.builder()
                .nome(NOME)
                .build();

        assertEquals(alunoRequest.getNome(), NOME);
    }

    @Test
    void contraintsTest(){
        AlunoRequest alunoRequest = AlunoRequest.builder()
                .nome(NOME)
                .build();

        final Set<ConstraintViolation<AlunoRequest>> violations = validator.validate(alunoRequest);
        assertThat(violations.isEmpty());
        assertThat(alunoRequest.getNome()).isEqualTo(NOME);

    }
}