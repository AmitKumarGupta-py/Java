package Day10;
import java.lang.annotation.*;

    @Target({ElementType.METHOD,ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CreatedBy {
        int priority();
        String createdBy();
    }
    

