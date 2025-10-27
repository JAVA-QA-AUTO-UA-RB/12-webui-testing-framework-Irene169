package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropColumnsTest() {
        DragAndDropPage page = new DragAndDropPage(driver);

        // Open the page
        page.open();

        // Perform drag and drop
        page.performDragAndDrop();

        // Verify columns have swapped
        Assert.assertEquals(page.getTextInColumnA(), "B", "Column A should now contain B");
        Assert.assertEquals(page.getTextInColumnB(), "A", "Column B should now contain A");
    }
}