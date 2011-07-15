/*
 * Copyright 2008-2010 Digital Enterprise Research Institute (DERI)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.deri.any23.extractor;

import junit.framework.Assert;
import org.deri.any23.extractor.example.ExampleExtractor;
import org.deri.any23.rdf.RDFUtils;
import org.deri.any23.writer.CountingTripleHandler;
import org.junit.Test;
import org.openrdf.model.URI;

/**
 * Tests the <i>extraction</i> scenario.
 */
public class ExtractionAPITest {

    private static final String exampleDoc = "http://example.com/";
    private static final URI uri           = RDFUtils.uri(exampleDoc);

    @Test
    public void testDirectInstantiation() throws Exception {
        CountingTripleHandler out   = new CountingTripleHandler();
        ExampleExtractor extractor  = new ExampleExtractor();
        ExtractionResultImpl writer = new ExtractionResultImpl(uri, extractor, out);
        extractor.run(ExtractionParameters.DEFAULT, uri, uri, writer);
        writer.close();
        Assert.assertEquals(1, out.getCount());
    }
    
}
