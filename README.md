# Java and Maven Review

This repository is intentionally **mostly empty**.

## Your job (students)
1. Create a **new Maven project** in IntelliJ **inside this repo folder** (repo root).
2. Use this package for your Main class:

`src/main/java/las/touro/edu/demo/Main.java`

3. In `Main`, create a **static** method:

```java
public static java.util.Optional<String> getUserName()
```

It must return an `Optional<String>` (never return `null`).

### Required behavior
- The method must read the environment variable `USER_NAME`
- If the variable exists and is not blank, return it wrapped in `Optional`
- Otherwise, return `Optional.empty()`

## Autograding
- GitHub Actions copies instructor tests from `.github/autograding_tests/` into `src/test/java/` at workflow time.
- Then it runs `mvn test`.

In the autograder, `USER_NAME` is set to a known value, and your method must return it.

## Tip
Run tests locally after you create the Maven project:

```bash
mvn test
```
