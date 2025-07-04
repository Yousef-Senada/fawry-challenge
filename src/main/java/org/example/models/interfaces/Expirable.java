package org.example.models.interfaces;
import java.time.LocalDate;

public interface Expirable {
    LocalDate getExpirayDate();

    default boolean isExpired() {
        return getExpirayDate().isBefore(LocalDate.now());
    }   
}
