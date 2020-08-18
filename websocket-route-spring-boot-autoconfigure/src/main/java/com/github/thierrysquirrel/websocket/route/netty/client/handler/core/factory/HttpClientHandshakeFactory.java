/**
 * Copyright 2020 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.thierrysquirrel.websocket.route.netty.client.handler.core.factory;

import com.github.thierrysquirrel.websocket.route.core.domain.HttpUpgradeMessage;
import com.github.thierrysquirrel.websocket.route.core.exception.WebsocketRouteException;
import com.github.thierrysquirrel.websocket.route.init.core.factory.constant.HandshakeFactoryConstant;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * ClassName: HttpClientHandshakeFactory
 * Description:
 * date: 2020/8/18 5:04
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class HttpClientHandshakeFactory {
    private HttpClientHandshakeFactory() {
    }

    public static WebSocketClientHandshaker getWebSocketClientHandshake(HttpUpgradeMessage upgradeMessage, int maxFramePayloadLength) throws WebsocketRouteException {
        try {
            return WebSocketClientHandshakerFactory.newHandshaker (
                    new URI (HandshakeFactoryConstant.WEBSOCKET_PROTOCOL + upgradeMessage.getUrl () + upgradeMessage.getPath ()), WebSocketVersion.V13, null, Boolean.TRUE, upgradeMessage.getHeaders (), maxFramePayloadLength);
        } catch (URISyntaxException e) {
            throw new WebsocketRouteException ("Error Uri:" + HandshakeFactoryConstant.WEBSOCKET_PROTOCOL + upgradeMessage.getUrl () + upgradeMessage.getPath (), e);
        }
    }

    public static void handshake(Channel clientChannel,
                                 FullHttpResponse response,
                                 WebSocketClientHandshaker handshake,
                                 ChannelPromise handshakeFuture) {
        handshake.finishHandshake (clientChannel, response);
        handshakeFuture.setSuccess ();
    }


}
