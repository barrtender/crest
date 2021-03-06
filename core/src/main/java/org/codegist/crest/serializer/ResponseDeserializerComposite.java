/*
 * Copyright 2011 CodeGist.org
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 *  ===================================================================
 *
 *  More information at http://www.codegist.org.
 */

package org.codegist.crest.serializer;

import org.codegist.common.log.Logger;
import org.codegist.crest.CRestException;
import org.codegist.crest.io.Response;

/**
 * <p>Loops over a list of response deserializers until first success.</p>
 * <p>Loops as long as IllegalArgumentException is thrown (meaning a given response deserializer is not able to deserialize the response)</p>
 * @author Laurent Gilles (laurent.gilles@codegist.org)
 */
public class ResponseDeserializerComposite implements ResponseDeserializer {

    private static final Logger LOG = Logger.getLogger(ResponseDeserializer.class);
    private final ResponseDeserializer[] delegates;

    /**
     * @param delegates response deserializers to use
     */
    public ResponseDeserializerComposite(ResponseDeserializer... delegates) {
        this.delegates = delegates.clone();
    }

    /**
     * @inheritDoc
     */
    public <T> T deserialize(Response response) throws Exception {
        IllegalArgumentException deserializationException = null;
        for(ResponseDeserializer deserializer : delegates){
            try {
                return deserializer.<T>deserialize(response);
            } catch (IllegalArgumentException e) {
                LOG.trace("Deserializer %s can't handle response, trying with next one", deserializer);
                deserializationException = e;
            }
        }
        LOG.debug(deserializationException, "Cannot deserialize response with given deserialize list: %s. Last exception: %s", delegates, deserializationException.getMessage());
        throw new CRestException(deserializationException.getMessage(), deserializationException);
    }
}
