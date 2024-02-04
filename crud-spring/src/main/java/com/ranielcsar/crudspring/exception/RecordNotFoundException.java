package com.ranielcsar.crudspring.exception;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id) {
        super("Registro com o id " + id + " não encontrado");
    }
}
