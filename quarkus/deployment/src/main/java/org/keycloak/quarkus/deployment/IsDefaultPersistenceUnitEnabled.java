/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.quarkus.deployment;

import static org.keycloak.quarkus.runtime.configuration.Configuration.getOptionalBooleanValue;

import java.util.function.BooleanSupplier;
import org.keycloak.quarkus.runtime.Environment;

public class IsDefaultPersistenceUnitEnabled implements BooleanSupplier {

    @Override
    public boolean getAsBoolean() {
        return getOptionalBooleanValue("kc.storage-default-persistence-unit-enabled").get();
    }

}
