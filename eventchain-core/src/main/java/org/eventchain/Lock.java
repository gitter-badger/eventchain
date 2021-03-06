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
package org.eventchain;

/**
 * Simple lock interface to be used for synchronization in Eventchain applications.
 */
public interface Lock {

    /**
     * Unlocks the lock
     */
    void unlock();

    /**
     * @return true if the lock is locked
     */
    @SuppressWarnings("unused")
    boolean isLocked();
}
