/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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

package org.keycloak.events.admin;

import org.keycloak.storage.SearchableModelField;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class AdminEvent {

    public static class SearchableFields {
        public static final SearchableModelField<AdminEvent> ID              = new SearchableModelField<>("id", String.class);
        public static final SearchableModelField<AdminEvent> REALM_ID        = new SearchableModelField<>("realmId", String.class);
        public static final SearchableModelField<AdminEvent> TIMESTAMP       = new SearchableModelField<>("timestamp", Long.class);
        public static final SearchableModelField<AdminEvent> AUTH_REALM_ID   = new SearchableModelField<>("authRealmId", String.class);
        public static final SearchableModelField<AdminEvent> AUTH_CLIENT_ID  = new SearchableModelField<>("authClientId", String.class);
        public static final SearchableModelField<AdminEvent> AUTH_USER_ID    = new SearchableModelField<>("authUserId", String.class);
        public static final SearchableModelField<AdminEvent> AUTH_IP_ADDRESS = new SearchableModelField<>("authIpAddress", String.class);
        public static final SearchableModelField<AdminEvent> OPERATION_TYPE  = new SearchableModelField<>("operationType", OperationType.class);
        public static final SearchableModelField<AdminEvent> RESOURCE_TYPE   = new SearchableModelField<>("resourceType", String.class);
        public static final SearchableModelField<AdminEvent> RESOURCE_PATH   = new SearchableModelField<>("resourcePath", String.class);
    }

    private String id;

    private long time;
    
    private String realmId;

    private AuthDetails authDetails;

    /**
     * The resource type an AdminEvent was triggered for.
     */
    private String resourceType;

    private OperationType operationType;

    private String resourcePath;

    private String representation;

    private String error;
    
    public AdminEvent() {}
    public AdminEvent(AdminEvent toCopy) {
        this.id = toCopy.getId();
        this.time = toCopy.getTime();
        this.realmId = toCopy.getRealmId();
        this.authDetails = new AuthDetails(toCopy.getAuthDetails());
        this.resourceType = toCopy.getResourceType();
        this.operationType = toCopy.getOperationType();
        this.resourcePath = toCopy.getResourcePath();
        this.representation = toCopy.getRepresentation();
        this.error = toCopy.getError();
    }

    /**
     * Returns the UUID of the event.
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the time of the event
     *
     * @return time in millis
     */
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    /**
     * Returns the id of the realm
     *
     * @return
     */
    public String getRealmId() {
        return realmId;
    }

    public void setRealmId(String realmId) {
        this.realmId = realmId;
    }

    /**
     * Returns authentication details
     *
     * @return
     */
    public AuthDetails getAuthDetails() {
        return authDetails;
    }

    public void setAuthDetails(AuthDetails authDetails) {
        this.authDetails = authDetails;
    }

    /**
     * Returns the type of the operation
     *
     * @return
     */
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    /**
     * Returns the path of the resource. For example:
     * <ul>
     *     <li><b>realms</b> - realm list</li>
     *     <li><b>realms/master</b> - master realm</li>
     *     <li><b>realms/clients/00d4b16f-f1f9-4e73-8366-d76b18f3e0e1</b> - client within the master realm</li>
     * </ul>
     *
     * @return
     */
    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    /**
     * Returns the updated JSON representation if <code>operationType</code> is <code>CREATE</code> or <code>UPDATE</code>.
     * Otherwise returns <code>null</code>.
     *
     * @return
     */
    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    /**
     * If the event was unsuccessful returns the error message. Otherwise returns <code>null</code>.
     *
     * @return
     */
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     * Returns the type of the affected {@link ResourceType} for this {@link AdminEvent}, e.g. {@link ResourceType#USER USER}, {@link ResourceType#GROUP GROUP} etc.
     *
     * @return
     */
    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}
