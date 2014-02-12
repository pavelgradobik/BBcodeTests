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

import java.util.Random;

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
    public class StringGenerator {
        public static void main(String[] args) {
            // add an array of symbols
            char[] letArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g','h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            int letLimit = letArray.length; //length of array
            StringBuilder randomString = new StringBuilder();
            Random random = new Random();
            //creation of a string
            for (int i=0; i<20000; i++) randomString.append(letArray[random.nextInt(letLimit)]);

        }
    }

    @Test
      public void boldBbCodeTagsTwoSymbolsString_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[b]" + "vv" + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void boldBbCodeTagsTwentyThousandSymbolsString_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[b]" + "TwentyThousand" + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openBoldBbCodeTagString_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeBoldBbCodeTagString_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
     public void emptyBoldBbCodeTagsNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[b][/b]");
        Topics.createTopic(topic);
    }

    @Test
    public void boldBbCodeTagsTenSymbolsString_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[b]" + "vv" + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void oneSymbolInsideBoldBbCodeTags_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[b][/b]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void twentyThousandAndOneSymbolsInsideBoldBbCodeTags_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[b]" + "twentyThousandAndOneSymbols" + "[/b]");
        Topics.createTopic(topic);
    }

    /*@Test
    public void usingItalicBbCodeSingleExpressionNewtopic_ShouldPass_QA_9() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[i]" + "message" + "[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }
    @Test
    public void usingUnderlinedBbCodeSingleExpressionNewtopic_ShouldPass_QA_10() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[u]" + "message" + "[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingStrikethroughBbCodeSingleExpressionNewtopic_ShouldPass_QA_11() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[s]" + "message" + "[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingHighlightBbCodeSingleExpressionNewtopic_ShouldPass_QA_12() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[highlight]" + "message" + "[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingLeftBbCodeSingleExpressionNewtopic_ShouldPass_QA_13() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[left]" + "message" + "[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingCenterBbCodeSingleExpressionNewtopic_ShouldPass_QA_14() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[center]" + "message" + "[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingRightBbCodeSingleExpressionNewtopic_ShouldPass_QA_15() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[right]" + "message" + "[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingListBbCodeSingleExpressionNewtopic_ShouldPass_QA_16() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[list]" + "[*]message" + "[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingAddListItemBbCodeSingleExpressionNewtopic_ShouldPass_QA_17() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[list]" + "[*]message" + "[*]message2" + "[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingColorBbCodeSingleExpressionNewtopic_ShouldPass_QA_18() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[color=0000CC]" + "message" + "[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingSize7BbCodeSingleExpressionNewtopic_ShouldPass_QA_19() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[size=7]message[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingImageBbCodeSingleExpressionNewtopic_ShouldPass_QA_20() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[img]http://jira.jtalks.org/secure/thumbnail/13911/_thumb_13911.png[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingUrlBbCodeSingleExpressionNewtopic_ShouldPass_QA_21() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[url=http://www.youtube.com/watch?feature=player_embedded&v=mIVRFYjIZ5A]agile[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingHightlightCBbCodeSingleExpressionNewtopic_ShouldPass_QA_22() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[code=cpp]Insert your text here[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingQuoteCBbCodeSingleExpressionNewtopic_ShouldPass_QA_23() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[quote]new super text[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingSizeMarginBbCodeSingleExpressionNewtopic_ShouldPass_QA_24() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[indent=15]Insert your text here[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void usingMultiCodeBbCodeSingleExpressionNewtopic_ShouldPass_QA_25() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject","[b][i][u][s]new text[/s][/u][/i][/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    //
    /*Negative tests Empty bb-codes without any text, Exception needed*/
    //
/*
    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyBoldBbCodeSingleExpressionNewtopic_ShouldFail_QA_26() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[b][/b]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyItalicBbCodeSingleExpressionNewtopic_ShouldFail_QA_27() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[i][/i]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyUnderlinedBbCodeSingleExpressionNewtopic_ShouldFail_QA_28() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[u][/u]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyStrikedBbCodeSingleExpressionNewtopic_ShouldFail_QA_29() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[s][/s]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyHighlightBbCodeSingleExpressionNewtopic_ShouldFail_QA_30() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[highlight][/highlight]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyLeftBbCodeSingleExpressionNewtopic_ShouldFail_QA_31() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[left][/left]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyCenterBbCodeSingleExpressionNewtopic_ShouldFail_QA_32() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[center][/center]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyRightBbCodeSingleExpressionNewtopic_ShouldFail_QA_33() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[right][/right]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyListBbCodeSingleExpressionNewtopic_ShouldFail_QA_34() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[list][*][/list]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyColorBbCodeSingleExpressionNewtopic_ShouldFail_QA_39() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[color=0000CC][/color]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyFonrSizeBbCodeSingleExpressionNewtopic_ShouldFail_QA_40() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[size=7][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyImageBbCodeSingleExpressionNewtopic_ShouldFail_QA_41() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[img][/img]");
        Topics.createTopic(topic);
    }


    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyUrlBbCodeSingleExpressionNewtopic_ShouldFail_QA_42() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[url=blabla][/url]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptySyntaxBbCodeSingleExpressionNewtopic_ShouldFail_QA_43() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[code=cpp][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyQuoteBbCodeSingleExpressionNewtopic_ShouldFail_QA_44() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[quote][/quote]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void usingEmptyMarginBbCodeSingleExpressionNewtopic_ShouldFail_QA_45() throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic("subject", "[indent=15][/indent]");
        Topics.createTopic(topic);
    }


}
