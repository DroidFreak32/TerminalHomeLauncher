package com.bencarlisle15.terminalhomelauncher.commands.main.raw;

/*Copyright Francesco Andreuzzi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

import android.content.Intent;
import android.net.Uri;

import com.bencarlisle15.terminalhomelauncher.R;
import com.bencarlisle15.terminalhomelauncher.commands.CommandAbstraction;
import com.bencarlisle15.terminalhomelauncher.commands.ExecutePack;
import com.bencarlisle15.terminalhomelauncher.commands.main.MainPack;

public class donate implements CommandAbstraction {

    private final String DONATE_URL = "https://www.paypal.me/fandreuzzi";

    @Override
    public String exec(ExecutePack pack) {
        MainPack info = (MainPack) pack;
        Intent donateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(DONATE_URL));
        info.context.startActivity(donateIntent);
        return info.res.getString(R.string.output_rate);
    }

    @Override
    public int[] argType() {
        return new int[0];
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public int helpRes() {
        return R.string.help_donate;
    }

    @Override
    public String onArgNotFound(ExecutePack info, int index) {
        return null;
    }

    @Override
    public String onNotArgEnough(ExecutePack info, int nArgs) {
        return null;
    }
}