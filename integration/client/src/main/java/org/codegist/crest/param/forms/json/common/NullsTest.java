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

package org.codegist.crest.param.forms.json.common;

import org.codegist.crest.annotate.*;
import org.codegist.crest.entity.JsonEntityWriter;
import org.codegist.crest.param.common.INullsTest;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author laurent.gilles@codegist.org
 */
public class NullsTest extends INullsTest<NullsTest.Nulls> {

    public NullsTest(CRestHolder crest) {
        super(crest, Nulls.class);
    }

    @Parameterized.Parameters
    public static Collection<CRestHolder[]> getData() {
        return crest(byJsonSerializersAndRestServices());
    }

    @EndPoint("{crest.server.end-point}")
    @Path("params/form/json")
    @POST
    @EntityWriter(JsonEntityWriter.class)
    public static interface Nulls extends INullsTest.INulls {

        String nulls(
                @FormParam("p1") String p1,
                @FormParam("p2") Collection<String> p2,
                @FormParam("p3") String[] p3);

        String merging(
                @FormParam("p1") String p1,
                @FormParam("p2") @ListSeparator("(p2)") Collection<String> p2,
                @FormParam("p3") @ListSeparator("(p3)") String[] p3);


    }

    @Override
    public void assertNulls(String actual) {
        assertEquals("{}", actual);
    }

    @Override
    public void assertNullsMerging(String actual) {
        assertEquals("{}", actual);
    }
}
