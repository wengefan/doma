/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.internal.apt.entity;

import java.util.List;
import java.util.Map;

import org.seasar.doma.jdbc.entity.AbstractEntityType;
import org.seasar.doma.jdbc.entity.BasicPropertyType;
import org.seasar.doma.jdbc.entity.EntityPropertyType;
import org.seasar.doma.jdbc.entity.GeneratedIdPropertyType;
import org.seasar.doma.jdbc.entity.NamingType;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;
import org.seasar.doma.jdbc.entity.Accessor;
import org.seasar.doma.jdbc.entity.VersionPropertyType;
import org.seasar.doma.wrapper.IntegerWrapper;

public class _OriginalStatesParentEntity extends
        AbstractEntityType<OriginalStatesParentEntity> {

    public BasicPropertyType<Object, OriginalStatesParentEntity, Integer, Integer> $aaa = new BasicPropertyType<>(
            OriginalStatesParentEntity.class, Integer.class, Integer.class,
            IntegerWrapper.class, null, null, "aaa", "AAA", true, true);

    public BasicPropertyType<Object, OriginalStatesParentEntity, Integer, Integer> $bbb = new BasicPropertyType<>(
            OriginalStatesParentEntity.class, Integer.class, Integer.class,
            IntegerWrapper.class, null, null, "bbb", "BBB", true, true);

    private _OriginalStatesParentEntity() {
    }

    @Override
    public void saveCurrentStates(OriginalStatesParentEntity entity) {
    }

    @Override
    public String getCatalogName() {

        return null;
    }

    @Override
    public Class<OriginalStatesParentEntity> getEntityClass() {

        return null;
    }

    @Override
    public EntityPropertyType<OriginalStatesParentEntity, ?, ?> getEntityPropertyType(
            String name) {

        return null;
    }

    @Override
    public List<EntityPropertyType<OriginalStatesParentEntity, ?, ?>> getEntityPropertyTypes() {

        return null;
    }

    @Override
    public GeneratedIdPropertyType<Object, OriginalStatesParentEntity, ?, ?> getGeneratedIdPropertyType() {

        return null;
    }

    @Override
    public String getName() {

        return null;
    }

    @Override
    public OriginalStatesParentEntity getOriginalStates(
            OriginalStatesParentEntity entity) {

        return null;
    }

    @Override
    public String getSchemaName() {

        return null;
    }

    @Override
    public String getTableName() {

        return null;
    }

    @Override
    public VersionPropertyType<Object, OriginalStatesParentEntity, ?, ?> getVersionPropertyType() {

        return null;
    }

    @Override
    public void preDelete(OriginalStatesParentEntity entity,
            PreDeleteContext<OriginalStatesParentEntity> context) {
    }

    @Override
    public void preInsert(OriginalStatesParentEntity entity,
            PreInsertContext<OriginalStatesParentEntity> context) {
    }

    @Override
    public void preUpdate(OriginalStatesParentEntity entity,
            PreUpdateContext<OriginalStatesParentEntity> context) {
    }

    @Override
    public void postDelete(OriginalStatesParentEntity entity,
            PostDeleteContext<OriginalStatesParentEntity> context) {
    }

    @Override
    public void postInsert(OriginalStatesParentEntity entity,
            PostInsertContext<OriginalStatesParentEntity> context) {
    }

    @Override
    public void postUpdate(OriginalStatesParentEntity entity,
            PostUpdateContext<OriginalStatesParentEntity> context) {
    }

    @Override
    public List<EntityPropertyType<OriginalStatesParentEntity, ?, ?>> getIdPropertyTypes() {
        return null;
    }

    @Override
    public String getQualifiedTableName() {
        return null;
    }

    @Override
    public NamingType getNamingType() {
        return null;
    }

    public static _OriginalStatesParentEntity getSingletonInternal() {
        return null;
    }

    @Override
    public boolean isImmutable() {
        return false;
    }

    @Override
    public OriginalStatesParentEntity newEntity(
            Map<String, Accessor<OriginalStatesParentEntity, ?, ?>> args) {
        return null;
    }

}
