package com.p8499.lang.gen;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = FilterDeserializer.class)
@JsonSerialize(using = FilterSerializer.class)
public interface FilterExpr {}
