package org.loop.troop.user.exception;

import org.loop.troop.user.response.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
@SuppressWarnings("unused")
public class GlobalExceptionAdvice {

    private static final String MESSAGE = "message";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        error -> error.getDefaultMessage()!= null ? error.getDefaultMessage() : "Invalid input",
                        (existing, replacement) -> existing));

        Map<String, Object> response = Map.of(
                "status", HttpStatus.BAD_REQUEST.value(),
                "message", "Validation failed",
                "errors", errors);
        logMessage(ex.getMessage());
        return new ApiError<>(false, HttpStatus.BAD_REQUEST, errors, "Validation error, invalid field value passed");
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<Map<String, Object>> handlePropertyReferenceException(PropertyReferenceException ex,
                                                                                HttpServletRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorDetails.put("message", "Invalid sorting property: " + ex.getPropertyName());
        errorDetails.put("path", request.getRequestURI());
        errorDetails.put("timestamp", LocalDateTime.now());

        return ResponseEntity.badRequest().body(errorDetails);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError<String> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        final var errors = new HashMap<String, String>();
        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ApiError<>(false, HttpStatus.BAD_REQUEST, errors, "Validation error, invalid field value passed");
    }

    @ExceptionHandler(ServiceException.class)
    ResponseEntity<ProblemDetail> handleMovieNotProblemDetail(ServiceException ex, HttpServletRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(ex.getStatus());
        problemDetail.setTitle(ex.getTitle());
        problemDetail.setType(
                ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).path("error").build().toUri());
        problemDetail.setProperties(Map.of(MESSAGE, ex.getMessage()));
        logMessage(ex.getMessage());
        return ResponseEntity.status(ex.getStatus().value()).body(problemDetail);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ProblemDetail handleResourceNotFound(NotFoundException ex, HttpServletRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("CANNOT FIND RESOURCE");
        problemDetail.setType(
                ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).path("error").build().toUri());
        problemDetail.setProperties(Map.of(MESSAGE, ex.getMessage()));
        logMessage(ex.getMessage());
        return problemDetail;
    }

    private String extractPropertyName(PropertyReferenceException ex) {
        String message = ex.getMessage();
        int startIndex = message.indexOf("'") + 1;
        int endIndex = message.lastIndexOf("'");
        return message.substring(startIndex, endIndex);
    }

    private void logMessage(String message) {
        log.info("**************************** Exception Handled Start ****************************");
        log.error("Error message: {}", message);
        log.info("**************************** Exception Handled End ****************************");
    }
}
