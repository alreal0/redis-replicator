/*
 * Copyright 2016 leon chen
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
 * limitations under the License.
 */

package com.moilioncircle.redis.replicator.cmd.impl;

import com.moilioncircle.redis.replicator.cmd.Command;
import com.moilioncircle.redis.replicator.cmd.CommandName;
import com.moilioncircle.redis.replicator.cmd.CommandParser;

import java.util.Arrays;

/**
 * Created by leon on 8/14/16.
 */
public class ExistsParser implements CommandParser<ExistsParser.ExistsCommand> {
    @Override
    public ExistsCommand parse(CommandName cmdName, Object[] params) {
        String[] keys = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            keys[i] = (String) params[i];
        }
        return new ExistsCommand(keys);
    }

    public static class ExistsCommand implements Command {
        public final String[] keys;

        public ExistsCommand(String... keys) {
            this.keys = keys;
        }

        @Override
        public String toString() {
            return "ExistsCommand{" +
                    "keys=" + Arrays.toString(keys) +
                    '}';
        }

        @Override
        public CommandName name() {
            return CommandName.name("EXISTS");
        }
    }
}
