/*
 * Copyright 2010 CodeGist.org
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

package org.codegist.crest.config.annotate;

import org.codegist.crest.annotate.Serializer;
import org.codegist.crest.serializer.ToStringSerializer;
import org.junit.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Laurent Gilles (laurent.gilles@codegist.org)
 */
public class SerializerAnnotationHandlerTest extends AnnotationBaseTest<Serializer> {

    private final SerializerAnnotationHandler toTest = new SerializerAnnotationHandler();

    public SerializerAnnotationHandlerTest() {
        super(Serializer.class);
    }

    @Test
    public void handleInterfaceAnnotationShouldSetParamsSerializer() throws Exception {
        when(mockAnnotation.value()).thenReturn((Class)ToStringSerializer.class);
        toTest.handleInterfaceAnnotation(mockAnnotation, mockInterfaceConfigBuilder);
        verify(mockAnnotation).value();
        verify(mockInterfaceConfigBuilder).setParamsSerializer(ToStringSerializer.class);
    }

    @Test
    public void handleMethodsAnnotationShouldSetSerializer() throws Exception {
        when(mockAnnotation.value()).thenReturn((Class)ToStringSerializer.class);
        toTest.handleMethodAnnotation(mockAnnotation, mockMethodConfigBuilder);
        verify(mockAnnotation).value();
        verify(mockMethodConfigBuilder).setParamsSerializer(ToStringSerializer.class);
    }

    @Test
    public void handleParametersAnnotationShouldSetSerializer() throws Exception {
        when(mockAnnotation.value()).thenReturn((Class)ToStringSerializer.class);
        toTest.handleParameterAnnotation(mockAnnotation, mockParamConfigBuilder);
        verify(mockAnnotation).value();
        verify(mockParamConfigBuilder).setSerializer(ToStringSerializer.class);
    }

    @Override
    public AnnotationHandler<Serializer> getToTest() {
        return toTest;
    }
}
