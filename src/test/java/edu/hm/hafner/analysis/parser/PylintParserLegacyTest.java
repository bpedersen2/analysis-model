package edu.hm.hafner.analysis.parser;

import java.util.Iterator;

import edu.hm.hafner.analysis.AbstractParserTest;
import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.Severity;
import edu.hm.hafner.analysis.Report;
import static edu.hm.hafner.analysis.assertj.IssuesAssert.*;
import edu.hm.hafner.analysis.assertj.SoftAssertions;

/**
 * Tests the class {@link PyLintParser}.
 */
class PylintParserLegacyTest extends AbstractParserTest {
    private static final String ISSUES_FILE = "pyLint.txt";

    private static final String LEGACY_PYLINT_PATTERN = "(?<path>.*):(?<line>\\d+): \\[(?<category>\\D\\d*).*\\] (?<message>.*)";

    /**
     * Creates a new instance of {@link PylintParserTest}.
     */
    PylintParserLegacyTest() {
        super(ISSUES_FILE);
    }

    @Override
    protected void assertThatIssuesArePresent(final Report report, final SoftAssertions softly) {
        assertThat(report).hasSize(6);

        Iterator<Issue> iterator = report.iterator();

        softly.assertThat(iterator.next())
                .hasLineStart(3)
                .hasLineEnd(3)
                .hasMessage("Line too long (85/80)")
                .hasFileName("trunk/src/python/cachedhttp.py")
                .hasCategory("C")
                .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                .hasLineStart(28)
                .hasLineEnd(28)
                .hasMessage("Invalid name \"seasonCount\" (should match [a-z_][a-z0-9_]{2,30}$)")
                .hasFileName("trunk/src/python/tv.py")
                .hasCategory("C0103")
                .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                .hasLineStart(35)
                .hasLineEnd(35)
                .hasMessage("Missing docstring")
                .hasFileName("trunk/src/python/tv.py")
                .hasCategory("C0111")
                .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                .hasLineStart(39)
                .hasLineEnd(39)
                .hasMessage("Method should have \"self\" as first argument")
                .hasFileName("trunk/src/python/tv.py")
                .hasCategory("E0213")
                .hasSeverity(Severity.WARNING_HIGH);

        softly.assertThat(iterator.next())
                .hasLineStart(5)
                .hasLineEnd(5)
                .hasMessage("Unable to import 'deadbeef'")
                .hasFileName("trunk/src/python/tv.py")
                .hasCategory("F0401")
                .hasSeverity(Severity.WARNING_HIGH);

        softly.assertThat(iterator.next())
                .hasLineStart(39)
                .hasLineEnd(39)
                .hasMessage("Dangerous default value \"[]\" as argument")
                .hasFileName("trunk/src/python/tv.py")
                .hasCategory("W0102")
                .hasSeverity(Severity.WARNING_NORMAL);
    }

    @Override
    protected PyLintParser createParser() {
        return new PyLintParser(LEGACY_PYLINT_PATTERN);
    }
}
