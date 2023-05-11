package com.s8.io.bohr.beryllium.fields.primitives;

import com.s8.io.bohr.beryllium.fields.BeFieldDelta;
import com.s8.io.bohr.beryllium.object.BeObject;
import com.s8.io.bytes.alpha.MemoryFootprint;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class StringBeFieldDelta extends BeFieldDelta {


	public final StringBeField field;

	public final String value;

	public StringBeFieldDelta(StringBeField field, String value) {
		super();
		this.field = field;
		this.value = value;
	}

	@Override 
	public StringBeField getField() { 
		return field;
	}


	@Override
	public void consume(BeObject object) throws IllegalArgumentException, IllegalAccessException {
		field.field.set(object, value);
	}

	@Override
	public void computeFootprint(MemoryFootprint weight) {
		if(value!=null) {
			weight.reportInstance();
			weight.reportBytes(value.length());
		}
	}

}
