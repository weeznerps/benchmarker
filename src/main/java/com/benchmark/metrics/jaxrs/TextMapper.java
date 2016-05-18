package com.benchmark.metrics.jaxrs;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benchmark.metrics.pages.TextKey;

/**
 * @author jsanderson
 */
public class TextMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextMapper.class);

    private static final String BUNDLE_NAME="messages";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    public static String getText(TextKey textKey, Object ...objects) {
        String keyName = textKey.getClass().getName().replace("$", ".") + "." + textKey.name();
        String message;
        try{
            message = resourceBundle.getString(keyName);
        } catch(MissingResourceException e) {
            LOGGER.error("Missing key " + keyName, e);
            return textKey.name();
        }

        return MessageFormat.format(resourceBundle.getString(keyName), objects);
    }
}
