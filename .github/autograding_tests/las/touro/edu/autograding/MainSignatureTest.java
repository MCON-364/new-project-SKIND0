package las.touro.edu.autograding;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MainSignatureTest {

    /**
     * Required:
     * - Class: las.touro.edu.demo.Main
     * - Method: public static Optional<String> getUserName()
     *
     * Behavior (in autograder):
     * - The environment variable USER_NAME is set (e.g., "Alice")
     * - getUserName() must return Optional.of(the env value)
     */
    @Test
    void main_has_static_getUserName_returning_optional() throws Exception {
        Class<?> clazz = Class.forName("las.touro.edu.demo.Main");

        Method m = clazz.getDeclaredMethod("getUserName");

        assertTrue(Modifier.isPublic(m.getModifiers()), "getUserName must be public");
        assertTrue(Modifier.isStatic(m.getModifiers()), "getUserName must be static");
        assertEquals(Optional.class, m.getReturnType(), "getUserName must return java.util.Optional");

        Object result = m.invoke(null);
        assertNotNull(result, "getUserName must not return null");
        assertTrue(result instanceof Optional, "getUserName must return Optional");
    }

    @Test
    void getUserName_returns_student_name_env_var_when_present() throws Exception {
        String expected = System.getenv("USER_NAME");
        assertNotNull(expected, "Autograder misconfigured: USER_NAME env var must be set");
        assertFalse(expected.isBlank(), "Autograder misconfigured: USER_NAME must be non-blank");

        Class<?> clazz = Class.forName("las.touro.edu.demo.Main");
        Method m = clazz.getDeclaredMethod("getUserName");

        @SuppressWarnings("unchecked")
        Optional<String> result = (Optional<String>) m.invoke(null);

        assertNotNull(result, "getUserName must not return null");
        assertTrue(result.isPresent(), "Expected Optional.of(USER_NAME) when USER_NAME is set");
        assertEquals(expected, result.get(), "getUserName must return the exact value of USER_NAME");
    }
}
