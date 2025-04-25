package com.binance.client.impl;

import com.binance.client.SubscriptionClient;
import com.binance.client.SubscriptionErrorHandler;
import com.binance.client.SubscriptionListener;
import com.binance.client.SubscriptionOptions;
import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.model.event.*;
import com.binance.client.model.user.UserDataUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WebSocketStreamClientImpl implements SubscriptionClient {

    private final SubscriptionOptions options;
    private WebSocketWatchDog watchDog;

    private final WebsocketRequestImpl requestImpl;

    private final List<WebSocketConnection> connections = new LinkedList<>();

    WebSocketStreamClientImpl(SubscriptionOptions options) {
        this.watchDog = null;
        this.options = Objects.requireNonNull(options);

        this.requestImpl = new WebsocketRequestImpl();
    }

    private <T> WebSocketConnection createConnection(WebsocketRequest<T> request, boolean autoClose) {
        if (watchDog == null) {
            watchDog = new WebSocketWatchDog(options);
        }
        WebSocketConnection connection = new WebSocketConnection(request, watchDog, autoClose);
        if (autoClose == false) {
            connections.add(connection);
        }
        connection.connect();
        return connection;
    }

    private <T> WebSocketConnection createConnection(WebsocketRequest<T> request) {
        return createConnection(request, false);
    }

    @Override
    public void unsubscribeAll() {
        for (WebSocketConnection connection : connections) {
            watchDog.onClosedNormally(connection);
            connection.close();
        }
        connections.clear();
    }

    @Override
    public WebSocketConnection subscribeAggregateTradeEvent(String symbol,
            SubscriptionListener<AggregateTradeEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeAggregateTradeEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeMarkPriceEvent(String symbol,
            SubscriptionListener<MarkPriceEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeMarkPriceEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeCandlestickEvent(String symbol, CandlestickInterval interval,
            SubscriptionListener<CandlestickEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeCandlestickEvent(symbol, interval, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeSymbolMiniTickerEvent(String symbol,
            SubscriptionListener<SymbolMiniTickerEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeSymbolMiniTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> subscriptionListener,
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeAllMiniTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeSymbolTickerEvent(String symbol,
            SubscriptionListener<SymbolTickerEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeSymbolTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> subscriptionListener,
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeAllTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeSymbolBookTickerEvent(String symbol,
            SubscriptionListener<SymbolBookTickerEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeSymbolBookTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeAllBookTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeSymbolLiquidationOrderEvent(String symbol,
            SubscriptionListener<LiquidationOrderEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeSymbolLiquidationOrderEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeAllLiquidationOrderEvent(SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeAllLiquidationOrderEvent(subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeBookDepthEvent(String symbol, Integer limit,
            SubscriptionListener<OrderBookEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeBookDepthEvent(symbol, limit, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeDiffDepthEvent(String symbol,
            SubscriptionListener<OrderBookEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeDiffDepthEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public WebSocketConnection subscribeUserDataEvent(String listenKey,
            SubscriptionListener<UserDataUpdateEvent> subscriptionListener, 
            SubscriptionErrorHandler errorHandler) {
        return createConnection(
                requestImpl.subscribeUserDataEvent(listenKey, subscriptionListener, errorHandler));
    }
}
