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
package com.github.thierrysquirrel.websocket.route.netty.server.handler.core.factory.execution;

import com.github.thierrysquirrel.websocket.route.netty.core.factory.constant.ThreadPoolFactoryConstant;
import com.github.thierrysquirrel.websocket.route.netty.core.factory.execution.ThreadPoolFactoryExecution;
import com.github.thierrysquirrel.websocket.route.netty.thread.execution.WebsocketBusinessThreadExecution;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: WebsocketServerHandlerExecution
 * Description:
 * date: 2020/8/18 8:18
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class WebsocketServerHandlerExecution {
    private WebsocketServerHandlerExecution() {
    }

    public static void businessExecution(Channel clientChannel, WebSocketFrame webSocketFrame) {
        WebsocketBusinessThreadExecution businessThreadExecution = new WebsocketBusinessThreadExecution (clientChannel, webSocketFrame);
        ThreadPoolExecutor businessThreadPool = ThreadPoolFactoryConstant.WEBSOCKET_SERVER_BUSINESS_THREAD_POOL;
        ThreadPoolFactoryExecution.statsThread (businessThreadPool, businessThreadExecution);
    }
}
