/**
 * SkillAPI
 * com.sucy.skill.dynamic.mechanic.FlagMechanic
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
package com.sucy.skill.dynamic.mechanic;

import com.sucy.skill.api.util.FlagManager;
import org.bukkit.entity.LivingEntity;

import java.util.List;

/**
 * Applies a flag to each target
 */
public class FlagMechanic extends MechanicComponent {
    private static final String KEY     = "key";
    private static final String SECONDS = "seconds";

    @Override
    public String getKey() {
        return "flag";
    }

    /**
     * Executes the component
     *
     * @param caster  caster of the skill
     * @param level   level of the skill
     * @param targets targets to apply to
     *
     * @param force
     * @return true if applied to something, false otherwise
     */
    @Override
    public boolean execute(LivingEntity caster, int level, List<LivingEntity> targets, boolean force) {
        if (targets.size() == 0 || !settings.has(KEY)) {
            return false;
        }

        String key     = settings.getString(KEY);
        double seconds = parseValues(caster, SECONDS, level, 3.0);
        int    ticks   = (int) (seconds * 20);
        for (LivingEntity target : targets) {
            FlagManager.addFlag(target, key, ticks);
        }
        return targets.size() > 0;
    }
}
