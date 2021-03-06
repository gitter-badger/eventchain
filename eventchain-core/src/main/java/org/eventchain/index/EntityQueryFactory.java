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
package org.eventchain.index;

import com.googlecode.cqengine.attribute.*;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.query.option.QueryOptions;
import com.googlecode.cqengine.query.simple.SimpleQuery;
import org.eventchain.Entity;
import org.eventchain.EntityHandle;

import java.util.Collections;

public class EntityQueryFactory {

    public static class All<O extends Entity> extends SimpleQuery<EntityHandle<O>, O> {

        final Class<O> attributeType;

        public All(Class<O> attributeType) {
            super(new Attribute<EntityHandle<O>, O>() {
                @Override
                public Class<EntityHandle<O>> getObjectType() {
                    return null;
                }

                @Override
                public Class<O> getAttributeType() {
                    return attributeType;
                }

                @Override
                public String getAttributeName() {
                    return "true";
                }

                @Override
                public Iterable<O> getValues(EntityHandle<O> object, QueryOptions queryOptions) {
                    return Collections.singletonList(object.get().get());
                }
            });
            this.attributeType = attributeType;
        }


        @Override
        protected boolean matchesSimpleAttribute(com.googlecode.cqengine.attribute.SimpleAttribute<EntityHandle<O>, O> attribute, EntityHandle<O> object, QueryOptions queryOptions) {
            return true;
        }

        @Override
        protected boolean matchesNonSimpleAttribute(Attribute<EntityHandle<O>, O> attribute, EntityHandle<O> object, QueryOptions queryOptions) {
            return true;
        }

        @Override
        protected int calcHashCode() {
            return 3866481; // chosen randomly
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof All)) return false;
            All that = (All) o;
            return this.attributeType.equals(that.attributeType);
        }

        @Override
        public String toString() {
            return "all(" + super.getAttribute().getAttributeType().getSimpleName() + ".class)";
        }
    }

    /**
     * Creates a query which matches all objects in the collection.
     * <p/>
     * This is equivalent to a literal boolean 'true'.
     *
     * @param <O> The type of the objects in the collection
     * @return A query which matches all objects in the collection
     */
    public static <O extends Entity> Query<EntityHandle<O>> all(Class<O> objectType) {
        return new All<>(objectType);
    }

}
