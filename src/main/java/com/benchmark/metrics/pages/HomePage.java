package com.benchmark.metrics.pages;

import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.P;

/**
 * @author jsanderson .
 */
public class HomePage extends BasePage{
    public HomePage() {
        super(DocumentType.HTMLStrict);
        createBody();
    }

    public void createBody() {
        body.appendChild(
                new H1().appendText("Benchmark Metrics"),
                new P().appendText("Welcome to Medicare benchmark metrics."),
                new A().appendText("Click here to begin searching").setHref("./search")
        );
    }

    @Override
    public String getPageTitle() {
        return "Benchmark Metrics Home";
    }
}
