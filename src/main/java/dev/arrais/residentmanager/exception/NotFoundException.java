package dev.arrais.residentmanager.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String type, String id) {
        super(String.format("%s id: %s not found", type, id));
    }

}
