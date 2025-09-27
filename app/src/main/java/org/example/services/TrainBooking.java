package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.entities.Train;
import org.example.util.Jsonutil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TrainBooking {
    private static final File TRAIN_DB = new File("data/trains.json");
    private List<Train> trains;

    public TrainBooking() {
        this.trains = Jsonutil.read(TRAIN_DB, new TypeReference<List<Train>>() {}, new ArrayList<>());
    }

    public List<Train> searchTrains(String source, String destination) {
        String src = source.toLowerCase(Locale.ROOT);
        String dst = destination.toLowerCase(Locale.ROOT);

        return trains.stream()
                .filter(train -> {
                    List<String> lower = train.getstation().stream()
                            .map(s -> s.toLowerCase(Locale.ROOT)).collect(Collectors.toList());
                    int si = lower.indexOf(src);
                    int di = lower.indexOf(dst);
                    return si != -1 && di != -1 && si < di;
                })
                .collect(Collectors.toList());
    }

    public void upsertTrain(Train t) {
        int idx = -1;
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getTrainid().equalsIgnoreCase(t.getTrainid())) {
                idx = i; break;
            }
        }
        if (idx == -1) trains.add(t);
        else trains.set(idx, t);
        persist();
    }

    public void persist() { Jsonutil.write(TRAIN_DB, trains); }

    public List<Train> all() { return trains; }
}
