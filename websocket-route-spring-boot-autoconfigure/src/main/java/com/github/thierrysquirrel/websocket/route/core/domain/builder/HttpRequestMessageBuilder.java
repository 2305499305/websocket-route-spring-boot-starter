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
package com.github.thierrysquirrel.websocket.route.core.domain.builder;

import com.github.thierrysquirrel.websocket.route.core.domain.HttpRequestMessage;
import io.netty.handler.codec.http.HttpHeaders;

import java.util.Map;

/**
 * ClassName: HttpRequestMessageBuilder
 * Description:
 * date: 2020/8/18 5:45
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class HttpRequestMessageBuilder {
    private HttpRequestMessageBuilder() {
    }

    public static HttpRequestMessage builderHttpRequestMessage(String uri,
                                                               Map<String, String> uriParam,
                                                               HttpHeaders headers) {
        HttpRequestMessage requestMessage = new HttpRequestMessage ();
        requestMessage.setUri (uri);
        requestMessage.setUriParam (uriParam);
        requestMessage.setHeaders (headers);
        return requestMessage;
    }
}
