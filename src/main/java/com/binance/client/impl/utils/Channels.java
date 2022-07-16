package com.binance.client.impl.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binance.client.model.enums.CandlestickInterval;

import java.util.regex.Pattern;

public abstract class Channels {

    public static final String OP_SUB = "sub";
    public static final String OP_REQ = "req";

    public static String aggregateTradeChannel(String symbol) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@aggTrade");
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String markPriceChannel(String symbol) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@markPrice");
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String candlestickChannel(String symbol, CandlestickInterval interval) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@kline_" + interval);
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String miniTickerChannel(String symbol) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@miniTicker");
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String miniTickerChannel() {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add("!miniTicker@arr");
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String tickerChannel(String symbol) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@ticker");
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String tickerChannel() {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add("!ticker@arr");
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String bookTickerChannel(String symbol) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@bookTicker");
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String bookTickerChannel() {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add("!bookTicker");
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String liquidationOrderChannel(String symbol) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@forceOrder");
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String liquidationOrderChannel() {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add("!forceOrder@arr");
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String bookDepthChannel(String symbol, Integer limit) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@depth" + limit);
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String diffDepthChannel(String symbol) {
        String[] symbols = symbol.split(Pattern.quote(","));
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        for (String s : symbols) {
            params.add(s + "@depth");
        }
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

    public static String userDataChannel(String listenKey) {
        JSONObject json = new JSONObject();
        JSONArray params = new JSONArray();
        params.add(listenKey);
        json.put("params", params);
        json.put("id", System.currentTimeMillis());
        json.put("method", "SUBSCRIBE");
        return json.toJSONString();
    }

}