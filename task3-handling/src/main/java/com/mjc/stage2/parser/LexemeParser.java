package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser{
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        Pattern word = Pattern.compile(WORD_REGEX);

        String[] strings = string.split(LEXEME_REGEX);

        for (String str: strings){
            Matcher matcher = word.matcher(str);

            while(matcher.find()){
                String group = matcher.group();
                String replacedString = str.replace(group, "");

                for (char x: replacedString.toCharArray()){
                    abstractTextComponent.add(new SymbolLeaf(x, TextComponentType.SYMBOL));
                }
            }
        }

    }


}
