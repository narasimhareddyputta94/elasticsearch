/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */
package org.elasticsearch.xpack.esql.core.querydsl.container;

import org.elasticsearch.xpack.esql.core.expression.Attribute;

import java.util.Objects;

public class AttributeSort extends Sort {

    private final Attribute attribute;

    public AttributeSort(Attribute attribute, Direction direction, Missing missing) {
        super(direction, missing);
        this.attribute = attribute;
    }

    public Attribute attribute() {
        return attribute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attribute, direction(), missing());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        AttributeSort other = (AttributeSort) obj;
        return Objects.equals(direction(), other.direction())
            && Objects.equals(missing(), other.missing())
            && Objects.equals(attribute, other.attribute);
    }
}
