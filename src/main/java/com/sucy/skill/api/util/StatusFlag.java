/**
 * SkillAPI
 * com.sucy.skill.api.util.StatusFlag
 * <p>
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2014 Steven Sucy
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software") to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sucy.skill.api.util;

/**
 * Flag keys used by statuses
 */
public class StatusFlag {
    public static final String STUN       = "stun";
    public static final String ROOT       = "root";
    public static final String INVINCIBLE = "invincible";
    public static final String ABSORB     = "absorb";
    public static final String DISARM     = "disarm";
    public static final String SILENCE    = "silence";
    public static final String CHANNELING = "channeling";
    public static final String CHANNEL    = "channel";

    public static final String[] ALL = new String[]{
            STUN, ROOT, INVINCIBLE, ABSORB, DISARM, SILENCE, CHANNELING
    };

    public static final String[] NEGATIVE = new String[]{
            STUN, ROOT, DISARM, SILENCE
    };

    public static final String[] POSITIVE = new String[]{
            INVINCIBLE, ABSORB
    };
}
