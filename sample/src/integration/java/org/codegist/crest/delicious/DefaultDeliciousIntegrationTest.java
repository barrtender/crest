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
 *  ==================================================================
 *
 *  More information at http://www.codegist.org.
 */

package org.codegist.crest.delicious;

import org.codegist.crest.CRest;
import org.codegist.crest.delicious.service.Delicious;
import org.junit.Ignore;

/**
 * @author laurent.gilles@codegist.org
 */
@Ignore
public class DefaultDeliciousIntegrationTest extends AbstractDeliciousIntegrationTest {

    public DefaultDeliciousIntegrationTest() {
        super(getDelicious());
    }

    private static Delicious getDelicious() {
        CRest crest = getBaseCRestBuilder().build();
        return crest.build(Delicious.class);
    }
}