package fitnesse.wikitext.parser;

import fitnesse.wiki.WikiPage;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WikiSourcePageTest {

    @Test
    public void getsChildren() {
        TestRoot root = new TestRoot();
        WikiPage page = root.makePage("PageOne");
        root.makePage(page, "PageTwo");
        root.makePage(page, "PageThree");
        WikiSourcePage source = new WikiSourcePage(page);
        ArrayList<String> names = new ArrayList<String>();
        for (SourcePage child: source.getChildren()) names.add(child.getName());

        assertEquals(2, names.size());
        assertTrue(names.contains("PageTwo"));
        assertTrue(names.contains("PageThree"));
    }

    @Test
    public void getsUrlForPage() {
        WikiPage test = new TestRoot().makePage("MyPage");
        assertEquals("WikiPath", new WikiSourcePage(test).makeUrl("WikiPath"));
    }
}
