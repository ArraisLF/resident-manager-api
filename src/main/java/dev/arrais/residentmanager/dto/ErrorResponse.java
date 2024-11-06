package dev.arrais.residentmanager.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
  private String timestamp;
  private int status;
  private String error;
  private String message;
  private Map<String, String> fieldErrors;

  public ErrorResponse(LocalDateTime timestamp, HttpStatus status, String message) {
    this.timestamp = timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    this.status = status.value();
    this.error = status.getReasonPhrase();
    this.message = message;
    this.fieldErrors = new HashMap<>();
  }

  public ErrorResponse(
      LocalDateTime timestamp, HttpStatus status, String message, Map<String, String> fieldErrors) {
    this.timestamp = timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    this.status = status.value();
    this.error = status.getReasonPhrase();
    this.message = message;
    this.fieldErrors = fieldErrors;
  }
}
