package com.dappervision.wearscript_tagalong.dataproviders;

import com.dappervision.wearscript_tagalong.managers.DataManager;

public abstract class DataProvider {
    protected DataManager parent;
    protected long samplePeriod;
    private long lastTimestamp;
    private int type;
    private String name;

    DataProvider(DataManager parent, long samplePeriod, int type, String name) {
        this.parent = parent;
        this.samplePeriod = samplePeriod;
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public void unregister() {
        this.parent = null;
    }

    public void remoteSample(DataPoint dp) {
        if (!useSample(dp.timestampRaw))
            return;
        parent.queue(dp);
    }

    protected boolean useSample(long timestamp) {
        if (timestamp - lastTimestamp < samplePeriod)
            return false;
        lastTimestamp = timestamp;
        return true;
    }
}