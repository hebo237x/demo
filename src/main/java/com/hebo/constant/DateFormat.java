package com.hebo.constant;


import com.hebo.util.EnumUtils;

public enum DateFormat implements EnumUtils.CustomEnum<String> {
    ShortNumDate("yyMMdd"),

    NumDate("yyyyMMdd"),

    StrikeDate("yyyy-MM-dd"),

    NumDateTime("yyyyMMddHHmmss"),

    TwoYearNumDateTime("yyMMddHHmmss"),

    MinuteCondTime("yyyy-MM-dd HH:mm"),

    StrikeDateTime("yyyy-MM-dd HH:mm:ss"),

    MillisecondTime("yyyy-MM-dd HH:mm:ss SSS"),

    NumTime("HHmmss"),

    ColonTime("HH:mm:ss"),

    MinuteTime("HH:mm");

    private final String value;

    DateFormat(String value) {
        this.value = value;
    }

    @Override
    public String realVal() {
        return value;
    }
}
