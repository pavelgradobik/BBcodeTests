package org.jtalks.tests.jcommune;

import org.apache.commons.lang.RandomStringUtils;
import org.jtalks.tests.jcommune.webdriver.action.Topics;
import org.jtalks.tests.jcommune.webdriver.action.Users;
import org.jtalks.tests.jcommune.webdriver.entity.topic.Topic;
import org.jtalks.tests.jcommune.webdriver.exceptions.ValidationException;
import org.jtalks.tests.jcommune.webdriver.page.TopicPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "bbCodesWithMessagethatShouldPass")
        public void  bbCodesWithTextThatShouldPass(String testString, String messageIfTEstFails) throws Exception {
            Users.signUpAndSignIn();
            Topic topic = new Topic(randomAlphanumeric(10), testString);
            Topic createdTopic = Topic.createTopic(topic);
            Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(dataProvider = "bbCodesWithMessagethatShouldFail")
    public void  bbCodesWithTextThatShouldFail(String testString, String messageIfTEstFails) throws Exception {
        Users.signUpAndSignIn();
        Topic topic = new Topic(randomAlphanumeric(10), testString);
        Topic createdTopic = Topic.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @DataProvider
    public Object[][]bbCodesWithMessagethatShouldPass(){
        String minBoundaryMessage = "BB codes that are not visible to users do not count " +
                "during length validation, therefore 2 symbols is the lower boundary for the topic body";
        String averageBodySizeMessage = "A valid text of usual sizes (10 symbols)";
        String maxBoundaryMessage = "Max boundary 20000 symbols. Since bb codes are stored in " +
                "DB as usual symbols, they are calculated during max size validation of topic body.";
        String openBbCodeShouldNotFailMessage = "Open BB code tag is visible to user and therefore is calculated during" +
                " message size validation. Since open BB code is more than 2 symbols, the validation should pass";
        String wrongLinkInsideBbCodesTagsMessage = "Wrong link inside BB code tags" +
                "Since open BB code is more than 2 symbols, the validation should pass";

        return new String[][]{
            {"[b]" + randomAlphanumeric(2) + "[/b]", "BB code [b] validation passed. " + minBoundaryMessage},
            {"[b]" + randomAlphanumeric(10) + "[/b]", "BB code [b] validation passed. " + averageBodySizeMessage},
            {"[b]" + randomAlphanumeric(20000) + "[/b]", "BB code [b] validation passed. " + maxBoundaryMessage},
            {"[b]", "BB code [b] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/b]", "BB code close [/b] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[i]" + randomAlphanumeric(2) + "[/i]", "BB code [i] validation passed. " + minBoundaryMessage},
            {"[i]" + randomAlphanumeric(10) + "[/i]", "BB code [i] validation passed. " + averageBodySizeMessage},
            {"[i]" + randomAlphanumeric(20000) + "[/i]", "BB code [i] validation passed. " + maxBoundaryMessage},
            {"[i]", "BB code [i] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/i]", "BB code close [/i] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[s]" + randomAlphanumeric(2) + "[/s]", "BB code [s] validation passed. " + minBoundaryMessage},
            {"[s]" + randomAlphanumeric(10) + "[/s]", "BB code [s] validation passed. " + averageBodySizeMessage},
            {"[s]" + randomAlphanumeric(20000) + "[/s]", "BB code [s] validation passed. " + maxBoundaryMessage},
            {"[s]", "BB code [s] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/s]", "BB code close [/s] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[u]" + randomAlphanumeric(2) + "[/u]", "BB code [u] validation passed. " + minBoundaryMessage},
            {"[u]" + randomAlphanumeric(10) + "[/u]", "BB code [u] validation passed. " + averageBodySizeMessage},
            {"[u]" + randomAlphanumeric(20000) + "[/u]", "BB code [u] validation passed. " + maxBoundaryMessage},
            {"[u]", "BB code [u] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/u]", "BB code close [/u] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[highlight]" + randomAlphanumeric(2) + "[/highlight]", "BB code [highlight] validation passed. " + minBoundaryMessage},
            {"[highlight]" + randomAlphanumeric(10) + "[/highlight]", "BB code [highlight] validation passed. " + averageBodySizeMessage},
            {"[highlight]" + randomAlphanumeric(20000) + "[/highlight]", "BB code [highlight] validation passed. " + maxBoundaryMessage},
            {"[highlight]", "BB code [highlight] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/highlight]", "BB code close [/highlight] tag validation passed. " + openBbCodeShouldNotFailMessage},

            {"[left]" + randomAlphanumeric(2) + "[/left]", "BB code [left] validation passed. " + minBoundaryMessage},
            {"[left]" + randomAlphanumeric(10) + "[/left]", "BB code [left] validation passed. " + averageBodySizeMessage},
            {"[left]" + randomAlphanumeric(20000) + "[/left]", "BB code [left] validation passed. " + maxBoundaryMessage},
            {"[left]", "BB code [left] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/left]", "BB code close [/left] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[center]" + randomAlphanumeric(2) + "[/center]", "BB code [center] validation passed. " + minBoundaryMessage},
            {"[center]" + randomAlphanumeric(10) + "[/center]", "BB code [center] validation passed. " + averageBodySizeMessage},
            {"[center]" + randomAlphanumeric(20000) + "[/center]", "BB code [center] validation passed. " + maxBoundaryMessage},
            {"[center]", "BB code [center] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/center]", "BB code close [/center] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[right]" + randomAlphanumeric(2) + "[/right]", "BB code [right] validation passed. " + minBoundaryMessage},
            {"[right]" + randomAlphanumeric(10) + "[/right]", "BB code [right] validation passed. " + averageBodySizeMessage},
            {"[right]" + randomAlphanumeric(20000) + "[/right]", "BB code [right] validation passed. " + maxBoundaryMessage},
            {"[right]", "BB code [right] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/right]", "BB code close [/right] tag validation passed. " + openBbCodeShouldNotFailMessage},

            {"[list][*]" + randomAlphanumeric(2) + "[/list]", "BB code [list] validation passed. " + minBoundaryMessage},
            {"[list][*]" + randomAlphanumeric(10) + "[/list]", "BB code [list] validation passed. " + averageBodySizeMessage},
            {"[list][*]" + randomAlphanumeric(20000) + "[/list]", "BB code [list] validation passed. " + maxBoundaryMessage},
            {"[list][*]", "BB code [list] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/list]", "BB code close [/list] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[*]", "BB code add list item [*] tag validation passed. " + openBbCodeShouldNotFailMessage},

            {"[color=000099]" + randomAlphanumeric(2) + "[/color]", "BB code [color] validation passed. " + minBoundaryMessage},
            {"[color=000099]" + randomAlphanumeric(10) + "[/color]", "BB code [color] validation passed. " + averageBodySizeMessage},
            {"[color=000099]" + randomAlphanumeric(20000) + "[/color]", "BB code [color] validation passed. " + maxBoundaryMessage},
            {"[color=000099]", "BB code [color] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/color]", "BB code close [/color] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[size=7]" + randomAlphanumeric(2) + "[/size]", "BB code [size] validation passed. " + minBoundaryMessage},
            {"[size=7]" + randomAlphanumeric(10) + "[/size]", "BB code [size] validation passed. " + averageBodySizeMessage},
            {"[size=7]" + randomAlphanumeric(20000) + "[/size]", "BB code [size] validation passed. " + maxBoundaryMessage},
            {"[size=7]", "BB code [size] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/size]", "BB code close [/size] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[size=9]" + randomAlphanumeric(2) + "[/size]", "BB code [size] validation passed. " + minBoundaryMessage},
            {"[size=9]" + randomAlphanumeric(10) + "[/size]", "BB code [size] validation passed. " + averageBodySizeMessage},
            {"[size=9]" + randomAlphanumeric(20000) + "[/size]", "BB code [size] validation passed. " + maxBoundaryMessage},
            {"[size=9]", "BB code [right] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[size=12]" + randomAlphanumeric(2) + "[/size]", "BB code [size] validation passed. " + minBoundaryMessage},
            {"[size=12]" + randomAlphanumeric(10) + "[/size]", "BB code [size] validation passed. " + averageBodySizeMessage},
            {"[size=12]" + randomAlphanumeric(20000) + "[/size]", "BB code [size] validation passed. " + maxBoundaryMessage},
            {"[size=12]", "BB code [size] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[size=18]" + randomAlphanumeric(2) + "[/size]", "BB code [size] validation passed. " + minBoundaryMessage},
            {"[size=18]" + randomAlphanumeric(10) + "[/size]", "BB code [size] validation passed. " + averageBodySizeMessage},
            {"[size=18]" + randomAlphanumeric(20000) + "[/size]", "BB code [size] validation passed. " + maxBoundaryMessage},
            {"[size=18]", "BB code [size] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[size=24]" + randomAlphanumeric(2) + "[/size]", "BB code [size] validation passed. " + minBoundaryMessage},
            {"[size=24]" + randomAlphanumeric(10) + "[/size]", "BB code [size] validation passed. " + averageBodySizeMessage},
            {"[size=24]" + randomAlphanumeric(20000) + "[/size]", "BB code [size] validation passed. " + maxBoundaryMessage},
            {"[size=24]", "BB code [size] validation passed. " + openBbCodeShouldNotFailMessage},

            {"[img]" + randomAlphanumeric(2) + "[/img]", "BB code [img] validation passed. " + wrongLinkInsideBbCodesTagsMessage},
            {"[img]" + randomAlphanumeric(10) + "[/img]", "BB code [img] validation passed. " + wrongLinkInsideBbCodesTagsMessage},
            {"[img]" + randomAlphanumeric(20000) + "[/img]", "BB code [img] validation passed. " + wrongLinkInsideBbCodesTagsMessage},
            {"[img]", "BB code [img] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/img]", "BB code close [/img] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[url=new link]" + randomAlphanumeric(2) + "[/url]", "BB code [url] validation passed. " + wrongLinkInsideBbCodesTagsMessage},
            {"[url=new link]" + randomAlphanumeric(10) + "[/url]", "BB code [url] validation passed. " + wrongLinkInsideBbCodesTagsMessage},
            {"[url=new link]" + randomAlphanumeric(20000) + "[/url]", "BB code [url] validation passed. " + wrongLinkInsideBbCodesTagsMessage},
            {"[url=new link]", "BB code [url] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/url]", "BB code close [/url] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=cpp]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=cpp]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=cpp]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=cpp]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/code]", "BB code close [/code] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=csharp]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=csharp]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=csharp]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=csharp]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=java]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=java]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=java]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=java]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=php]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=php]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=php]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=php]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=python]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=python]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=python]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=python]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=pascal]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=pascal]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=pascal]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=pascal]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=bash]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=bash]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=bash]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=bash]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=js]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=js]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=js]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=js]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=html]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=html]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=html]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=html]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=css]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=css]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=css]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=css]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=sql]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=sql]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=sql]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=sql]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[code=xml]" + randomAlphanumeric(2) + "[/code]", "BB code [code] validation passed. " + minBoundaryMessage},
            {"[code=xml]" + randomAlphanumeric(10) + "[/code]", "BB code [code] validation passed. " + averageBodySizeMessage},
            {"[code=xml]" + randomAlphanumeric(20000) + "[/code]", "BB code [code] validation passed. " + maxBoundaryMessage},
            {"[code=xml]", "BB code [code] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[quote]" + randomAlphanumeric(2) + "[/quote]", "BB code [quote] validation passed. " + minBoundaryMessage},
            {"[quote]" + randomAlphanumeric(10) + "[/quote]", "BB code [quote] validation passed. " + averageBodySizeMessage},
            {"[quote]" + randomAlphanumeric(20000) + "[/quote]", "BB code [quote] validation passed. " + maxBoundaryMessage},
            {"[quote]", "BB code [quote] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/quote]", "BB code close [/quote] tag validation passed. " + openBbCodeShouldNotFailMessage},

            {"[indent=15]" + randomAlphanumeric(2) + "[/indent]", "BB code [indent] validation passed. " + minBoundaryMessage},
            {"[indent=15]" + randomAlphanumeric(10) + "[/indent]", "BB code [indent] validation passed. " + averageBodySizeMessage},
            {"[indent=15]" + randomAlphanumeric(20000) + "[/qindent]", "BB code [indent] validation passed. " + maxBoundaryMessage},
            {"[indent=15]", "BB code [indent] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[/indent]", "BB code close [/indent] tag validation passed. " + openBbCodeShouldNotFailMessage},
            {"[indent=20]" + randomAlphanumeric(2) + "[/indent]", "BB code [indent] validation passed. " + minBoundaryMessage},
            {"[indent=20]" + randomAlphanumeric(10) + "[/indent]", "BB code [indent] validation passed. " + averageBodySizeMessage},
            {"[indent=20]" + randomAlphanumeric(20000) + "[/qindent]", "BB code [indent] validation passed. " + maxBoundaryMessage},
            {"[indent=20]", "BB code [indent] validation passed. " + openBbCodeShouldNotFailMessage},
            {"[indent=25]" + randomAlphanumeric(2) + "[/indent]", "BB code [indent] validation passed. " + minBoundaryMessage},
            {"[indent=25]" + randomAlphanumeric(10) + "[/indent]", "BB code [indent] validation passed. " + averageBodySizeMessage},
            {"[indent=25]" + randomAlphanumeric(20000) + "[/qindent]", "BB code [indent] validation passed. " + maxBoundaryMessage},
            {"[indent=25]", "BB code [indent] validation passed. " + openBbCodeShouldNotFailMessage},


        };
    }

    @DataProvider
    public Object[][] bbCodesMessage_thatShouldFail() {
        String emptyBbCodeMessage = "BB codes that are not visible to users do not count " +
                "during length validation, empty BB code results in empty message which is lower than min boundary";
        String singleVisibleCharacterIsLowerThanMinBoundaryMessage = "BB codes that are not visible to users do not " +
                "count. 1 symbol is lower than min boundary (2) and therefore validation should fail.";
        return new String[][]{
            {"[b][/b]", "BB code [b] validation did NOT fail. " + emptyBbCodeMessage},
            {"[b]a[/b]", "BB code [b] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[i][/i]", "BB code [i] validation did NOT fail. " + emptyBbCodeMessage},
            {"[i]a[/i]", "BB code [b] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[u][/u]", "BB code [u] validation did NOT fail. " + emptyBbCodeMessage},
            {"[u]a[/u]", "BB code [u] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[s][/s]", "BB code [s] validation did NOT fail. " + emptyBbCodeMessage},
            {"[s]a[/s]", "BB code [s] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[highlight][/highlight]", "BB code [highlight] validation did NOT fail. " + emptyBbCodeMessage},
            {"[highlight]a[/highlight]", "BB code [highlight] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[left][/left]", "BB code [left] validation did NOT fail. " + emptyBbCodeMessage},
            {"[left]a[/left]", "BB code [left] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[center][/center]", "BB code [center] validation did NOT fail. " + emptyBbCodeMessage},
            {"[center]a[/center]", "BB code [center] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[right][/right]", "BB code [right] validation did NOT fail. " + emptyBbCodeMessage},
            {"[right]a[/right]", "BB code [right] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[list][*][/list]", "BB code [list] validation did NOT fail. " + emptyBbCodeMessage},

            {"[color=33CCCC][/color]", "BB code [color] validation did NOT fail. " + emptyBbCodeMessage},
            {"[color=33CCCC]q[/color]", "BB code [color] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[size=7][/size]", "BB code [size] validation did NOT fail. " + emptyBbCodeMessage},
            {"[size=7]a[/size]", "BB code [size] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[size=9][/size]", "BB code [size] validation did NOT fail. " + emptyBbCodeMessage},
            {"[size=9]a[/size]", "BB code [size] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[size=12][/size]", "BB code [size] validation did NOT fail. " + emptyBbCodeMessage},
            {"[size=12]a[/size]", "BB code [size] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[size=18][/size]", "BB code [size] validation did NOT fail. " + emptyBbCodeMessage},
            {"[size=18]a[/size]", "BB code [size] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[size=24][/size]", "BB code [size] validation did NOT fail. " + emptyBbCodeMessage},
            {"[size=24]a[/size]", "BB code [size] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[code=cpp][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=cpp]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[code=csharp][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=csharp]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[code=java][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=java]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[code=php][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=php]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[size=python][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[size=python]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[code=pascal][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=pascal]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[code=bash][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=bash]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[code=js][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=js]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[code=html][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=html]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[size=css][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[size=css]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[code=sql][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[code=sql]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[size=sql][/code]", "BB code [code] validation did NOT fail. " + emptyBbCodeMessage},
            {"[size=sql]a[/code]", "BB code [code] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[quote][/quote]", "BB code [quote] validation did NOT fail. " + emptyBbCodeMessage},
            {"[quote]a[/quote]", "BB code [quote] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

            {"[indent=15][/indent]", "BB code [indent] validation did NOT fail. " + emptyBbCodeMessage},
            {"[indent=15]a[/indent]", "BB code [indent] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[indent=20][/indent]", "BB code [indent] validation did NOT fail. " + emptyBbCodeMessage},
            {"[indent=20]a[/indent]", "BB code [indent] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},
            {"[indent=25][/indent]", "BB code [indent] validation did NOT fail. " + emptyBbCodeMessage},
            {"[indent=25]a[/indent]", "BB code [indent] validation did NOT fail. " + singleVisibleCharacterIsLowerThanMinBoundaryMessage},

        };


    }



























    //
    // Bold [b][/b] bb-code coverage
    //
    /*@Test
      public void boldBbCodeWithMinAllowedTextLength_ShouldPass(String n1, String n2) throws Exception {  // using n3 and n2 parameters from DataProvider
        Users.signUpAndSignIn();
        // String newSubject = randomAlphanumeric(7);
        // String newText = randomAlphanumeric(2);
        Topic topic = new Topic(n2,"[b]" + n1 + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(dataProvider = "randomData")
    public void boldBbCodeWithMaxAllowedTextLength_ShouldPass(String n2, String n3) throws Exception {
        Users.signUpAndSignIn();
        // String newSubject = randomAlphanumeric(7);
        // String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(n2,"[b]" + n3 + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openBoldBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeBoldBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void boldBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[b]" + newText + "[/b]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
     public void emptyBoldBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[b][/b]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthIsideBoldBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[b]" + newText + "[/b]");
        Topics.createTopic(topic);
    }

    //
    // Italic [i][/i] bb-code coverage
    //
    @Test
    public void italicBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[i]" + newText + "[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void italicBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[i]" + newText + "[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openItalicBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeItalicBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void italicBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[i]" + newText + "[/i]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyItalicBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[i][/i]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideItalicBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[i]" + newText + "[/i]");
        Topics.createTopic(topic);
    }

    //
    // Underlined [u][/u] bb-code coverage
    //
    @Test
    public void underlinedBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[u]" + newText + "[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void underlinedBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[u]" + newText + "[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openUnderlinedBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeUnderlinedBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void underlinedBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[u]" + newText + "[/u]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyUnderlinedBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[u][/u]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideUnderlinedBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[u]" + newText + "[/u]");
        Topics.createTopic(topic);
    }

    //
    // Striked [s][/s] bb-code coverage
    //
    @Test
    public void strikedBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[s]" + newText + "[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void strikedBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[s]" + newText + "[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openStrikedBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeStrikedBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void strikedBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[s]" + newText + "[/s]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyStrikedBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[s][/s]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideStrikedBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[s]" + newText + "[/s]");
        Topics.createTopic(topic);
    }

    //
    // Highlight [highlight][/highlight] bb-code coverage
    //
    @Test
    public void highlightBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[highlight]" + newText + "[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void highlightBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[highlight]" + newText + "[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openHighlightBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeHighlightBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void highlightBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[highlight]" + newText + "[/highlight]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyHighlightBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[highlight][/highlight]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideHighlightBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[highlight]" + newText + "[/highlight]");
        Topics.createTopic(topic);
    }

    //
    // Align Left [left][/left] bb-code coverage
    //
    @Test
    public void alignLeftBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[left]" + newText + "[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignLeftBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[left]" + newText + "[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openAlignLeftBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeAlignLeftBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignLeftBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[left]" + newText + "[/left]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyAlignLeftBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[left][/left]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideAlignLeftBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[left]" + newText + "[/left]");
        Topics.createTopic(topic);
    }

    //
    // Align center [center][/center] bb-code coverage
    //
    @Test
    public void alignCenterBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[center]" + newText + "[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignCenterBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[center]" + newText + "[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openCenterLeftBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeAlignCenterBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignCenterBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[center]" + newText + "[/center]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyAlignCenterBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[center][/center]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideAlignCenterBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[center]" + newText + "[/center]");
        Topics.createTopic(topic);
    }

    //
    // Align right [right][/right] bb-code coverage
    //
    @Test
    public void alignRightBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[right]" + newText + "[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignRightBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[right]" + newText + "[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openRightBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeAlignRightBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void alignRightBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[center]" + newText + "[/right]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyAlignRightBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[right][/right]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideAlignRightBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[right]" + newText + "[/right]");
        Topics.createTopic(topic);
    }

    //
    // Color (blue) [color=0033CC][/color] bb-code coverage
    //
    @Test
    public void colorBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[color=0033CC]" + newText + "[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void colorBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[color=0033CC]" + newText + "[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openColorBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[color=0033CC]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeColorBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void colorBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[color=0033CC]" + newText + "[/color]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyColorBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[color=0033CC][/color]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideColorBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[color=0033CC]" + newText + "[/color]");
        Topics.createTopic(topic);
    }

    //
    // Font size Tiny [size=7][/size] bb-code coverage
    //
    @Test
    public void fontSizeTinyBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[size=7]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeTinyBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[size=7]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeTinyBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[size=7]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontSizeTinyBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeTinyBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[size=7]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeTinyBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[size=7][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeTinyBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[size=7]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Font size Small [size=9][/size] bb-code coverage
    //
    @Test
    public void fontSizeSmallBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[size=9]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeSmallBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[size=9]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeSmallBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[size=9]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontSmallTinyBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeSmallBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[size=9]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeSmallBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[size=9][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeSmallBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[size=9]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Font size Normal [size=12][/size] bb-code coverage
    //
    @Test
    public void fontSizeNormalBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[size=12]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeNormalBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[size=12]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeNormalBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[size=12]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontNormalBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeNormalBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[size=12]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeNormalBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[size=12][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeNormalBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[size=12]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Font size Large [size=18][/size] bb-code coverage
    //
    @Test
    public void fontSizeLargeBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[size=18]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeLargeBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[size=18]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeLargeBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[size=18]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontLargeBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeLargeBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[size=18]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeLargeBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[size=18][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeLargeBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[size=18]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Font size Huge [size=24][/size] bb-code coverage
    //
    @Test
    public void fontSizeHugeBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[size=24]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeHugeBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[size=24]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openFontSizeHugeBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[size=24]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeFontHugeBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void fontSizeHugeBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[size=24]" + newText + "[/size]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyFontSizeHugeBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[size=24][/size]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontSizeHugeBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[size=24]" + newText + "[/size]");
        Topics.createTopic(topic);
    }

    //
    // Insert picture [img][/img] bb-code coverage
    //
    @Test
    public void insertPictureBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[img]" + newText + "[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertPictureBbCodeWithUrlToPicture_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[img]http://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Kamomillasaunio_%28Matricaria_recutita%29.JPG/160px-Kamomillasaunio_%28Matricaria_recutita%29.JPG[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertPictureBbCodeWithBrokenUrlToPicture_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[img]http://upload.wikimedia.org/wikipedia[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertPictureBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[img]" + newText + "[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openInsertPictureBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeInsertPictureBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertPictureBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[img]" + newText + "[/img]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyInsertPictureBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[img][/img]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideFontInsertPictureBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[img]" + newText + "[/img]");
        Topics.createTopic(topic);

    }

    //
    // Insert link [url=newurl][/url] bb-code coverage
    //
    @Test
    public void insertUrlBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[url=newText]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeWithUrlToPicture_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[url=http://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Kamomillasaunio_%28Matricaria_recutita%29.JPG/160px-Kamomillasaunio_%28Matricaria_recutita%29.JPG]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeWithBrokenUrlToPicture_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[url=newurl]http://upload.wikimedia.org/wikipedia[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[url=newText]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openUrlPictureBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[url=newText]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeInsertUrlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[url=newText]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void insertUrlBbCodeTenSymbolsTextIsideTagsInsertTenSymbolsTextInsteadUrl_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[url=" + newText + "]" + newText + "[/url]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyInsertUrlBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[url=newText][/url]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsteadUrlInsideUrlBbCOde_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject, "[url=" + newText + "]" + newText + "[/url]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsteadUrl_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject, "[url=" + newText + "]newText[/url]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideUrlBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[url=newText]" + newText + "[/url]");
        Topics.createTopic(topic);

    }

    //
    // Quote [quote][/quote] bb-code coverage
    //
    @Test
    public void quoteBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[quote]" + newText + "[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void quoteBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[quote]" + newText + "[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openQuoteBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeQuoteBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void quoteBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[quote]" + newText + "[/quote]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptyQuoteBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[quote][/quote]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideQuoteBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[quote]" + newText + "[/quote]");
        Topics.createTopic(topic);
    }

    //
    // Size of margin 15 [indent=15][/indent] bb-code coverage
    //
    @Test
    public void sizeOfMargin15BbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[indent=15]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin15BbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[indent=15]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSizeOfMargin15BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[indent=15]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSizeOfMargin15BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin15BbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[indent=15]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySizeOfMargin15BbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[indent=15][/indent]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSizeOfMargin15BbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[indent=15]" + newText + "[/indent]");
        Topics.createTopic(topic);
    }

    //
    // Size of margin 20 [indent=20][/indent] bb-code coverage
    //
    @Test
    public void sizeOfMargin20BbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[indent=20]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin20BbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[indent=20]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSizeOfMargin20BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[indent=20]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSizeOfMargin120BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin20BbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[indent=20]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySizeOfMargin20BbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[indent=20][/indent]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSizeOfMargin20BbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[indent=20]" + newText + "[/indent]");
        Topics.createTopic(topic);
    }

    //
    // Size of margin 25 [indent=25][/indent] bb-code coverage
    //
    @Test
    public void sizeOfMargin25BbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[indent=25]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin25BbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[indent=25]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSizeOfMargin25BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[indent=25]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSizeOfMargin125BbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void sizeOfMargin25BbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[indent=25]" + newText + "[/indent]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySizeOfMargin25BbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[indent=25][/indent]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSizeOfMargin25BbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[indent=25]" + newText + "[/indent]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight C/C++ [code=cpp][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightCBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=cpp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
     public void syntaxHighlightCBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=cpp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightCBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=cpp]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightCBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=cpp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightCBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=cpp][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightCBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=cpp]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight C# [code=csharp][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightCsharpBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=csharp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCsharpBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=csharp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCsharpBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightCsharpBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=csharp]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightCsharpBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCsharpBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=csharp]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightCsharpBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=csharp][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightCsharpBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=csharp]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight java [code=java][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightJavaBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=java]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJavaBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=java]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJavaBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightJavaBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=java]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightJavaBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJavaBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=java]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightJavaBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=java][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightJavaBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=java]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight php [code=php][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightPhpBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=php]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPhpBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=php]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPhpBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightPhpBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=php]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightPhpBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPhpBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=php]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightPhpBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=php][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightPhpBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=php]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight python [code=python][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightPythonBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=python]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPythonBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=python]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPythonBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightPythonBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=python]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightPythonBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPythonBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=python]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightPythonBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=python][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightPythonBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=python]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight pascal [code=pascal][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightPascalBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=pascal]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPascalBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=pascal]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPascalBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightPascalBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=pascal]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightPascalBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightPascalBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=pascal]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightPascalBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=pascal][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightPascalBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=pascal]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight bash [code=bash][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightBashBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=bash]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightBashBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=bash]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightBashBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightBashlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=bash]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightBashBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightBashBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=bash]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightBashBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=bash][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightBashBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=bash]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight js [code=js][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightJsBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=js]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJsBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=js]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJsBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightJslBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=js]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightJsBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightJsBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=js]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightJsBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=js][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightJsBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=js]" + newText + "[/code]");
        Topics.createTopic(topic);
    }

    //
    // Add syntax highlight html [code=html][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightHtmlBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=html]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightHtmlBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=html]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightHtmlBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightHtmllBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=html]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightHtmlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightHtmlBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=html]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightHtmlBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=html][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightHtmlBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=html]" + newText + "[/code]");
        Topics.createTopic(topic);
    }


    //
    // Add syntax highlight css [code=css][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightCssBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
                Topic topic = new Topic(newSubject,"[code=css]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCssBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=css]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCssBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightCssBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=css]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightCssBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightCssBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=css]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightCssBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=css][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightCssBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=css]" + newText + "[/code]");
        Topics.createTopic(topic);
    }


    //
    // Add syntax highlight sql [code=sql][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightSqlBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=sql]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightSqlBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=sql]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightSqlBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightSqlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=sql]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightSqlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightSqlBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=sql]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightSqlBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=sql][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightSqlBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=sql]" + newText + "[/code]");
        Topics.createTopic(topic);
    }


    //
    // Add syntax highlight xml [code=xml][/code] bb-code coverage
    //
    @Test
    public void syntaxHighlightXmlBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=xml]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightXmlBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[code=xml]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightXmlBbCodeWithMinAllowedTextLengthWithWrongSyntaxInsideOpenTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[code=" + newText+ "]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openSyntaxHighlightXmlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[code=xml]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeSyntaxHighlightXmlBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void syntaxHighlightXmlBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[code=xml]" + newText + "[/code]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void emptySyntaxHighlightXmlBbCodeNoStringInside_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject, "[code=xml][/code]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideSyntaxHighlightXmlBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[code=xml]" + newText + "[/code]");
        Topics.createTopic(topic);
    }


    //
    // list [list][*][/list] bb-code coverage
    //
    @Test
    public void listBbCodeWithMinAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(2);
        Topic topic = new Topic(newSubject,"[list][*]" + newText + "[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void listBbCodeWithMaxAllowedTextLength_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20000);
        Topic topic = new Topic(newSubject,"[list][*]" + newText + "[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
     public void openListBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void openListBbCodeTagPlusTextTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[list][*]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
     public void closeListBbCodeTagPlusTextTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[*][/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void closeListBbCodeTag_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        Topic topic = new Topic(newSubject,"[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
     public void listBbCodeTenSymbolsText_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[list]" + newText + "[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test
    public void listBbCodeTenSymbolsTextOneListItem_ShouldPass() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(10);
        Topic topic = new Topic(newSubject,"[list][*]" + newText + "[/list]");
        Topic createdTopic = Topics.createTopic(topic);
        Assert.assertTrue(Topics.isCreated(createdTopic));
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideListOneListItemBbCode_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[list][*]" + newText + "[/list]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
      public void overMaxLimitTextlengthInsideListBbCodeBeforeListItemTag_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[list]" + newText + "[*][/list]");
        Topics.createTopic(topic);
    }

    @Test(enabled = false, expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = TopicPage.EMPTY_BODY_ERROR)
    public void overMaxLimitTextlengthInsideListBbCodeOneListItemTag_ShouldFail() throws Exception {
        Users.signUpAndSignIn();
        String newSubject = randomAlphanumeric(7);
        String newText = randomAlphanumeric(20001);
        Topic topic = new Topic(newSubject, "[list][*]" + newText + "[/list]");
        Topics.createTopic(topic);
    }*/


}
