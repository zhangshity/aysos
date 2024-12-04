package com.zcy.date_time.duration_period_parse;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeParserUtils {

    // TEST
    public static void main(String[] args) {
        String duration1 = "1h";
        String duration2 = "1m";
        String period1 = "1d";
        String period2 = "1m";

        Duration durationObj1 = TimeParserUtils.parseDuration(duration1);
        Duration durationObj2 = TimeParserUtils.parseDuration(duration2);
        Period periodObj1 = TimeParserUtils.parsePeriod(period1);
        Period periodObj2 = TimeParserUtils.parsePeriod(period2);

        System.out.println(LocalDateTime.now().plus(durationObj1));
        System.out.println(LocalDateTime.now().plus(durationObj2));
        System.out.println(LocalDate.now().plus(periodObj1));
        System.out.println(LocalDate.now().plus(periodObj2));
    }



    /**
     * 使用 Spring 的工具类解析 Duration
     */
    public static Duration parseDuration(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string must not be null or empty");
        }
        return DurationStyle.detectAndParse(input);
    }

    /**
     * 使用 Spring 的工具类解析 Period
     */
    public static Period parsePeriod(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string must not be null or empty");
        }
        return PeriodStyle.detectAndParse(input);
    }




    /**
     * Duration format styles.
     *
     * @author Phillip Webb
     * @since 2.0.0
     */
    public enum DurationStyle {

        /**
         * Simple formatting, for example '1s'.
         */
        SIMPLE("^([+-]?\\d+)([a-zA-Z]{0,2})$") {

            @Override
            public Duration parse(String value, ChronoUnit unit) {
                try {
                    Matcher matcher = matcher(value);
                    Assert.state(matcher.matches(), "Does not match simple duration pattern");
                    String suffix = matcher.group(2);
                    return (StringUtils.hasLength(suffix) ? Unit.fromSuffix(suffix) : Unit.fromChronoUnit(unit))
                            .parse(matcher.group(1));
                }
                catch (Exception ex) {
                    throw new IllegalArgumentException("'" + value + "' is not a valid simple duration", ex);
                }
            }

            @Override
            public String print(Duration value, ChronoUnit unit) {
                return Unit.fromChronoUnit(unit).print(value);
            }

        },

        /**
         * ISO-8601 formatting.
         */
        ISO8601("^[+-]?P.*$") {

            @Override
            public Duration parse(String value, ChronoUnit unit) {
                try {
                    return Duration.parse(value);
                }
                catch (Exception ex) {
                    throw new IllegalArgumentException("'" + value + "' is not a valid ISO-8601 duration", ex);
                }
            }

            @Override
            public String print(Duration value, ChronoUnit unit) {
                return value.toString();
            }

        };

        private final Pattern pattern;

        DurationStyle(String pattern) {
            this.pattern = Pattern.compile(pattern);
        }

        protected final boolean matches(String value) {
            return this.pattern.matcher(value).matches();
        }

        protected final Matcher matcher(String value) {
            return this.pattern.matcher(value);
        }

        /**
         * Parse the given value to a duration.
         * @param value the value to parse
         * @return a duration
         */
        public Duration parse(String value) {
            return parse(value, null);
        }

        /**
         * Parse the given value to a duration.
         * @param value the value to parse
         * @param unit the duration unit to use if the value doesn't specify one ({@code null}
         * will default to ms)
         * @return a duration
         */
        public abstract Duration parse(String value, ChronoUnit unit);

        /**
         * Print the specified duration.
         * @param value the value to print
         * @return the printed result
         */
        public String print(Duration value) {
            return print(value, null);
        }

        /**
         * Print the specified duration using the given unit.
         * @param value the value to print
         * @param unit the value to use for printing
         * @return the printed result
         */
        public abstract String print(Duration value, ChronoUnit unit);

        /**
         * Detect the style then parse the value to return a duration.
         * @param value the value to parse
         * @return the parsed duration
         * @throws IllegalArgumentException if the value is not a known style or cannot be
         * parsed
         */
        public static Duration detectAndParse(String value) {
            return detectAndParse(value, null);
        }

        /**
         * Detect the style then parse the value to return a duration.
         * @param value the value to parse
         * @param unit the duration unit to use if the value doesn't specify one ({@code null}
         * will default to ms)
         * @return the parsed duration
         * @throws IllegalArgumentException if the value is not a known style or cannot be
         * parsed
         */
        public static Duration detectAndParse(String value, ChronoUnit unit) {
            return detect(value).parse(value, unit);
        }

        /**
         * Detect the style from the given source value.
         * @param value the source value
         * @return the duration style
         * @throws IllegalArgumentException if the value is not a known style
         */
        public static DurationStyle detect(String value) {
            Assert.notNull(value, "Value must not be null");
            for (DurationStyle candidate : values()) {
                if (candidate.matches(value)) {
                    return candidate;
                }
            }
            throw new IllegalArgumentException("'" + value + "' is not a valid duration");
        }

        /**
         * Units that we support.
         */
        enum Unit {

            /**
             * Nanoseconds.
             */
            NANOS(ChronoUnit.NANOS, "ns", Duration::toNanos),

            /**
             * Microseconds.
             */
            MICROS(ChronoUnit.MICROS, "us", (duration) -> duration.toMillis() * 1000L),

            /**
             * Milliseconds.
             */
            MILLIS(ChronoUnit.MILLIS, "ms", Duration::toMillis),

            /**
             * Seconds.
             */
            SECONDS(ChronoUnit.SECONDS, "s", Duration::getSeconds),

            /**
             * Minutes.
             */
            MINUTES(ChronoUnit.MINUTES, "m", Duration::toMinutes),

            /**
             * Hours.
             */
            HOURS(ChronoUnit.HOURS, "h", Duration::toHours),

            /**
             * Days.
             */
            DAYS(ChronoUnit.DAYS, "d", Duration::toDays);

            private final ChronoUnit chronoUnit;

            private final String suffix;

            private Function<Duration, Long> longValue;

            Unit(ChronoUnit chronoUnit, String suffix, Function<Duration, Long> toUnit) {
                this.chronoUnit = chronoUnit;
                this.suffix = suffix;
                this.longValue = toUnit;
            }

            public Duration parse(String value) {
                return Duration.of(Long.parseLong(value), this.chronoUnit);
            }

            public String print(Duration value) {
                return longValue(value) + this.suffix;
            }

            public long longValue(Duration value) {
                return this.longValue.apply(value);
            }

            public static Unit fromChronoUnit(ChronoUnit chronoUnit) {
                if (chronoUnit == null) {
                    return Unit.MILLIS;
                }
                for (Unit candidate : values()) {
                    if (candidate.chronoUnit == chronoUnit) {
                        return candidate;
                    }
                }
                throw new IllegalArgumentException("Unknown unit " + chronoUnit);
            }

            public static Unit fromSuffix(String suffix) {
                for (Unit candidate : values()) {
                    if (candidate.suffix.equalsIgnoreCase(suffix)) {
                        return candidate;
                    }
                }
                throw new IllegalArgumentException("Unknown unit '" + suffix + "'");
            }

        }

    }


    /**
     * A standard set of {@link Period} units.
     *
     * @author Eddú Meléndez
     * @author Edson Chávez
     * @since 2.3.0
     * @see Period
     */
    public enum PeriodStyle {

        /**
         * Simple formatting, for example '1d'.
         */
        SIMPLE("^" + "(?:([-+]?[0-9]+)Y)?" + "(?:([-+]?[0-9]+)M)?" + "(?:([-+]?[0-9]+)W)?" + "(?:([-+]?[0-9]+)D)?" + "$",
                Pattern.CASE_INSENSITIVE) {

            @Override
            public Period parse(String value, ChronoUnit unit) {
                try {
                    if (NUMERIC.matcher(value).matches()) {
                        return Unit.fromChronoUnit(unit).parse(value);
                    }
                    Matcher matcher = matcher(value);
                    Assert.state(matcher.matches(), "Does not match simple period pattern");
                    Assert.isTrue(hasAtLeastOneGroupValue(matcher), "'" + value + "' is not a valid simple period");
                    int years = parseInt(matcher, 1);
                    int months = parseInt(matcher, 2);
                    int weeks = parseInt(matcher, 3);
                    int days = parseInt(matcher, 4);
                    return Period.of(years, months, Math.addExact(Math.multiplyExact(weeks, 7), days));
                }
                catch (Exception ex) {
                    throw new IllegalArgumentException("'" + value + "' is not a valid simple period", ex);
                }
            }

            boolean hasAtLeastOneGroupValue(Matcher matcher) {
                for (int i = 0; i < matcher.groupCount(); i++) {
                    if (matcher.group(i + 1) != null) {
                        return true;
                    }
                }
                return false;
            }

            private int parseInt(Matcher matcher, int group) {
                String value = matcher.group(group);
                return (value != null) ? Integer.parseInt(value) : 0;
            }

            @Override
            protected boolean matches(String value) {
                return NUMERIC.matcher(value).matches() || matcher(value).matches();
            }

            @Override
            public String print(Period value, ChronoUnit unit) {
                if (value.isZero()) {
                    return Unit.fromChronoUnit(unit).print(value);
                }
                StringBuilder result = new StringBuilder();
                append(result, value, Unit.YEARS);
                append(result, value, Unit.MONTHS);
                append(result, value, Unit.DAYS);
                return result.toString();
            }

            private void append(StringBuilder result, Period value, Unit unit) {
                if (!unit.isZero(value)) {
                    result.append(unit.print(value));
                }
            }

        },

        /**
         * ISO-8601 formatting.
         */
        ISO8601("^[+-]?P.*$", 0) {

            @Override
            public Period parse(String value, ChronoUnit unit) {
                try {
                    return Period.parse(value);
                }
                catch (Exception ex) {
                    throw new IllegalArgumentException("'" + value + "' is not a valid ISO-8601 period", ex);
                }
            }

            @Override
            public String print(Period value, ChronoUnit unit) {
                return value.toString();
            }

        };

        private static final Pattern NUMERIC = Pattern.compile("^[-+]?[0-9]+$");

        private final Pattern pattern;

        PeriodStyle(String pattern, int flags) {
            this.pattern = Pattern.compile(pattern, flags);
        }

        protected boolean matches(String value) {
            return this.pattern.matcher(value).matches();
        }

        protected final Matcher matcher(String value) {
            return this.pattern.matcher(value);
        }

        /**
         * Parse the given value to a Period.
         * @param value the value to parse
         * @return a period
         */
        public Period parse(String value) {
            return parse(value, null);
        }

        /**
         * Parse the given value to a period.
         * @param value the value to parse
         * @param unit the period unit to use if the value doesn't specify one ({@code null}
         * will default to d)
         * @return a period
         */
        public abstract Period parse(String value, ChronoUnit unit);

        /**
         * Print the specified period.
         * @param value the value to print
         * @return the printed result
         */
        public String print(Period value) {
            return print(value, null);
        }

        /**
         * Print the specified period using the given unit.
         * @param value the value to print
         * @param unit the value to use for printing
         * @return the printed result
         */
        public abstract String print(Period value, ChronoUnit unit);

        /**
         * Detect the style then parse the value to return a period.
         * @param value the value to parse
         * @return the parsed period
         * @throws IllegalArgumentException if the value is not a known style or cannot be
         * parsed
         */
        public static Period detectAndParse(String value) {
            return detectAndParse(value, null);
        }

        /**
         * Detect the style then parse the value to return a period.
         * @param value the value to parse
         * @param unit the period unit to use if the value doesn't specify one ({@code null}
         * will default to ms)
         * @return the parsed period
         * @throws IllegalArgumentException if the value is not a known style or cannot be
         * parsed
         */
        public static Period detectAndParse(String value, ChronoUnit unit) {
            return detect(value).parse(value, unit);
        }

        /**
         * Detect the style from the given source value.
         * @param value the source value
         * @return the period style
         * @throws IllegalArgumentException if the value is not a known style
         */
        public static PeriodStyle detect(String value) {
            Assert.notNull(value, "Value must not be null");
            for (PeriodStyle candidate : values()) {
                if (candidate.matches(value)) {
                    return candidate;
                }
            }
            throw new IllegalArgumentException("'" + value + "' is not a valid period");
        }

        private enum Unit {

            /**
             * Days, represented by suffix {@code d}.
             */
            DAYS(ChronoUnit.DAYS, "d", Period::getDays, Period::ofDays),

            /**
             * Weeks, represented by suffix {@code w}.
             */
            WEEKS(ChronoUnit.WEEKS, "w", null, Period::ofWeeks),

            /**
             * Months, represented by suffix {@code m}.
             */
            MONTHS(ChronoUnit.MONTHS, "m", Period::getMonths, Period::ofMonths),

            /**
             * Years, represented by suffix {@code y}.
             */
            YEARS(ChronoUnit.YEARS, "y", Period::getYears, Period::ofYears);

            private final ChronoUnit chronoUnit;

            private final String suffix;

            private final Function<Period, Integer> intValue;

            private final Function<Integer, Period> factory;

            Unit(ChronoUnit chronoUnit, String suffix, Function<Period, Integer> intValue,
                 Function<Integer, Period> factory) {
                this.chronoUnit = chronoUnit;
                this.suffix = suffix;
                this.intValue = intValue;
                this.factory = factory;
            }

            private Period parse(String value) {
                return this.factory.apply(Integer.parseInt(value));
            }

            private String print(Period value) {
                return intValue(value) + this.suffix;
            }

            private boolean isZero(Period value) {
                return intValue(value) == 0;
            }

            private int intValue(Period value) {
                Assert.notNull(this.intValue, () -> "intValue cannot be extracted from " + this.name());
                return this.intValue.apply(value);
            }

            private static Unit fromChronoUnit(ChronoUnit chronoUnit) {
                if (chronoUnit == null) {
                    return Unit.DAYS;
                }
                for (Unit candidate : values()) {
                    if (candidate.chronoUnit == chronoUnit) {
                        return candidate;
                    }
                }
                throw new IllegalArgumentException("Unsupported unit " + chronoUnit);
            }

        }

    }
}
