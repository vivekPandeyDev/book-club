package com.bookhive.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex,
                        Locale locale) {
                Map<String, String> errors = ex.getBindingResult().getFieldErrors()
                                .stream()
                                .collect(Collectors.toMap(
                                                FieldError::getField,
                                                error -> error.getDefaultMessage(),
                                                (existing, replacement) -> existing));

                Map<String, Object> response = Map.of(
                                "status", HttpStatus.BAD_REQUEST.value(),
                                "message", "Validation failed",
                                "errors", errors);

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex,
                        WebRequest request) {
                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("timestamp", LocalDateTime.now());
                errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
                errorDetails.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
                errorDetails.put("message", ex.getMessage());
                errorDetails.put("path", request.getDescription(false).replace("uri=", ""));

                return ResponseEntity.badRequest().body(errorDetails);
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

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException ex,
                        HttpServletRequest request) {
                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("status", HttpStatus.NOT_FOUND.value());
                errorDetails.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
                errorDetails.put("message", ex.getMessage());
                errorDetails.put("path", request.getRequestURI());
                errorDetails.put("timestamp", LocalDateTime.now());

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
        }

        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<Map<String, Object>> handleNoResourceFoundException(
                        NoResourceFoundException ex,
                        HttpServletRequest request) {

                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("status", HttpStatus.NOT_FOUND.value());
                errorDetails.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
                errorDetails.put("message", ex.getMessage());
                errorDetails.put("path", request.getRequestURI());
                errorDetails.put("timestamp", LocalDateTime.now());

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
        }

        @ExceptionHandler(RateLimitExceededException.class)
        public ResponseEntity<Map<String, Object>> handleRateLimitExceededException(RateLimitExceededException ex,
                        HttpServletRequest request) {
                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("timestamp", LocalDateTime.now());
                errorDetails.put("status", HttpStatus.TOO_MANY_REQUESTS.value());
                errorDetails.put("error", HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase());
                errorDetails.put("message", ex.getMessage());
                errorDetails.put("path", request.getRequestURI());

                return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(errorDetails);
        }

        @ExceptionHandler(ResourceFoundException.class)
        public ResponseEntity<Map<String, Object>> handleResourceFoundException(ResourceFoundException ex,
                        HttpServletRequest request) {
                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("timestamp", LocalDateTime.now());
                errorDetails.put("status", HttpStatus.FOUND.value());
                errorDetails.put("error", HttpStatus.FOUND.getReasonPhrase());
                errorDetails.put("message", ex.getMessage());
                errorDetails.put("path", request.getRequestURI());

                return ResponseEntity.status(HttpStatus.FOUND).body(errorDetails);
        }
}
