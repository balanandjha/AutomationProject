package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {
    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.cssSelector(".lighter");
    private static final By PRODUCT_LIST_NAME_LOCATOR = By.xpath("//h5[@itemprop='name']/a");
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    public String getProductListingTitle() {
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm){
       List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNames = getAllVisibleText(PRODUCT_LIST_NAME_LOCATOR);
       boolean result = productNames.stream()
                        .anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
        return result;
    }

    public ProductDetailPage clickOnProductAtIndex(int index) {
            clickOnElement(getAllElements(PRODUCT_LIST_NAME_LOCATOR).get(index));
        ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
        return productDetailPage;
    }

}
