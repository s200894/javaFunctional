package chapter3.exercises.e3_1;

public interface Result<T> {

    static Failure failure(String message) {
        return new Failure<String>(message);
    }

    static <T> Success success(T value) {
        return new Success<>(value);
    }

    void bind(Effect<T> success, Effect<String> failure);

    class Success<T> implements Result<T> {

        private final T value;

        private Success(T t) {
            value = t;
        }

        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            success.apply(value);
        }
    }

    class Failure<T> implements Result<T> {

        private final String errorMessage;

        private Failure(String s) {
            this.errorMessage = s;
        }

        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            failure.apply(errorMessage);
        }
    }
}
