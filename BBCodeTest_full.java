package org.jtalks.tests.jcommune;

import org.jtalks.tests.jcommune.webdriver.action.Topics;
import org.jtalks.tests.jcommune.webdriver.action.Users;
import org.jtalks.tests.jcommune.webdriver.entity.topic.Topic;
import org.jtalks.tests.jcommune.webdriver.exceptions.ValidationException;
import org.jtalks.tests.jcommune.webdriver.page.TopicPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.jtalks.tests.jcommune.webdriver.JCommuneSeleniumConfig.driver;
import static org.jtalks.tests.jcommune.webdriver.page.Pages.mainPage;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;

/**
 * Created by PC on 09.02.14.
 */
public class BBCodeTest {
    @BeforeMethod
    @Parameters({"appUrl"})
    public void setupCase(String appUrl) throws ValidationException {
        driver.get(appUrl);
        mainPage.logOutIfLoggedIn(driver);
    }
    //
    // Bold [b][/b] bb-code coverage
    //
    @Test
      public void boldBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[b]" + newText + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void boldBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[b]" + newText + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openBoldBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeBoldBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void boldBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[b]" + newText + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
     public void emptyBoldBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[b][/b]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthIsideBoldBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[b]" + newText + "[/b]");
        Topics.createTopic(topic);
    }

    //
    // Italic [i][/i] bb-code coverage
    //
    @Test
    public void italicBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[i]" + newText + "[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void italicBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[i]" + newText + "[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openItalicBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeItalicBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void italicBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[i]" + newText + "[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyItalicBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[i][/i]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideItalicBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[i]" + newText + "[/i]");
        Topics.createTopic(topic);
    }

    //
    // Underlined [u][/u] bb-code coverage
    //
    @Test
    public void underlinedBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[u]" + newText + "[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void underlinedBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[u]" + newText + "[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openUnderlinedBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeUnderlinedBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void underlinedBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[u]" + newText + "[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyUnderlinedBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[u][/u]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideUnderlinedBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[u]" + newText + "[/u]");
        Topics.createTopic(topic);
    }

    //
    // Striked [s][/s] bb-code coverage
    //
    @Test
    public void strikedBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[s]" + newText + "[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void strikedBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[s]" + newText + "[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openStrikedBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeStrikedBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void strikedBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[s]" + newText + "[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyStrikedBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[s][/s]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideStrikedBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[s]" + newText + "[/s]");
        Topics.createTopic(topic);
    }

    //
    // Highlight [highlight][/highlight] bb-code coverage
    //
    @Test
    public void highlightBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[highlight]" + newText + "[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void highlightBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[highlight]" + newText + "[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openHighlightBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeHighlightBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void highlightBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[highlight]" + newText + "[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyHighlightBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[highlight][/highlight]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideHighlightBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[highlight]" + newText + "[/highlight]");
        Topics.createTopic(topic);
    }

    //
    // Align Left [left][/left] bb-code coverage
    //
    @Test
    public void alignLeftBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[left]" + newText + "[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignLeftBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[left]" + newText + "[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openAlignLeftBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeAlignLeftBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignLeftBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[left]" + newText + "[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyAlignLeftBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[left][/left]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideAlignLeftBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[left]" + newText + "[/left]");
        Topics.createTopic(topic);
    }

    //
    // Align center [center][/center] bb-code coverage
    //
    @Test
    public void alignCenterBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[center]" + newText + "[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignCenterBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[center]" + newText + "[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openCenterLeftBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeAlignCenterBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignCenterBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[center]" + newText + "[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyAlignCenterBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[center][/center]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideAlignCenterBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[center]" + newText + "[/center]");
        Topics.createTopic(topic);
    }

    //
    // Align right [right][/right] bb-code coverage
    //
    @Test
    public void alignRightBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[right]" + newText + "[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignRightBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[right]" + newText + "[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openRightBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeAlignRightBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignRightBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[center]" + newText + "[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyAlignRightBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[right][/right]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideAlignRightBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[right]" + newText + "[/right]");
        Topics.createTopic(topic);
    }

    //
    // Color (blue) [color=0033CC][/color] bb-code coverage
    //
    @Test
    public void colorBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[color=0033CC]" + newText + "[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void colorBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[color=0033CC]" + newText + "[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openColorBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[color=0033CC]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeColorBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void colorBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[color=0033CC]" + newText + "[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyColorBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[color=0033CC][/color]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideColorBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[color=0033CC]" + newText + "[/color]");
        Topics.createTopic(topic);
    }

    //
    // Font size Tiny [size=7][/size] bb-code coverage
    //
    @Test
    public void fontSizeTinyBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[size=7]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeTinyBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[size=7]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeTinyBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[size=7]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontSizeTinyBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeTinyBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[size=7]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeTinyBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[size=7][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeTinyBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[size=7]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Font size Small [size=9][/size] bb-code coverage
    //
    @Test
    public void fontSizeSmallBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[size=9]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeSmallBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[size=9]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeSmallBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[size=9]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontSmallTinyBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeSmallBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[size=9]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeSmallBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[size=9][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeSmallBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[size=9]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Font size Normal [size=12][/size] bb-code coverage
    //
    @Test
    public void fontSizeNormalBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[size=12]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeNormalBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[size=12]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeNormalBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[size=12]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontNormalBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeNormalBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[size=12]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeNormalBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[size=12][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeNormalBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[size=12]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Font size Large [size=18][/size] bb-code coverage
    //
    @Test
    public void fontSizeLargeBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[size=18]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeLargeBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[size=18]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeLargeBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[size=18]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontLargeBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeLargeBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[size=18]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeLargeBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[size=18][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeLargeBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[size=18]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Font size Huge [size=24][/size] bb-code coverage
    //
    @Test
    public void fontSizeHugeBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[size=24]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeHugeBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[size=24]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeHugeBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[size=24]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontHugeBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeHugeBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[size=24]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeHugeBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[size=24][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeHugeBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[size=24]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Insert picture [img][/img] bb-code coverage
    //
    @Test
    public void insertPictureBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[img]" + newText + "[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertPictureBbCodeWithUrlToPicture_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[img]http://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Kamomillasaunio_%28Matricaria_recutita%29.JPG/160px-Kamomillasaunio_%28Matricaria_recutita%29.JPG[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertPictureBbCodeWithBrokenUrlToPicture_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[img]http://upload.wikimedia.org/wikipedia[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertPictureBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[img]" + newText + "[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openInsertPictureBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeInsertPictureBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertPictureBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[img]" + newText + "[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyInsertPictureBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[img][/img]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontInsertPictureBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[img]" + newText + "[/img]");
        Topics.createTopic(topic);

    }

    //
    // Insert link [url=newurl][/url] bb-code coverage
    //
    @Test
    public void insertUrlBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[url=newText]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeWithUrlToPicture_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[url=http://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Kamomillasaunio_%28Matricaria_recutita%29.JPG/160px-Kamomillasaunio_%28Matricaria_recutita%29.JPG]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeWithBrokenUrlToPicture_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[url=newurl]http://upload.wikimedia.org/wikipedia[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[url=newText]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openUrlPictureBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[url=newText]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeInsertUrlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[url=newText]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeTenSymbolsTextIsideTagsInsertTenSymbolsTextInsteadUrl_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[url=" + newText + "]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyInsertUrlBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[url=newText][/url]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsteadUrlInsideUrlBbCOde_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic("subject", "[url=" + newText + "]" + newText + "[/url]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsteadUrl_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic("subject", "[url=" + newText + "]newText[/url]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideUrlBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[url=newText]" + newText + "[/url]");
        Topics.createTopic(topic);

    }

    //
    // Quote [quote][/quote] bb-code coverage
    //
    @Test
    public void quoteBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[quote]" + newText + "[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void quoteBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[quote]" + newText + "[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openQuoteBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeQuoteBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void quoteBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[quote]" + newText + "[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyQuoteBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[quote][/quote]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideQuoteBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[quote]" + newText + "[/quote]");
        Topics.createTopic(topic);
    }

    //
    // Size of margin 15 [indent=15][/indent] bb-code coverage
    //
    @Test
    public void sizeOfMargin15BbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[indent=15]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin15BbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[indent=15]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSizeOfMargin15BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[indent=15]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSizeOfMargin15BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin15BbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[indent=15]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySizeOfMargin15BbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[indent=15][/indent]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSizeOfMargin15BbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[indent=15]" + newText + "[/indent]");
        Topics.createTopic(topic);
    }

    //
    // Size of margin 20 [indent=20][/indent] bb-code coverage
    //
    @Test
    public void sizeOfMargin20BbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[indent=20]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin20BbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[indent=20]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSizeOfMargin20BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[indent=20]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSizeOfMargin120BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin20BbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[indent=20]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySizeOfMargin20BbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[indent=20][/indent]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSizeOfMargin20BbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[indent=20]" + newText + "[/indent]");
        Topics.createTopic(topic);
    }

    //
    // Size of margin 25 [indent=25][/indent] bb-code coverage
    //
    @Test
    public void sizeOfMargin25BbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[indent=25]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin25BbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[indent=25]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSizeOfMargin25BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[indent=25]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSizeOfMargin125BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin25BbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[indent=25]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySizeOfMargin25BbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[indent=25][/indent]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSizeOfMargin25BbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[indent=25]" + newText + "[/indent]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight C/C++ [code=cpp][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightCBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=cpp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
     public void syntaxHighlightCBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=cpp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightCBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=cpp]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightCBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=cpp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightCBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=cpp][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightCBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=cpp]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight C# [code=csharp][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightCsharpBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=csharp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCsharpBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=csharp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCsharpBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightCsharpBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=csharp]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightCsharpBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCsharpBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=csharp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightCsharpBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=csharp][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightCsharpBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=csharp]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight java [code=java][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightJavaBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=java]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJavaBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=java]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJavaBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightJavaBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=java]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightJavaBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJavaBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=java]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightJavaBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=java][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightJavaBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=java]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight php [code=php][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightPhpBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=php]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPhpBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=php]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPhpBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightPhpBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=php]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightPhpBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPhpBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=php]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightPhpBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=php][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightPhpBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=php]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight python [code=python][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightPythonBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=python]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPythonBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=python]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPythonBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightPythonBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=python]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightPythonBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPythonBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=python]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightPythonBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=python][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightPythonBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=python]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight pascal [code=pascal][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightPascalBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=pascal]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPascalBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=pascal]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPascalBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightPascalBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=pascal]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightPascalBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPascalBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=pascal]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightPascalBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=pascal][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightPascalBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=pascal]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight bash [code=bash][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightBashBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=bash]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightBashBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=bash]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightBashBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightBashlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=bash]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightBashBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightBashBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=bash]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightBashBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=bash][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightBashBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=bash]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight js [code=js][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightJsBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=js]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJsBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=js]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJsBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightJslBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=js]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightJsBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJsBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=js]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightJsBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=js][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightJsBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=js]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight html [code=html][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightHtmlBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=html]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightHtmlBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=html]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightHtmlBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightHtmllBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=html]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightHtmlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightHtmlBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=html]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightHtmlBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=html][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightHtmlBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=html]" + newText + "[/code]");
        Topics.createTopic(topic);
    }


    //
    // Add syntax highlight css [code=css][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightCssBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=css]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCssBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=css]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCssBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightCssBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=css]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightCssBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCssBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=css]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightCssBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=css][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightCssBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=css]" + newText + "[/code]");
        Topics.createTopic(topic);
    }


    //
    // Add syntax highlight sql [code=sql][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightSqlBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=sql]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightSqlBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=sql]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightSqlBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightSqlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=sql]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightSqlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightSqlBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=sql]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightSqlBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=sql][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightSqlBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=sql]" + newText + "[/code]");
        Topics.createTopic(topic);
    }


    //
    // Add syntax highlight xml [code=xml][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightXmlBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=xml]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightXmlBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[code=xml]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightXmlBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightXmlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=xml]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightXmlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightXmlBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[code=xml]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightXmlBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=xml][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightXmlBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[code=xml]" + newText + "[/code]");
        Topics.createTopic(topic);
    }


    //
    // list [list][*][/list] bb-code coverage
    //
    @Test
    public void listBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic("subject","[list][*]" + newText + "[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void listBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(19993);
        Topic topic = new Topic("subject","[list][*]" + newText + "[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
     public void openListBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openListBbCodeTagPlusTextTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[list][*]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
     public void closeListBbCodeTagPlusTextTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[*][/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeListBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void listBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic("subject","[list]" + newText + "[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideListBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[list][*]" + newText + "[/list]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
      public void overMaxLimitTextlengthInsideListBbCodeBeforeUnorderedListTag_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[list]" + newText + "[*][/list]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideListBbCodeAfterUnorderedListTag_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic("subject", "[list][*]" + newText + "[/list]");
        Topics.createTopic(topic);
    }


}
