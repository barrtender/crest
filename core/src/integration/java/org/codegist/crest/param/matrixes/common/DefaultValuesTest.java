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

package org.codegist.crest.param.matrixes.common;

import org.codegist.crest.CRest;
import org.codegist.crest.annotate.*;
import org.codegist.crest.param.common.IDefaultValuesTest;

/**
 * @author laurent.gilles@codegist.org
 */
public class DefaultValuesTest extends IDefaultValuesTest<DefaultValuesTest.DefaultValues> {

    public DefaultValuesTest(CRest crest) {
        super(crest, DefaultValues.class);
    }

    @EndPoint(ADDRESS)
    @Path("params/matrix/default-value")
    @GET
    public static interface DefaultValues extends IDefaultValuesTest.IDefaultValues {

        @Path("value")
        String value(
                @MatrixParam(value="p1", defaultValue = "default-p1") String p1,
                @MatrixParam(value="p2", defaultValue = "123") Integer p2);

        @MatrixParam(value="p2", defaultValue = "p2-val")
        @MatrixParams({
                @MatrixParam(value="p1", defaultValue = "p1-val"),
                @MatrixParam(value="p3", defaultValue = "p3-val")
        })
        @Path("param")
        String param(@MatrixParam("p1") String p1);

    }
}