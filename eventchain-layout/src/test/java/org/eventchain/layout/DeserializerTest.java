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
package org.eventchain.layout;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class DeserializerTest {

    public class NoEmptyConstructor {
        @Getter @Setter
        private String test;
    }

    @Test(expectedExceptions = Deserializer.NoEmptyConstructorException.class)
    @SneakyThrows
    public void noEmptyConstuctor() {
        new Deserializer<>(new Layout<>(NoEmptyConstructor.class));
    }
}