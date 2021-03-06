package edu.hm.hafner.analysis.parser.violations;

import se.bjurr.violations.lib.parsers.DocFXParser;

/**
 * Parses DocFX files.
 *
 * @author Ullrich Hafner
 */
public class DocFxAdapter extends AbstractViolationAdapter {
    private static final long serialVersionUID = 2162266195669804761L;

    @Override
    protected DocFXParser createParser() {
        return new DocFXParser();
    }
}
