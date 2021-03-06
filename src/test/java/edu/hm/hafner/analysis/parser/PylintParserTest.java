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
class PylintParserTest extends AbstractParserTest {
    private static final String ISSUES_FILE = "pylint_parseable.txt";

    /**
     * Creates a new instance of {@link PylintParserTest}.
     */
    PylintParserTest() {
        super(ISSUES_FILE);
    }

    @Override
    protected void assertThatIssuesArePresent(final Report report, final SoftAssertions softly) {
        assertThat(report).hasSize(19);

        Iterator<Issue> iterator = report.iterator();
        softly.assertThat(iterator.next())
                        .hasLineStart(1)
                        .hasLineEnd(1)
                        .hasMessage("No module named src/test/resources/non_existant.py")
                        .hasFileName("src/test/resources/non_existant.py")
                        .hasCategory("fatal")
                        .hasSeverity(Severity.WARNING_HIGH);

        softly.assertThat(iterator.next())
                        .hasLineStart(16)
                        .hasLineEnd(16)
                        .hasMessage("Exactly one space required around assignment")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("bad-whitespace")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(24)
                        .hasLineEnd(24)
                        .hasMessage("Unnecessary parens after 'print' keyword")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("superfluous-parens")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(1)
                        .hasLineEnd(1)
                        .hasMessage("Missing module docstring")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("missing-docstring")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(5)
                        .hasLineEnd(5)
                        .hasMessage("Constant name \"shift\" doesn't conform to UPPER_CASE naming style")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("invalid-name")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(6)
                        .hasLineEnd(6)
                        .hasMessage("Constant name \"choice\" doesn't conform to UPPER_CASE naming style")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("invalid-name")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(7)
                        .hasLineEnd(7)
                        .hasMessage("Constant name \"word\" doesn't conform to UPPER_CASE naming style")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("invalid-name")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(8)
                        .hasLineEnd(8)
                        .hasMessage("Constant name \"letters\" doesn't conform to UPPER_CASE naming style")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("invalid-name")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(9)
                        .hasLineEnd(9)
                        .hasMessage("Constant name \"encoded\" doesn't conform to UPPER_CASE naming style")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("invalid-name")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(26)
                        .hasLineEnd(26)
                        .hasMessage("Class name \"test\" doesn't conform to PascalCase naming style")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("invalid-name")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(26)
                        .hasLineEnd(26)
                        .hasMessage("Missing class docstring")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("missing-docstring")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(27)
                        .hasLineEnd(27)
                        .hasMessage("Missing method docstring")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("missing-docstring")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(27)
                        .hasLineEnd(27)
                        .hasMessage("Method should have \"self\" as first argument")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("no-self-argument")
                        .hasSeverity(Severity.WARNING_HIGH);

        softly.assertThat(iterator.next())
                        .hasLineStart(30)
                        .hasLineEnd(30)
                        .hasMessage("Dangerous default value [] as argument")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("dangerous-default-value")
                        .hasSeverity(Severity.WARNING_NORMAL);

        softly.assertThat(iterator.next())
                        .hasLineStart(30)
                        .hasLineEnd(30)
                        .hasMessage("Missing method docstring")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("missing-docstring")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(30)
                        .hasLineEnd(30)
                        .hasMessage("Method could be a function")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("no-self-use")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(33)
                        .hasLineEnd(33)
                        .hasMessage("Unable to import 'deadbeef'")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("import-error")
                        .hasSeverity(Severity.WARNING_HIGH);

        softly.assertThat(iterator.next())
                        .hasLineStart(33)
                        .hasLineEnd(33)
                        .hasMessage("Import \"import deadbeef\" should be placed at the top of the module")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("wrong-import-position")
                        .hasSeverity(Severity.WARNING_LOW);

        softly.assertThat(iterator.next())
                        .hasLineStart(33)
                        .hasLineEnd(33)
                        .hasMessage("Unused import deadbeef")
                        .hasFileName("src/test/resources/python_src/pypackage/pymodule.py")
                        .hasCategory("unused-import")
                        .hasSeverity(Severity.WARNING_NORMAL);

    }

    @Override
    protected PyLintParser createParser() {
        return new PyLintParser();
    }
}
