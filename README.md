# Unit Testing a Third-Party Library — TestNG · Data-Driven · Parallel

![Java](https://img.shields.io/badge/Java-11-orange) ![TestNG](https://img.shields.io/badge/TestNG-90%20tests-red)

Black-box testing of a calculator library shipped only as a compiled `.jar` (no source code). The goal was to check its real behaviour against the expected math, the way you would test a vendor dependency.

## What's inside

- **90 tests** across 16 classes: sum, sub, mult and div (long and double), pow, sqrt, sin, cos, tg, ctg, isPositive and isNegative.
- **Data-driven** with `@DataProvider(parallel = true)`, covering positive, negative, zero, boundaries and floating-point precision with a delta.
- **Parallel execution** (`parallel="methods"`, 4 threads). Setup uses `@BeforeClass` and `@AfterClass`, which keeps it thread-safe.
- TestNG **groups**: arithmetic, advanced (pow/sqrt), trigonometry and boolean checks.
- **Edge cases** such as division by zero (`double` → `Infinity`, `long` → exception) and `NaN` handling.

## Defects found

Testing without the source code surfaced behaviours that differ from standard math. These are documented in the tests:

| Method | Expected | Actual library behaviour |
|---|---|---|
| `cos(x)` | cosine | **Returns sin(x)**: `cos(0) = 0`, `cos(π/2) = 1` |
| `tg(0)` | `0` | Returns **`NaN`** |
| `div(long, 0)` | `ArithmeticException` | Throws **`NumberFormatException`** |

The tests pin down the library's *real* behaviour and flag where it diverges from the spec. That is the job of testing a dependency you don't control.

## Run

```bash
mvn clean test
```

## Stack

Java 11 · TestNG · Maven

---
Part of my QA automation portfolio → [selenium-framework-patterns](https://github.com/gomezLucila25/selenium-framework-patterns) · [ApiAutomation](https://github.com/gomezLucila25/ApiAutomation)
