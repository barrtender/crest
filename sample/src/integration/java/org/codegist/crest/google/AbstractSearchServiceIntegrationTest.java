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

package org.codegist.crest.google;

import org.codegist.crest.CRestBuilder;
import org.codegist.crest.google.model.Address;
import org.codegist.crest.google.model.SearchResult;
import org.codegist.crest.google.service.SearchService;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author laurent.gilles@codegist.org
 */
@Ignore
public abstract class AbstractSearchServiceIntegrationTest {
    private final SearchService searchService;

    public AbstractSearchServiceIntegrationTest(SearchService searchService) {
        this.searchService = searchService;
    }

    @Test
    public void testSearch(){
        SearchResult<Address> result = searchService.search("google");
        assertNotNull(result);
        assertNotNull(result.getResults());
    }

    protected static CRestBuilder getBaseCRestBuilder(){
        return new CRestBuilder();
    }
}
