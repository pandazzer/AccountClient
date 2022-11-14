package iFuture.team.AccountClient;

import java.util.ArrayList;
import java.util.List;

public class ConfigFileEntity {
    int rCount;
    int wCount;
    List<Integer> idList = new ArrayList<>();

    public void setrCount(int rCount) {
        this.rCount = rCount;
    }

    public void setwCount(int wCount) {
        this.wCount = wCount;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public ConfigFileEntity(String rCount, String wCount, String idList) {
        this.rCount = Integer.parseInt(rCount);
        this.wCount = Integer.parseInt(wCount);
        String[] range = idList.split("-");
        for (int i = Integer.parseInt(range[0]); i <= Integer.parseInt(range[1]); i++) {
            this.idList.add(i);
        }

    }
}
