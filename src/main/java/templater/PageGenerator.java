package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vanik
 * Date: 28.09.13
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */
public class PageGenerator {
    private static final String HTML_DIR = "tml";
    private static final Configuration CFG = new Configuration();

    public static String getPage(String filename, Map<String, Object> data) {
        Writer stream = new StringWriter();
        try {
            Template template = CFG.getTemplate(HTML_DIR + File.separator + filename);
            template.process(data, stream);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }
}
