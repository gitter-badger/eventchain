/**
 * Copyright 2016 Eventchain team
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
 */
package boguspackage;

import com.googlecode.cqengine.query.option.QueryOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.eventchain.Event;
import org.eventchain.annotations.Index;
import org.eventchain.index.SimpleAttribute;

import static org.eventchain.index.IndexEngine.IndexFeature.EQ;
import static org.eventchain.index.IndexEngine.IndexFeature.SC;

@Accessors(fluent = true)
public class BogusEvent extends Event {
    @Getter @Setter
    private String string = "bogus";

    @Index({EQ, SC})
    public static SimpleAttribute<BogusEvent, String> ATTR = new SimpleAttribute<BogusEvent, String>() {
        @Override
        public String getValue(BogusEvent object, QueryOptions queryOptions) {
            return object.string();
        }
    };
}
