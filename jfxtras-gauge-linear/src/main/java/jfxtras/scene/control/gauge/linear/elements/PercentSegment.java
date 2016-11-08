/**
 * PercentSegment.java
 *
 * Copyright (c) 2011-2016, JFXtras
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the organization nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package jfxtras.scene.control.gauge.linear.elements;

import jfxtras.scene.control.gauge.linear.AbstractLinearGauge;

public class PercentSegment implements Segment {

	final private String id;
	final private double minPercent;
	final private double maxPercent;
	final private AbstractLinearGauge<?> linearGauge;

	public PercentSegment(AbstractLinearGauge<?> linearGauge, double minPercent, double maxPercent, String id) {
		this.id = id;
		this.minPercent = minPercent;
		this.maxPercent = maxPercent;
		this.linearGauge = linearGauge;
	}
	
	public PercentSegment(AbstractLinearGauge<?> linearGauge, double minPercent, double maxPercent) {
		this.id = null;
		this.minPercent = minPercent;
		this.maxPercent = maxPercent;
		this.linearGauge = linearGauge;
	}
	
	/* (non-Javadoc)
	 * @see jfxtras.labs.scene.control.gauge.linear.Segment#getId()
	 */
	@Override
	public String getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see jfxtras.labs.scene.control.gauge.linear.Segment#getMin()
	 */
	@Override
	public double getMinValue() {
		double minValue = linearGauge.getMinValue();
		double maxValue = linearGauge.getMaxValue();
		return minValue + ((maxValue - minValue) * minPercent / 100.0);
	}
	
	/* (non-Javadoc)
	 * @see jfxtras.labs.scene.control.gauge.linear.Segment#getMax()
	 */
	@Override
	public double getMaxValue() {
		double minValue = linearGauge.getMinValue();
		double maxValue = linearGauge.getMaxValue();
		return minValue + ((maxValue - minValue) * maxPercent / 100.0);
	}
}
