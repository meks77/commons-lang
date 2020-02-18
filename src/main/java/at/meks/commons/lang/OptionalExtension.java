package at.meks.commons.lang;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExtension<T> {

    private T optional;

    public OptionalExtension(T optional) {
        this.optional = optional;
    }

    public static <Y> OptionalExtension<Y> of(Y optional) {
        return new OptionalExtension<>(optional);
    }

    public OptionalExtension<T> ifEmpty(Supplier<T> optionalSupplier) {
        if (optional == null) {
            optional = optionalSupplier.get();
        }
        return this;
    }

    public Optional<T> orElseGetEmpty() {
        return Optional.ofNullable(optional);
    }
}
