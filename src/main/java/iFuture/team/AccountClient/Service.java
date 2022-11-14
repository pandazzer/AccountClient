package iFuture.team.AccountClient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private ConfigFileEntity readConfig(){
        ConfigFileEntity result;
        List<String> listValue = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resource/config.csv"));
            while (reader.ready()){
                String[] parameter = reader.readLine().split("=");
                listValue.add(parameter[1]);
            }
            result = new ConfigFileEntity(listValue.get(0), listValue.get(1), listValue.get(2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void execute(){
        ConfigFileEntity configFileEntity = readConfig();
        int rCount = configFileEntity.rCount;
        int wCount = configFileEntity.wCount;
        List<Integer> idList = configFileEntity.idList;
        int i = 0;
        while (rCount > 0){
            new StreamAddAmount(idList.get(i), 1111111L).start();
            i++;
            rCount--;
        }
        i = 0;
        while (wCount > 0){
            new StreamGetAmount(i).start();
            i++;
            wCount--;
        }
    }
}
